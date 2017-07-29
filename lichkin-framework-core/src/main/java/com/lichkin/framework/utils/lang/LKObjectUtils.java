package com.lichkin.framework.utils.lang;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 对象工具类，继承自org.apache.commons.lang3.ObjectUtils
 * @see org.apache.commons.lang3.ObjectUtils
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKObjectUtils extends ObjectUtils {

	/**
	 * 转换为Byte类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Byte toByte(final Object obj, final Byte defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toByte(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toByte(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {// 布尔型
				if ((Boolean) obj) {
					return 1;
				}
				return 0;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为Short类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Short toShort(final Object obj, final Short defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toShort(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toShort(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return 1;
				}
				return 0;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为Integer类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Integer toInteger(final Object obj, final Integer defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toInteger(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toInteger(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return 1;
				}
				return 0;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为Long类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Long toLong(final Object obj, final Long defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toLong(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toLong(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return 1l;
				}
				return 0l;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为Float类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Float toFloat(final Object obj, final Float defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toFloat(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toFloat(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return 1f;
				}
				return 0f;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为Double类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Double toDouble(final Object obj, final Double defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toDouble(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toDouble(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return 1d;
				}
				return 0d;
			}
		}
		return defaultValue;
	}


	/**
	 * 转换为BigDecimal类型对象
	 * @param obj Number类型或表示数字的String类型，Boolean型true为1，false为0，其他情况返回默认值。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型、或不是Boolean型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static BigDecimal toBigDecimal(final Object obj, final BigDecimal defaultValue) {
		if (obj != null) {
			if (obj instanceof Number) {// 数字型
				return LKNumberUtils.toBigDecimal(((Number) obj), defaultValue);
			} else if (obj instanceof String) {// 字符串型
				return LKStringUtils.toBigDecimal(((String) obj), defaultValue);
			} else if (obj instanceof Boolean) {
				if ((Boolean) obj) {
					return new BigDecimal(1);
				}
				return new BigDecimal(0);
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成布尔值
	 *
	 * <pre>
	 *   LKObjectUtils.toBoolean(null)       = defaultValue
	 *
	 *   LKObjectUtils.toBoolean(true)       = true
	 *   LKObjectUtils.toBoolean(false)      = false
	 *
	 *   LKObjectUtils.toBoolean("")         = defaultValue
	 *   LKObjectUtils.toBoolean(" ")        = defaultValue
	 *   LKObjectUtils.toBoolean("other")    = defaultValue
	 *
	 *   LKObjectUtils.toBoolean("y")        = true
	 *   LKObjectUtils.toBoolean("t")        = true
	 *   LKObjectUtils.toBoolean("on")       = true
	 *   LKObjectUtils.toBoolean("yes")      = true
	 *   LKObjectUtils.toBoolean("true")     = true
	 *   LKObjectUtils.toBoolean("tRue")     = true
	 *   LKObjectUtils.toBoolean("trUe")     = true
	 *   LKObjectUtils.toBoolean("TRUE")     = true
	 *   LKObjectUtils.toBoolean(" TRUE ")   = true
	 *
	 *   LKObjectUtils.toBoolean("0")        = false
	 *   LKObjectUtils.toBoolean("-1")       = false
	 *   LKObjectUtils.toBoolean("1")        = true
	 *   LKObjectUtils.toBoolean("1.1")      = true
	 *
	 *   LKObjectUtils.toBoolean(0)          = false
	 *   LKObjectUtils.toBoolean(-1)         = false
	 *   LKObjectUtils.toBoolean(1)          = true
	 *   LKObjectUtils.toBoolean(1.1)        = true
	 * </pre>
	 *
	 * @param obj 可解析Boolean、String、Number类型。
	 * @param defaultValue 默认值，当obj==null时、或obj既不是Number类型也不是可以表示数字的String类型时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static Boolean toBoolean(final Object obj, final Boolean defaultValue) {
		if (obj != null) {
			if (obj instanceof Boolean) {
				return (Boolean) obj;
			} else if (obj instanceof String) {
				return LKBooleanUtils.toBoolean((String) obj, defaultValue);
			} else if (obj instanceof Number) {
				return LKBooleanUtils.toBoolean((Number) obj, defaultValue);
			}
		}

		return defaultValue;
	}


	/**
	 * 转换为String类型对象
	 * @param obj 对象
	 * @param defaultValue 默认值，当obj==null时、或toString后为""时。
	 * @return 可解析时，返回解析值，否则返回默认值。
	 */
	public static String toString(final Object obj, final String defaultValue) {
		if (obj != null) {
			final String str = obj.toString();
			if (LKStringUtils.isNotBlank(str)) {
				return str;
			}
		}
		return defaultValue;
	}

}
