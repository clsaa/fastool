package com.echoclsaa.fastool.basic.function;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author clsaa
 */
public interface Fn<T, R> extends Function<T, R>, Serializable {
}
