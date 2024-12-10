package com.echoclsaa.fastool.basic.exception;


import com.echoclsaa.fastool.basic.constants.HttpStatus;
import com.echoclsaa.fastool.basic.lang.BizCode;

/**
 * Invalid param exception
 *
 * @author clsaa 2020-08-03
 **/
public class InvalidParamException extends AbstractStandardException {

    public InvalidParamException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(Throwable e) {
        super(e, HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(String message, Throwable e) {
        super(message, e, HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(String message, BizCode bizCode, Throwable e) {
        super(message, bizCode, e, HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(BizCode bizCode, Throwable e) {
        super(bizCode, e, HttpStatus.BAD_REQUEST);
    }

    public InvalidParamException(BizCode bizCode, Throwable e, Object... userMessageParams) {
        super(bizCode, e, HttpStatus.BAD_REQUEST, userMessageParams);
    }
}
