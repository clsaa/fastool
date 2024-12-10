package com.echoclsaa.fastool.basic.exception;

import com.echoclsaa.fastool.basic.constants.HttpStatus;

/**
 * 工具类异常
 *
 * @author clsaa
 */
public class UtilException extends AbstractStandardException {
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public UtilException(String message, Throwable e) {
        super(message, e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
