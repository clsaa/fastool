package com.echoclsaa.fastool.basic.collections.cache;


import com.echoclsaa.fastool.basic.function.Func0;

import java.io.Serializable;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.StampedLock;

/**
 * 简单缓存，无超时实现，使用{@link WeakHashMap}实现缓存自动清理
 *
 * @param <K> 键类型
 * @param <V> 值类型
 * @author clsaa
 */
public class SimpleCache<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 池
     */
    private final Map<K, V> cache = new WeakHashMap<>();

    // 乐观读写锁
    private final StampedLock lock = new StampedLock();

    /**
     * 从缓存池中查找值
     *
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        long stamp = lock.readLock();
        try {
            return cache.get(key);
        } finally {
            lock.unlockRead(stamp);
        }
    }

    /**
     * 从缓存中获得对象，当对象不在缓存中或已经过期返回Func0回调产生的对象
     *
     * @param key      键
     * @param supplier 如果不存在回调方法，用于生产值对象
     * @return 值对象
     */
    public V get(K key, Func0<V> supplier) {
        if (null == supplier) {
            return get(key);
        }

        long stamp = lock.readLock();
        V v;
        try {
            v = cache.get(key);
            if (null == v) {
                // 尝试转换独占写锁
                long writeStamp = lock.tryConvertToWriteLock(stamp);
                if (0 == writeStamp) {
                    // 转换失败，手动更新为写锁
                    lock.unlockRead(stamp);
                    writeStamp = lock.writeLock();
                }
                stamp = writeStamp;
                v = cache.get(key);
                // 双重检查，防止在竞争锁的过程中已经有其它线程写入
                if (null == v) {
                    try {
                        v = supplier.call();
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                    cache.put(key, v);
                }
            }
        } finally {
            lock.unlock(stamp);
        }
        return v;
    }

    /**
     * 放入缓存
     *
     * @param key   键
     * @param value 值
     * @return 值
     */
    public V put(K key, V value) {
        // 独占写锁
        final long stamp = lock.writeLock();
        try {
            cache.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
        }
        return value;
    }

    /**
     * 移除缓存
     *
     * @param key 键
     * @return 移除的值
     */
    public V remove(K key) {
        // 独占写锁
        final long stamp = lock.writeLock();
        try {
            return cache.remove(key);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    /**
     * 清空缓存池
     */
    public void clear() {
        // 独占写锁
        final long stamp = lock.writeLock();
        try {
            this.cache.clear();
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
