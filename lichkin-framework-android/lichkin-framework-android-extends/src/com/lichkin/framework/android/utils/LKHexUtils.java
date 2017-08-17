package com.lichkin.framework.android.utils;

import java.util.Locale;

/**
 * 十六进制工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKHexUtils {

	/**
	 * 二进制值转换为十六进制值
	 * @param b 二进制
	 * @return 十六进制值
	 */
	public static String binaryToHex(final byte b) {
		return String.format("%02x", b).toUpperCase(Locale.getDefault());
	}


	/**
	 * 二进制值转换为十进制值
	 * @param b 二进制
	 * @return 十进制值
	 */
	public static int binaryToDecimal(final byte b) {
		return Integer.valueOf(binaryToHex(b), 16);
	}


	/**
	 * 十六进制值转换为十进制值
	 * @param hex 十六进制值
	 * @return 十进制值
	 */
	public static int hexToDecimal(final String hex) {
		return Integer.parseInt(hex, 16);
	}


	/**
	 * 十进制值转换为十六进制值
	 * @param decimal 十进制值
	 * @return 十六进制值
	 */
	public static String decimalToHex(final int decimal) {
		return Integer.toHexString(decimal).toUpperCase(Locale.getDefault());
	}

}
