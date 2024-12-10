package com.echoclsaa.fastool.basic.convert.impl;


import com.echoclsaa.fastool.basic.convert.AbstractConverter;
import com.echoclsaa.fastool.basic.utils.BooleanUtils;
import com.echoclsaa.fastool.basic.utils.StringUtils;

/**
 * 字符转换器
 *
 * @author clsaa
 */
public class CharacterConverter extends AbstractConverter<Character> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Character convertInternal(Object value) {
        if (value == null) {
            return null;
        }

        if (Character.class == value.getClass()) {
            return (Character) value;
        } else if (value instanceof Boolean) {
            return BooleanUtils.toCharacter((Boolean) value);
        } else {
            final String valueStr = convertToStr(value);
            if (StringUtils.isNotBlank(valueStr)) {
                return valueStr.charAt(0);
            }
        }
        return null;
    }

}
