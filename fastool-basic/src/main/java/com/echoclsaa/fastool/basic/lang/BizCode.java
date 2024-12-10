package com.echoclsaa.fastool.basic.lang;

import com.echoclsaa.fastool.basic.utils.StringUtils;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Business Code
 *
 * @author clsaa
 **/
@Data
public class BizCode implements Serializable {

    @NonNull
    private String code;

    @NonNull
    private String messageTemplate;

    public BizCode(@NonNull String code, @NonNull String messageTemplate) {
        this.code = code;
        this.messageTemplate = messageTemplate;
    }

    public String parseMessage(Object... params) {
        return StringUtils.format(messageTemplate, params);
    }

}
