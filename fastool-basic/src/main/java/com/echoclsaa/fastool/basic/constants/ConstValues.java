package com.echoclsaa.fastool.basic.constants;

import java.util.regex.Pattern;

/**
 * Const values
 *
 * @author clsaa
 */
public interface ConstValues {

    Pattern COMMA_SPLIT_PATTERN = Pattern.compile("\\s*[,]+\\s*");

    String PROJECT_NAME = "fastool";

    String PROJECT_LOWER_KEY = "fastool";

    String DEFAULT_KEY = "default";

    String REMOVE_PREFIX = "-";

    String DOT = ".";

    String AT = "@";

    String SUB = "-";

    int MAX_TIMEOUT_TIME_MS = 3 * 60 * 60 * 1000;

}
