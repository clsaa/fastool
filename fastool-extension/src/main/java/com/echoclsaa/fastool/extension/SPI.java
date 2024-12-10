package com.echoclsaa.fastool.extension;

import java.lang.annotation.*;

/**
 * Marker for extension interface
 * @author chendu
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SPI {

    /**
     * default extension name
     */
    String value() default "";
}
