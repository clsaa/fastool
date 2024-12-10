package com.echoclsaa.fastool.logger.factory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import com.echoclsaa.fastool.basic.constants.ConstValues;
import com.echoclsaa.fastool.logger.LogbackLogger;
import com.echoclsaa.fastool.logger.Logger;
import com.echoclsaa.fastool.logger.config.LoggerFactoryConfig;

import java.net.URL;

/**
 * Logback
 *
 * @author clsaa
 */
public class LogbackLoggerFactory implements LoggerFactory {
    private static LoggerContext loggerContext;

    private static final String defaultResourcePath = "/logback.xml";

    public LogbackLoggerFactory(LoggerFactoryConfig config) throws Exception {
        loggerContext = new LoggerContext();
        loggerContext.setName(config.getName());
        loggerContext.reset();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(loggerContext);

        URL url;
        if (config.getConfigResourcePath() != null) {
            url = Log4j2LoggerFactory.class.getResource(config.getConfigResourcePath());
        } else {
            url = Log4j2LoggerFactory.class.getResource(defaultResourcePath);
        }

        configurator.doConfigure(url);
    }

    @Override
    public Logger getLogger(String name) {
        return new LogbackLogger(loggerContext.getLogger(name));
    }
}
