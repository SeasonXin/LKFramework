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
	 *   toBoolean(null, defaultValue)       = defaultValue
	 *
	 *   toBoolean("", defaultValue)         = defaultValue
	 *   toBoolean(" ", defaultValue)        = defaultValue
	 *   toBoolean("other", defaultValue)    = defaultValue
	 *
	 *   toBoolean("y", defaultValue)        = true
	 *   toBoolean("t", defaultValue)        = true
	 *   toBoolean("on", defaultValue)       = true
	 *   toBoolean("yes", defaultValue)      = true
	 *   toBoolean("true", defaultValue)     = true
	 *   toBoolean("tRue", defaultValue)     = true
	 *   toBoolean("trUe", defaultValue)     = true
	 *   toBoolean("TRUE", defaultValue)     = true
	 *   toBoolean(" TRUE ", defaultValue)   = true
	 *
	 *   toBoolean("0", defaultValue)        = false
	 *   toBoolean("-1", defaultValue)       = false
	 *   toBoolean("1", defaultValue)        = true
	 *   toBoolean("1.1", defaultValue)      = true
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
				for (final String t : _TRUES) {
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
	 *   toBoolean(null)       = false
	 *
	 *   toBoolean("")         = false
	 *   toBoolean(" ")        = false
	 *   toBoolean("other")    = false
	 *
	 *   toBoolean("y")        = true
	 *   toBoolean("t")        = true
	 *   toBoolean("on")       = true
	 *   toBoolean("yes")      = true
	 *   toBoolean("true")     = true
	 *   toBoolean("tRue")     = true
	 *   toBoolean("trUe")     = true
	 *   toBoolean("TRUE")     = true
	 *   toBoolean(" TRUE ")   = true
	 *
	 *   toBoolean("0")        = false
	 *   toBoolean("-1")       = false
	 *   toBoolean("1")        = true
	 *   toBoolean("1.1")      = true
	 * </pre>
	 *
	 * @param str 字符串
	 * @return 解析值为真时返回true，否则返回false。
	 */
	public static boolean toBoolean(final String str) {
		return toBoolean(str, Boolean.FALSE);
	}


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   toBoolean(null, defaultValue)     = defaultValue
	 *
	 *   toBoolean(0, defaultValue)        = false
	 *   toBoolean(-1, defaultValue)       = false
	 *   toBoolean(1, defaultValue)        = true
	 *   toBoolean(1.1, defaultValue)      = true
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
	 *   toBoolean(null)     = false
	 *
	 *   toBoolean(0)        = false
	 *   toBoolean(-1)       = false
	 *   toBoolean(1)        = true
	 *   toBoolean(1.1)      = true
	 * </pre>
	 *
	 * @param num 数字
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static boolean toBoolean(final Number num) {
		return toBoolean(num, Boolean.FALSE);
	}

}
