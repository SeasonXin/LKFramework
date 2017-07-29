package com.lichkin.framework.utils.lang;

import org.apache.commons.lang3.BooleanUtils;

/**
 * 布尔工具类，继承自org.apache.commons.lang3.BooleanUtils
 * @see org.apache.commons.lang3.BooleanUtils
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKBooleanUtils extends BooleanUtils {

	/** 为真的字符串 */
	public static final String[] _TRUES = { "Y", "T", "ON", "YES", "TRUE", "1" };


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   LKBooleanUtils.toBoolean(null, defaultValue)       = defaultValue
	 *
	 *   LKBooleanUtils.toBoolean("", defaultValue)         = defaultValue
	 *   LKBooleanUtils.toBoolean(" ", defaultValue)        = defaultValue
	 *   LKBooleanUtils.toBoolean("other", defaultValue)    = defaultValue
	 *
	 *   LKBooleanUtils.toBoolean("y", defaultValue)        = true
	 *   LKBooleanUtils.toBoolean("t", defaultValue)        = true
	 *   LKBooleanUtils.toBoolean("on", defaultValue)       = true
	 *   LKBooleanUtils.toBoolean("yes", defaultValue)      = true
	 *   LKBooleanUtils.toBoolean("true", defaultValue)     = true
	 *   LKBooleanUtils.toBoolean("tRue", defaultValue)     = true
	 *   LKBooleanUtils.toBoolean("trUe", defaultValue)     = true
	 *   LKBooleanUtils.toBoolean("TRUE", defaultValue)     = true
	 *   LKBooleanUtils.toBoolean(" TRUE ", defaultValue)   = true
	 *
	 *   LKBooleanUtils.toBoolean("0", defaultValue)        = false
	 *   LKBooleanUtils.toBoolean("-1", defaultValue)       = false
	 *   LKBooleanUtils.toBoolean("1", defaultValue)        = true
	 *   LKBooleanUtils.toBoolean("1.1", defaultValue)      = true
	 * </pre>
	 *
	 * @param str 字符串
	 * @param defaultValue 默认值
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Boolean toBoolean(final String str, final Boolean defaultValue) {
		if (str != null) {
			if (LKStringUtils.isNotBlank(str)) {
				final String trimmed = LKStringUtils.trimToEmpty(str);
				for (final String t : LKBooleanUtils._TRUES) {
					if (t.equalsIgnoreCase(trimmed)) {
						return Boolean.TRUE;
					}
				}
				try {
					return (Double.parseDouble(trimmed) > 0) ? Boolean.TRUE : Boolean.FALSE;
				} catch (final Exception e) {
				}
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   LKBooleanUtils.toBoolean(null)       = false
	 *
	 *   LKBooleanUtils.toBoolean("")         = false
	 *   LKBooleanUtils.toBoolean(" ")        = false
	 *   LKBooleanUtils.toBoolean("other")    = false
	 *
	 *   LKBooleanUtils.toBoolean("y")        = true
	 *   LKBooleanUtils.toBoolean("t")        = true
	 *   LKBooleanUtils.toBoolean("on")       = true
	 *   LKBooleanUtils.toBoolean("yes")      = true
	 *   LKBooleanUtils.toBoolean("true")     = true
	 *   LKBooleanUtils.toBoolean("tRue")     = true
	 *   LKBooleanUtils.toBoolean("trUe")     = true
	 *   LKBooleanUtils.toBoolean("TRUE")     = true
	 *   LKBooleanUtils.toBoolean(" TRUE ")   = true
	 *
	 *   LKBooleanUtils.toBoolean("0")        = false
	 *   LKBooleanUtils.toBoolean("-1")       = false
	 *   LKBooleanUtils.toBoolean("1")        = true
	 *   LKBooleanUtils.toBoolean("1.1")      = true
	 * </pre>
	 *
	 * @param str 字符串
	 * @return 解析值为真时返回true，否则返回false。
	 */
	public static boolean toBoolean(final String str) {
		return LKBooleanUtils.toBoolean(str, Boolean.FALSE);
	}


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   LKBooleanUtils.toBoolean(null, defaultValue)     = defaultValue
	 *
	 *   LKBooleanUtils.toBoolean(0, defaultValue)        = false
	 *   LKBooleanUtils.toBoolean(-1, defaultValue)       = false
	 *   LKBooleanUtils.toBoolean(1, defaultValue)        = true
	 *   LKBooleanUtils.toBoolean(1.1, defaultValue)      = true
	 * </pre>
	 *
	 * @param num 数字
	 * @param defaultValue 默认值
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Boolean toBoolean(final Number num, final Boolean defaultValue) {
		try {
			return (num.doubleValue() > 0) ? Boolean.TRUE : Boolean.FALSE;
		} catch (final Exception e) {
		}
		return defaultValue;
	}


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   LKBooleanUtils.toBoolean(null)     = false
	 *
	 *   LKBooleanUtils.toBoolean(0)        = false
	 *   LKBooleanUtils.toBoolean(-1)       = false
	 *   LKBooleanUtils.toBoolean(1)        = true
	 *   LKBooleanUtils.toBoolean(1.1)      = true
	 * </pre>
	 *
	 * @param num 数字
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static boolean toBoolean(final Number num) {
		return LKBooleanUtils.toBoolean(num, Boolean.FALSE);
	}

}
