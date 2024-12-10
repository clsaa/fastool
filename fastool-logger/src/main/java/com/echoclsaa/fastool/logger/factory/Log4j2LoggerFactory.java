package com.echoclsaa.fastool.logger.factory;

import com.echoclsaa.fastool.logger.Log4j2Logger;
import com.echoclsaa.fastool.logger.Logger;
import com.echoclsaa.fastool.logger.config.LoggerFactoryConfig;
import org.apache.logging.log4j.LogManager;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Log4j2
 *
 * @author clsaa
 */
public class Log4j2LoggerFactory implements LoggerFactory {

    private static org.apache.logging.log4j.spi.LoggerContext LOG_CONTEXT;

    private static final String defaultResourcePath = "/log4j2.xml";

    public Log4j2LoggerFactory(LoggerFactoryConfig config) throws Exception {
        Class.forName("org.apache.logging.log4j.core.Logger");
        URL url;
        if (config.getConfigResourcePath() != null) {
            url = Log4j2LoggerFactory.class.getResource(config.getConfigResourcePath());
        } else {
            url = Log4j2LoggerFactory.class.getResource(defaultResourcePath);
        }

        LOG_CONTEXT = LogManager.getContext(new MyClassLoader(new URL[]{},
                Thread.currentThread().getContextClassLoader()), false, null, url.toURI());
    }

    @Override
    public Logger getLogger(String name) {
        return new Log4j2Logger(LOG_CONTEXT.getLogger(name));
    }

    public static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }
}
