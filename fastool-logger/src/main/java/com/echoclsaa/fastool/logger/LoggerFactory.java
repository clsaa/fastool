package com.echoclsaa.fastool.logger;


import com.echoclsaa.fastool.logger.config.LoggerFactoryConfig;
import com.echoclsaa.fastool.logger.factory.*;
import com.echoclsaa.fastool.logger.support.FailsafeLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LoggerFactory
 */
public class LoggerFactory {

    private static com.echoclsaa.fastool.logger.factory.LoggerFactory LOGGER_FACTORY;

    private static Map<String, Logger> loggerCache;

    public static Logger getLogger(String name) {
        Logger logger = loggerCache.get(name);
        if (logger == null) {
            synchronized (LOGGER_FACTORY) {
                logger = loggerCache.get(name);
                if (logger == null) {
                    logger = LOGGER_FACTORY.getLogger(name);
                    loggerCache.put(name, new FailsafeLogger(logger));
                }
            }
        }

        return logger;
    }

    public static Logger getLogger(Class clazz) {
        return getLogger(clazz.getName());
    }


    // 查找常用的日志框架
    static {
        LoggerFactoryConfig config = new LoggerFactoryConfig();
        config.setName(System.getProperty("fastool.logger.name"));
        config.setConfigResourcePath(System.getProperty("fastool.logger.configResourcePath"));
        try {
            LOGGER_FACTORY = new LogbackLoggerFactory(config);
            LogLog.info("Fastool init JM logger with LogbackLoggerFactory success, " + LoggerFactory.class.getClassLoader());
        } catch (Throwable e1) {
            try {
                LOGGER_FACTORY = new Log4jLoggerFactory(config);
                LogLog.info("Fastool init JM logger with Log4jLoggerFactory success, " + LoggerFactory.class.getClassLoader());
            } catch (Throwable e2) {
                try {
                    LOGGER_FACTORY = new Log4j2LoggerFactory(config);
                    LogLog.info("Fastool init JM logger with Log4j2LoggerFactory success, " + LoggerFactory.class.getClassLoader());
                } catch (Throwable e3) {
                    LOGGER_FACTORY = new NopLoggerFactory(config);
                    LogLog.warn("Fastool init JM logger with NopLoggerFactory, pay attention. "
                            + LoggerFactory.class.getClassLoader(), e2);
                }
            }
        }
        loggerCache = new ConcurrentHashMap<>();
    }
}
