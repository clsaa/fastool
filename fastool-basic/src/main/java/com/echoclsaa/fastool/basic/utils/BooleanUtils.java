package com.echoclsaa.fastool.basic.utils;


/**
 * Boolean类型相关工具类
 *
 * @author clsaa
 */
public class BooleanUtils {

    /**
     * 表示为真的字符串
     */
    private static final String[] TRUE_ARRAY = {"true", "yes", "y", "t", "ok", "1", "on", "是", "对", "真",};

    /**
     * 取相反值
     *
     * @param bool Boolean值
     * @return 相反的Boolean值
     */
    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * 检查 {@code Boolean} 值是否为 {@code true}
     *
     * <pre>
     *   BooleanUtil.isTrue(Boolean.TRUE)  = true
     *   BooleanUtil.isTrue(Boolean.FALSE) = false
     *   BooleanUtil.isTrue(null)          = false
     * </pre>
     *
     * @param bool 被检查的Boolean值
     * @return 当值为true且非null时返回{@code true}
     */
    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    /**
     * 检查 {@code Boolean} 值是否为 {@code false}
     *
     * <pre>
     *   BooleanUtil.isFalse(Boolean.TRUE)  = false
     *   BooleanUtil.isFalse(Boolean.FALSE) = true
     *   BooleanUtil.isFalse(null)          = false
     * </pre>
     *
     * @param bool 被检查的Boolean值
     * @return 当值为false且非null时返回{@code true}
     */
    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    /**
     * 取相反值
     *
     * @param bool Boolean值
     * @return 相反的Boolean值
     */
    public static boolean negate(boolean bool) {
        return !bool;
    }

    /**
     * 转换字符串为boolean值
     *
     * @param valueStr 字符串
     * @return boolean值
     */
    public static boolean toBoolean(String valueStr) {
        if (StringUtils.isNotBlank(valueStr)) {
            valueStr = valueStr.trim().toLowerCase();
            return ArrayUtils.contains(TRUE_ARRAY, valueStr);
        }
        return false;
    }

    /**
     * boolean值转为int
     *
     * @param value Boolean值
     * @return int值
     */
    public static int toInt(boolean value) {
        return value ? 1 : 0;
    }

    /**
     * boolean值转为Integer
     *
     * @param value Boolean值
     * @return Integer值
     */
    public static Integer toInteger(boolean value) {
        return toInt(value);
    }

    /**
     * boolean值转为char
     *
     * @param value Boolean值
     * @return char值
     */
    public static char toChar(boolean value) {
        return (char) toInt(value);
    }

    /**
     * boolean值转为Character
     *
     * @param value Boolean值
     * @return Character值
     */
    public static Character toCharacter(boolean value) {
        return toChar(value);
    }

    /**
     * boolean值转为byte
     *
     * @param value Boolean值
     * @return byte值
     */
    public static byte toByte(boolean value) {
        return (byte) toInt(value);
    }

    /**
     * boolean值转为Byte
     *
     * @param value Boolean值
     * @return Byte值
     */
    public static Byte toByteObj(boolean value) {
        return toByte(value);
    }

    /**
     * boolean值转为long
     *
     * @param value Boolean值
     * @return long值
     */
    public static long toLong(boolean value) {
        return toInt(value);
    }

    /**
     * boolean值转为Long
     *
     * @param value Boolean值
     * @return Long值
     */
    public static Long toLongObj(boolean value) {
        return toLong(value);
    }

    /**
     * boolean值转为short
     *
     * @param value Boolean值
     * @return short值
     */
    public static short toShort(boolean value) {
        return (short) toInt(value);
    }

    /**
     * boolean值转为Short
     *
     * @param value Boolean值
     * @return Short值
     */
    public static Short toShortObj(boolean value) {
        return toShort(value);
    }

    /**
     * boolean值转为float
     *
     * @param value Boolean值
     * @return float值
     */
    public static float toFloat(boolean value) {
        return (float) toInt(value);
    }

    /**
     * boolean值转为Float
     *
     * @param value Boolean值
     * @return float值
     */
    public static Float toFloatObj(boolean value) {
        return toFloat(value);
    }

    /**
     * boolean值转为double
     *
     * @param value Boolean值
     * @return double值
     */
    public static double toDouble(boolean value) {
        return toInt(value);
    }

    /**
     * boolean值转为double
     *
     * @param value Boolean值
     * @return double值
     */
    public static Double toDoubleObj(boolean value) {
        return toDouble(value);
    }

    /**
     * 将boolean转换为字符串 {@code 'true'} 或者 {@code 'false'}.
     *
     * <pre>
     *   BooleanUtil.toStringTrueFalse(true)   = "true"
     *   BooleanUtil.toStringTrueFalse(false)  = "false"
     * </pre>
     *
     * @param bool Boolean值
     * @return {@code 'true'}, {@code 'false'}
     */
    public static String toStringTrueFalse(boolean bool) {
        return toString(bool, "true", "false");
    }

    /**
     * 将boolean转换为字符串 {@code 'on'} 或者 {@code 'off'}.
     *
     * <pre>
     *   BooleanUtil.toStringOnOff(true)   = "on"
     *   BooleanUtil.toStringOnOff(false)  = "off"
     * </pre>
     *
     * @param bool Boolean值
     * @return {@code 'on'}, {@code 'off'}
     */
    public static String toStringOnOff(boolean bool) {
        return toString(bool, "on", "off");
    }

    /**
     * 将boolean转换为字符串 {@code 'yes'} 或者 {@code 'no'}.
     *
     * <pre>
     *   BooleanUtil.toStringYesNo(true)   = "yes"
     *   BooleanUtil.toStringYesNo(false)  = "no"
     * </pre>
     *
     * @param bool Boolean值
     * @return {@code 'yes'}, {@code 'no'}
     */
    public static String toStringYesNo(boolean bool) {
        return toString(bool, "yes", "no");
    }

    /**
     * 将boolean转换为字符串
     *
     * <pre>
     *   BooleanUtil.toString(true, "true", "false")   = "true"
     *   BooleanUtil.toString(false, "true", "false")  = "false"
     * </pre>
     *
     * @param bool        Boolean值
     * @param trueString  当值为 {@code true}时返回此字符串, 可能为 {@code null}
     * @param falseString 当值为 {@code false}时返回此字符串, 可能为 {@code null}
     * @return 结果值
     */
    public static String toString(boolean bool, String trueString, String falseString) {
        return bool ? trueString : falseString;
    }

    /**
     * 对Boolean数组取与
     *
     * <pre>
     *   BooleanUtil.and(true, true)         = true
     *   BooleanUtil.and(false, false)       = false
     *   BooleanUtil.and(true, false)        = false
     *   BooleanUtil.and(true, true, false)  = false
     *   BooleanUtil.and(true, true, true)   = true
     * </pre>
     *
     * @param array {@code Boolean}数组
     * @return 取与为真返回{@code true}
     */
    public static boolean and(boolean... array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (final boolean element : array) {
            if (false == element) {
                return false;
            }
        }
        return true;
    }


    /**
     * 对Boolean数组取或
     *
     * <pre>
     *   BooleanUtil.or(true, true)          = true
     *   BooleanUtil.or(false, false)        = false
     *   BooleanUtil.or(true, false)         = true
     *   BooleanUtil.or(true, true, false)   = true
     *   BooleanUtil.or(true, true, true)    = true
     *   BooleanUtil.or(false, false, false) = false
     * </pre>
     *
     * @param array {@code Boolean}数组
     * @return 取或为真返回{@code true}
     */
    public static boolean or(boolean... array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (final boolean element : array) {
            if (element) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对Boolean数组取异或
     *
     * <pre>
     *   BooleanUtil.xor(true, true)   = false
     *   BooleanUtil.xor(false, false) = false
     *   BooleanUtil.xor(true, false)  = true
     *   BooleanUtil.xor(true, true)   = false
     *   BooleanUtil.xor(false, false) = false
     *   BooleanUtil.xor(true, false)  = true
     * </pre>
     *
     * @param array {@code boolean}数组
     * @return 如果异或计算为true返回 {@code true}
     */
    public static boolean xor(boolean... array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty");
        }

        boolean result = false;
        for (final boolean element : array) {
            result ^= element;
        }

        return result;
    }


    /**
     * 给定类是否为Boolean或者boolean
     *
     * @param clazz 类
     * @return 是否为Boolean或者boolean
     */
    public static boolean isBoolean(Class<?> clazz) {
        return (clazz == Boolean.class || clazz == boolean.class);
    }
}
