package com.echoclsaa.fastool.basic.function;

/**
 * 无参数和返回的函数对象<br>
 *
 * @author clsaa
 */
@FunctionalInterface
public interface VoidCallback {

    /**
     * 执行
     */
    void call();
}
