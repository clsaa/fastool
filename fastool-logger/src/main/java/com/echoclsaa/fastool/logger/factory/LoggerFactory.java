package com.echoclsaa.fastool.logger.factory;

import com.echoclsaa.fastool.logger.Logger;

/**
 * LoggerFactory接口
 */
public interface LoggerFactory {
    Logger getLogger(String name);
}
