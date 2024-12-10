package com.echoclsaa.fastool.basic.convert.impl;


import com.echoclsaa.fastool.basic.convert.AbstractConverter;
import com.echoclsaa.fastool.basic.utils.BooleanUtils;

/**
 * 布尔转换器
 *
 * @author clsaa
 */
public class BooleanConverter extends AbstractConverter<Boolean> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Boolean convertInternal(Object value) {
        if (null == value) {
            return Boolean.FALSE;
        }
        if (Boolean.class == value.getClass()) {
            return (Boolean) value;
        }
        String valueStr = convertToStr(value);
        return BooleanUtils.toBoolean(valueStr);
    }

}
