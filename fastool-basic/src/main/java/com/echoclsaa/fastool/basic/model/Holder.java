package com.echoclsaa.fastool.basic.model;

/**
 * Holder
 *
 * @author clsaa
 */
public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
