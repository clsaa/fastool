package com.echoclsaa.fastool.basic.exception;


import com.echoclsaa.fastool.basic.constants.HttpStatus;
import com.echoclsaa.fastool.basic.lang.BizCode;

/**
 * unauthorized exception
 *
 * @author clsaa 2020-08-03
 **/
public class StandardBusinessException extends AbstractStandardException {

    public StandardBusinessException() {
        super(HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(String message) {
        super(message, HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(Throwable e) {
        super(e, HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(String message, Throwable e) {
        super(message, e, HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(String message, BizCode bizCode, Throwable e) {
        super(message, bizCode, e, HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(BizCode bizCode, Throwable e) {
        super(bizCode, e, HttpStatus.EXPECTATION_FAILED);
    }

    public StandardBusinessException(BizCode bizCode, Throwable e, Object... userMessageParams) {
        super(bizCode, e, HttpStatus.EXPECTATION_FAILED, userMessageParams);
    }
}
