package com.lichkin.framework.utils.lang;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.statics.LKStatics;

/**
 * 字符串工具类，继承自org.apache.commons.lang3.StringUtils
 * @see org.apache.commons.lang3.StringUtils
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKStringUtils extends StringUtils implements LKStatics {

	/**
	 * 判断字符数组是否为空
	 *
	 * <pre>
	 * isBlank(null)        = true
	 * isBlank("null")      = true
	 * isBlank(" null ")    = true
	 * isBlank("")          = true
	 * isBlank(" ")         = true
	 * isBlank("other")     = false
	 * isBlank("  other  ") = false
	 * </pre>
	 *
	 * @param cs 字符数组
	 * @return 为空时返回true，否则返回false。
	 */
	public static boolean isBlank(final CharSequence cs) {
		return trimToEmpty(cs).equals("");
	}


	/**
	 * 判断字符数组是否不为空
	 *
	 * <pre>
	 * isNotBlank(null)        = false
	 * isNotBlank("null")      = false
	 * isNotBlank(" null ")    = false
	 * isNotBlank("")          = false
	 * isNotBlank(" ")         = false
	 * isNotBlank("other")     = true
	 * isNotBlank("  other  ") = true
	 * </pre>
	 *
	 * @param cs 字符数组
	 * @return 不为空时返回true，否则返回false。
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}


	/**
	 * 去除空格
	 *
	 * <pre>
	 * trimToEmpty(null)        = ""
	 * trimToEmpty("null")      = ""
	 * trimToEmpty(" null ")    = ""
	 * trimToEmpty("")          = ""
	 * trimToEmpty(" ")         = ""
	 * trimToEmpty("other")     = "other"
	 * trimToEmpty("  other  ") = "other"
	 * </pre>
	 *
	 * @param cs 字符串
	 * @return 去空格，当目标值为"null"时，认为是null，返回EMPTY。
	 */
	public static String trimToEmpty(final CharSequence cs) {
		final String str = (cs == null ? "" : cs.toString().trim());
		if (str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined")) {
			return "";
		}
		return str;
	}


	/**
	 * 去除空格
	 *
	 * <pre>
	 * trimToEmpty(null)        = ""
	 * trimToEmpty("null")      = ""
	 * trimToEmpty(" null ")    = ""
	 * trimToEmpty("")          = ""
	 * trimToEmpty(" ")         = ""
	 * trimToEmpty("other")     = "other"
	 * trimToEmpty("  other  ") = "other"
	 * </pre>
	 *
	 * @param str 字符串
	 * @return 去空格，当目标值为"null"时，认为是null，返回EMPTY。
	 */
	public static String trimToEmpty(final String str) {
		if (str == null) {
			return "";
		}
		final String resultStr = str.trim();
		if (resultStr.equalsIgnoreCase("null") || resultStr.equalsIgnoreCase("undefined")) {
			return "";
		}
		return resultStr;
	}


	/**
	 * 转换成Byte类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Byte类型值
	 */
	public static Byte toByte(final CharSequence cs, final Byte defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Byte.parseByte(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成Short类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Short类型值
	 */
	public static Short toShort(final CharSequence cs, final Short defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Short.parseShort(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成Integer类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Integer类型值
	 */
	public static Integer toInteger(final CharSequence cs, final Integer defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Integer.parseInt(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成Long类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Long类型值
	 */
	public static Long toLong(final CharSequence cs, final Long defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Long.parseLong(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成Float类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Float类型值
	 */
	public static Float toFloat(final CharSequence cs, final Float defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Float.parseFloat(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成Double类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return Double类型值
	 */
	public static Double toDouble(final CharSequence cs, final Double defaultValue) {
		if (isNotBlank(cs)) {
			try {
				return Double.parseDouble(trimToEmpty(cs));
			} catch (final Exception e) {
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成BigDecimal类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return BigDecimal类型值
	 */
	public static BigDecimal toBigDecimal(final CharSequence cs, final BigDecimal defaultValue) {
		if (isNotBlank(cs)) {
			final String str = trimToEmpty(cs);
			if (str.contains(".")) {
				try {
					return new BigDecimal(Double.parseDouble(str));
				} catch (final Exception e) {
				}
			} else {
				try {
					return new BigDecimal(Long.parseLong(str));
				} catch (final Exception e) {
				}
			}
		}
		return defaultValue;
	}


	/**
	 * 转换成String类型值
	 * @param cs 字符数组
	 * @param defaultValue 默认值
	 * @return String类型值
	 */
	public static String toString(final CharSequence cs, final String defaultValue) {
		if (isBlank(cs)) {
			return defaultValue;
		}
		return trimToEmpty(cs);
	}


	/**
	 * 替换字符串
	 * @param regex 正则表达式
	 * @param input 待匹配字符串
	 * @param replaceStr 替换字符串
	 * @return 替换后的字符串
	 */
	public static String replaceAll(final String regex, final String input, final String replaceStr) {
		return LKMatcherUtils.getMatcher(regex, input).replaceAll(replaceStr);
	}


	/**
	 * 是否以前缀开始
	 * @param cs 字符数组
	 * @param prefix 前缀
	 * @return 以文件分隔符开始则返回true，否则放回false。
	 */
	public static boolean startsWith(final CharSequence cs, final String prefix) {
		if (isNotBlank(cs)) {
			return trimToEmpty(cs).startsWith(prefix);
		}
		return false;
	}


	/**
	 * 是否以后缀结尾
	 * @param cs 字符数组
	 * @param suffix 后缀
	 * @return 以文件分隔符结尾则返回true，否则放回false。
	 */
	public static boolean endsWith(final CharSequence cs, final String suffix) {
		if (isNotBlank(cs)) {
			return trimToEmpty(cs).endsWith(suffix);
		}
		return false;
	}


	/**
	 * 是否以文件分隔符开始
	 * @param cs 字符数组
	 * @return 以文件分隔符开始则返回true，否则放回false。
	 */
	public static boolean startsWithFileSeparator(final CharSequence cs) {
		if (isNotBlank(cs)) {
			final String str = trimToEmpty(cs);
			if (str.startsWith(SEPARATOR) || str.startsWith(BACKLASH)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 是否以文件分隔符结尾
	 * @param cs 字符数组
	 * @return 以文件分隔符结尾则返回true，否则放回false。
	 */
	public static boolean endsWithFileSeparator(final CharSequence cs) {
		if (isNotBlank(cs)) {
			final String str = trimToEmpty(cs);
			if (str.endsWith(SEPARATOR) || str.endsWith(BACKLASH)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 将字符串格式化成单行字符串
	 * @param cs 待转换字符串
	 * @return BLANK或单行字符串
	 */
	public static String format2SingleLine(final CharSequence cs) {
		if (isNotBlank(cs)) {
			String str = trimToEmpty(cs);
			str = replaceAll("[\r]+", str, " ");
			str = replaceAll("[\n]+", str, " ");
			str = replaceAll("[\t]+", str, " ");
			str = replaceAll("[\b]+", str, " ");
			str = replaceAll("[ ]+", str, " ");
			return trimToEmpty(str);
		}
		return "";
	}


	/**
	 * 首字母大写
	 * @param str 字符串
	 * @return 首字母大写字符串
	 */
	public static String capitalize(final String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}
		final char firstChar = str.charAt(0);
		if (Character.isTitleCase(firstChar)) {
			return str;
		}
		return new StringBuilder(strLen).append(Character.toTitleCase(firstChar)).append(str.substring(1)).toString();
	}


	/**
	 * 下划线转驼峰
	 * @param str 下划线
	 * @return 驼峰
	 */
	public static String underlineToHump(final String str) {
		final String[] strs = trimToEmpty(str).toLowerCase(Locale.CHINA).split("_");
		final StringBuilder result = new StringBuilder(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			result.append(capitalize(strs[i]));
		}
		return result.toString();
	}


	/**
	 * 驼峰转下划线
	 * @param str 驼峰
	 * @return 下划线
	 */
	public static String humpToUnderline(final String str) {
		final StringBuilder sb = new StringBuilder(str);
		for (int i = 1; i < (sb.length() - 1); i++) {
			if (Character.isLowerCase(sb.charAt(i - 1)) && Character.isUpperCase(sb.charAt(i)) && Character.isLowerCase(sb.charAt(i + 1))) {
				sb.insert(i++, "_");
			}
		}
		return sb.toString().toUpperCase(Locale.CHINA);
	}


	/**
	 * 连接字符串
	 * @param strs 字符串数组
	 * @return 字符串
	 */
	public static String join(final String... strs) {
		return join(strs, null, 0, -1);
	}


	/**
	 * 连接字符串
	 * @param strs 字符串数组
	 * @param separator 连接符
	 * @return 字符串
	 */
	public static String join(final String[] strs, final String separator) {
		return join(strs, separator, 0, -1);
	}


	/**
	 * 连接字符串
	 * @param strs 字符串数组
	 * @param separator 连接符
	 * @param startIndex 开始位置
	 * @param endIndex 结束位置
	 * @return 字符串
	 */
	public static String join(final String[] strs, final String separator, final int startIndex, final int endIndex) {
		if (strs == null) {
			return "";
		}

		final String sep = trimToEmpty(separator);
		int start = startIndex;
		int end = endIndex;

		if (start < 0) {
			start = 0;
		}
		if (end < 0) {
			end = strs.length;
		}

		final int noOfItems = end - start;
		if (noOfItems <= 0) {
			return "";
		}

		final StringBuilder buf = new StringBuilder(noOfItems * 16);

		for (int i = start; i < end; i++) {
			if (i > start) {
				buf.append(sep);
			}
			if (strs[i] != null) {
				buf.append(trimToEmpty(strs[i]));
			}
		}
		return buf.toString();
	}


	/**
	 * 补零
	 *
	 * <pre>
	 * fillZero("3",	1,	true)	.equals("3")
	 * fillZero("3",	2,	true)	.equals("03")
	 * fillZero("33",	1,	true)	.equals("33")
	 * fillZero("33",	2,	true)	.equals("33")
	 * fillZero("33",	3,	true)	.equals("033")
	 * fillZero("3",	1,	false)	.equals("3")
	 * fillZero("3",	2,	false)	.equals("30")
	 * fillZero("33",	1,	false)	.equals("33")
	 * fillZero("33",	2,	false)	.equals("33")
	 * fillZero("33",	3,	false)	.equals("330")
	 * </pre>
	 *
	 * @param number 当前数字
	 * @param digit 显示位数
	 * @param before true：在前面补零；false：在后面补零。
	 * @return 补零后的结果
	 */
	public static String fillZero(final String number, final int digit, final boolean before) {
		final char[] cs = number.toCharArray();
		if (digit <= cs.length) {
			return String.valueOf(cs);
		} else {
			final char[] ncs = new char[digit];
			for (int i = 0; i < ncs.length; i++) {
				ncs[i] = '0';
			}
			if (before) {
				for (int i = ncs.length - 1; i > (digit - number.length() - 1); i--) {
					ncs[i] = cs[i - (digit - number.length())];
				}
			} else {
				for (int i = 0; i < cs.length; i++) {
					ncs[i] = cs[i];
				}
			}
			return String.valueOf(ncs);
		}
	}


	/**
	 * 补零
	 * @param number 当前数字
	 * @param digit 显示位数
	 * @return 补零后的结果
	 * @see LKStringUtils#fillZero(String, int, boolean)
	 */
	public static String fillZero(final String number, final int digit) {
		return fillZero(number, digit, true);
	}


	/**
	 * 替换数据变量
	 * @param str 待替换字符串
	 * @param datas 数据集合
	 * @return 替换后的字符串
	 */
	public static String replaceDatas(String str, final Map<String, String> datas) {
		for (final Entry<String, String> entry : datas.entrySet()) {
			final String key = entry.getKey().toString();
			final String value = entry.getValue().toString();
			str = replaceAll(key, str, value);
		}
		return str;
	}


	/**
	 * 替换数据变量
	 * @param str 待替换字符串
	 * @param datas 数据集合，需存放的Key和Value都是String。
	 * @return 替换后的字符串
	 */
	public static String replaceDatas(String str, final LKDatas datas) {
		for (final Entry<String, Object> entry : datas.getMap().entrySet()) {
			final String key = entry.getKey().toString();
			final String value = entry.getValue().toString();
			str = replaceAll(key, str, value);
		}
		return str;
	}

}
