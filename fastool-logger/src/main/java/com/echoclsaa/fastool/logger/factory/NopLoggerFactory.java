package com.echoclsaa.fastool.logger.factory;


import com.echoclsaa.fastool.logger.Logger;
import com.echoclsaa.fastool.logger.NopLogger;
import com.echoclsaa.fastool.logger.config.LoggerFactoryConfig;

/**
 * no provider
 *
 * @author clsaa
 */
public class NopLoggerFactory implements LoggerFactory {

    public NopLoggerFactory(LoggerFactoryConfig config) {
    }

    @Override
    public Logger getLogger(String name) {
        return new NopLogger(name);
    }
}
