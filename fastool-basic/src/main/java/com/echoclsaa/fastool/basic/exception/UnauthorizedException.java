package com.echoclsaa.fastool.basic.exception;


import com.echoclsaa.fastool.basic.constants.HttpStatus;
import com.echoclsaa.fastool.basic.lang.BizCode;

/**
 * unauthorized exception
 *
 * @author clsaa 2020-08-03
 **/
public class UnauthorizedException extends AbstractStandardException {

    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(Throwable e) {
        super(e, HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(String message, Throwable e) {
        super(message, e, HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(String message, BizCode bizCode, Throwable e) {
        super(message, bizCode, e, HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(BizCode bizCode, Throwable e) {
        super(bizCode, e, HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(BizCode bizCode, Throwable e, Object... userMessageParams) {
        super(bizCode, e, HttpStatus.UNAUTHORIZED, userMessageParams);
    }
}
