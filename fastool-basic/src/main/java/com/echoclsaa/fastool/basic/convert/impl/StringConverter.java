package com.echoclsaa.fastool.basic.convert.impl;


import com.echoclsaa.fastool.basic.convert.AbstractConverter;

/**
 * 字符串转换器
 *
 * @author clsaa
 */
public class StringConverter extends AbstractConverter<String> {
    private static final long serialVersionUID = 1L;

    @Override
    protected String convertInternal(Object value) {
        return convertToStr(value);
    }

}
