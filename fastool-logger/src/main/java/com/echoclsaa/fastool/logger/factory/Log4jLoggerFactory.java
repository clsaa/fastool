package com.echoclsaa.fastool.logger.factory;

import com.echoclsaa.fastool.logger.Log4jLogger;
import com.echoclsaa.fastool.logger.Logger;
import com.echoclsaa.fastool.logger.config.LoggerFactoryConfig;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RootLogger;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

/**
 * Log4j
 *
 * @author clsaa
 */
public class Log4jLoggerFactory implements LoggerFactory {

    private static LoggerRepository repository;

    private static final String defaultResourcePath = "/log4j.xml";

    public Log4jLoggerFactory(LoggerFactoryConfig config) throws Exception {
        Class.forName("org.apache.log4j.Level");
        URL url;
        if (config.getConfigResourcePath() != null) {
            url = Log4j2LoggerFactory.class.getResource(config.getConfigResourcePath());
        } else {
            url = Log4j2LoggerFactory.class.getResource(defaultResourcePath);
        }
        repository = new Hierarchy(new RootLogger(Level.DEBUG));
        new DOMConfigurator().doConfigure(url, repository);
    }

    @Override
    public Logger getLogger(String name) {
        return new Log4jLogger(repository.getLogger(name));
    }
}
