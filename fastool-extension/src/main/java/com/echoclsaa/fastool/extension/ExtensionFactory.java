package com.echoclsaa.fastool.extension;

/**
 * ExtensionFactory
 *
 * @author clsaa
 */
@SPI("spi")
public interface ExtensionFactory {

    /**
     * Get extension.
     *
     * @param type object type.
     * @param name object name.
     * @return object instance.
     */
    <T> T getExtension(Class<T> type, String name);

}
