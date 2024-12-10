package com.echoclsaa.fastool.basic.exception;


import com.echoclsaa.fastool.basic.constants.HttpStatus;
import com.echoclsaa.fastool.basic.lang.BizCode;

/**
 * Not found exception
 *
 * @author clsaa 2020-08-03
 **/
public class NotFoundException extends AbstractStandardException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(Throwable e) {
        super(e, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message, Throwable e) {
        super(message, e, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message, BizCode bizCode, Throwable e) {
        super(message, bizCode, e, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(BizCode bizCode, Throwable e) {
        super(bizCode, e, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(BizCode bizCode, Throwable e, Object... userMessageParams) {
        super(bizCode, e, HttpStatus.NOT_FOUND, userMessageParams);
    }
}
