package com.echoclsaa.fastool.extension.factory;


import com.echoclsaa.fastool.extension.ExtensionFactory;
import com.echoclsaa.fastool.extension.ExtensionLoader;
import com.echoclsaa.fastool.extension.SPI;

/**
 * SpiExtensionFactory
 *
 * @author clsaa
 */
public class SpiExtensionFactory implements ExtensionFactory {

    @Override
    public <T> T getExtension(Class<T> type, String name) {
        if (type.isInterface() && type.isAnnotationPresent(SPI.class)) {
            ExtensionLoader<T> loader = ExtensionLoader.getExtensionLoader(type);
            if (!loader.getSupportedExtensions().isEmpty()) {
                return loader.getAdaptiveExtension();
            }
        }
        return null;
    }

}
