package com.lichkin.framework.utils.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 数字工具类，继承自org.apache.commons.lang3.math.NumberUtils
 * @see org.apache.commons.lang3.math.NumberUtils
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKNumberUtils extends NumberUtils {

	/**
	 * 转换成Byte类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Byte类型值
	 */
	public static Byte toByte(final Number num, final Byte defaultValue) {
		if (num != null) {
			return num.byteValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成Short类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Short类型值
	 */
	public static Short toShort(final Number num, final Short defaultValue) {
		if (num != null) {
			return num.shortValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成Integer类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Integer类型值
	 */
	public static Integer toInteger(final Number num, final Integer defaultValue) {
		if (num != null) {
			return num.intValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成Long类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Long类型值
	 */
	public static Long toLong(final Number num, final Long defaultValue) {
		if (num != null) {
			return num.longValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成Float类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Float类型值
	 */
	public static Float toFloat(final Number num, final Float defaultValue) {
		if (num != null) {
			return num.floatValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成Double类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return Double类型值
	 */
	public static Double toDouble(final Number num, final Double defaultValue) {
		if (num != null) {
			return num.doubleValue();
		}
		return defaultValue;
	}


	/**
	 * 转换成BigDecimal类型值
	 * @param num 数字型
	 * @param defaultValue 默认值
	 * @return BigDecimal类型值
	 */
	public static BigDecimal toBigDecimal(final Number num, final BigDecimal defaultValue) {
		if (num instanceof Byte) {// 字节型
			return new BigDecimal((Byte) num);
		} else if (num instanceof Short) {// 短整型
			return new BigDecimal((Short) num);
		} else if (num instanceof Integer) {// 整型
			return new BigDecimal((Integer) num);
		} else if (num instanceof Long) {// 长整型
			return new BigDecimal((Long) num);
		} else if (num instanceof Float) {// 浮点型
			return new BigDecimal((Float) num);
		} else if (num instanceof Double) {// 双精度浮点型
			return new BigDecimal((Double) num);
		} else if (num instanceof BigDecimal) {// 大数据型
			return (BigDecimal) num;
		} else if (num instanceof AtomicInteger) {// 原子型整形
			return new BigDecimal(((AtomicInteger) num).intValue());
		} else if (num instanceof AtomicLong) {// 原子型长整形
			return new BigDecimal(((AtomicLong) num).longValue());
		} else if (num instanceof BigInteger) {// 超整形
			return new BigDecimal((BigInteger) num);
		}
		return defaultValue;
	}


	/**
	 * 获取最大整型值
	 * @param digit 位数
	 * @return 最大整型值
	 */
	public static int getMaxInt(final int digit) {
		return (int) (Math.pow(10, digit) - 1);
	}


	/**
	 * 最大长整型值
	 * @param digit 位数
	 * @return 长整型值
	 */
	public static long getMaxLong(final int digit) {
		return (long) (Math.pow(10, digit) - 1);
	}


	/**
	 * 将十进制转换为十六进制字符串
	 * @param number 十进制数字
	 * @param byteCnt 字节数
	 * @return 十六进制字符串
	 */
	public static String toHex(final long number, final int byteCnt) {
		final String hexStr = Long.toHexString(number);
		return LKNumberUtils.toHex(hexStr, byteCnt);
	}


	/**
	 * 将十六进制字符串转换为十六进制字符串
	 * @param hexStr 十六进制字符串
	 * @param byteCnt 字节数
	 * @param before true：在前面补零；false：在后面补零。
	 * @return 十六进制字符串
	 */
	public static String toHex(final String hexStr, final int byteCnt, final boolean before) {
		final int length = byteCnt * 2;// 十六进制是通过两位表示一个字节
		if (hexStr.length() >= length) {// 溢出或位数相同时取剩余部分
			return hexStr.substring(hexStr.length() - length, hexStr.length()).toUpperCase();
		} else {// 位数不足补零
			return LKStringUtils.fillZero(hexStr, length, before).toUpperCase();
		}
	}


	/**
	 * 将十六进制字符串转换为十六进制字符串
	 * @param hexStr 十六进制字符串
	 * @param byteCnt 字节数
	 * @return 十六进制字符串
	 */
	public static String toHex(final String hexStr, final int byteCnt) {
		return LKNumberUtils.toHex(hexStr, byteCnt, true);
	}


	/**
	 * 将十进制数组转换为十六进制字符串
	 * @param arr 十进制数组
	 * @param asc 正序true，倒序false。
	 * @return 十六进制字符串
	 */
	public static String toHex(final byte[] arr, final boolean asc) {
		final StringBuilder sb = new StringBuilder();
		if (asc) {
			for (final byte number : arr) {
				sb.insert(0, LKNumberUtils.toHex(number, 1));
			}
		} else {
			for (final byte number : arr) {
				sb.append(LKNumberUtils.toHex(number, 1));
			}
		}
		return sb.toString();
	}


	/**
	 * 将字符串转换为unicode码表示的十六进制字符串
	 * @param str 字符串
	 * @param asc 正序true，倒序false。
	 * @return 十六进制字符串
	 */
	public static String toHex(final String str, final boolean asc) {
		final StringBuilder sb = new StringBuilder();
		if (asc) {
			for (int i = 0; i < str.length(); i++) {
				final String hexString = Integer.toHexString(str.charAt(i));
				if (hexString.length() == 2) {
					sb.append("00");
				}
				sb.append(hexString);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				final String hexString = Integer.toHexString(str.charAt(i));
				if (hexString.length() == 2) {
					sb.append(hexString).append("00");
				} else {
					sb.append(hexString.substring(2)).append(hexString.substring(0, 2));
				}
			}
		}
		return sb.toString().toUpperCase();
	}


	/**
	 * 将十进制数组转换为十六进制字符串
	 * @param arr 十进制数组
	 * @param asc 正序true，倒序false。
	 * @return 十六进制字符串
	 */
	public static long toDecimal(final byte[] arr, final boolean asc) {
		return Long.parseLong(LKNumberUtils.toHex(arr, asc), 16);
	}


	/**
	 * 转换成十六进制数组
	 * @param datas 十进制数组
	 * @return 十六进制数组
	 */
	public static String[] toHexArr(final byte[] datas) {
		final String[] hexes = new String[datas.length];
		for (int i = 0; i < hexes.length; i++) {
			hexes[i] = LKNumberUtils.toHex(datas[i], 1);
		}
		return hexes;
	}


	/**
	 * 十六进制字符串转换为十进制数字
	 * @param hexStr 十六进制字符串
	 * @return 十进制数字
	 */
	public static byte toByte(final String hexStr) {
		return (byte) Integer.parseInt(hexStr, 16);
	}


	/**
	 * 字符串转换为字节数组
	 * @param message 十六进制消息
	 * @return 字节数组
	 */
	public static byte[] toBytes(final String message) {
		final byte[] buffer = new byte[message.length() / 2];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = LKNumberUtils.toByte(message.substring(i * 2, (i + 1) * 2));
		}
		return buffer;
	}

}
