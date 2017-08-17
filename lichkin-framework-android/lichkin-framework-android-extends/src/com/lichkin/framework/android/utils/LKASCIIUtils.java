package com.lichkin.framework.android.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * ASCII工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKASCIIUtils {

	/** ASCII表 */
	private static final Map<String, String> ASCII_TABLE = new HashMap<String, String>();

	static {
		ASCII_TABLE.put("30", "0");
		ASCII_TABLE.put("31", "1");
		ASCII_TABLE.put("32", "2");
		ASCII_TABLE.put("33", "3");
		ASCII_TABLE.put("34", "4");
		ASCII_TABLE.put("35", "5");
		ASCII_TABLE.put("36", "6");
		ASCII_TABLE.put("37", "7");
		ASCII_TABLE.put("38", "8");
		ASCII_TABLE.put("39", "9");
		ASCII_TABLE.put("41", "A");
		ASCII_TABLE.put("42", "B");
		ASCII_TABLE.put("43", "C");
		ASCII_TABLE.put("44", "D");
		ASCII_TABLE.put("45", "E");
		ASCII_TABLE.put("46", "F");
		ASCII_TABLE.put("61", "a");
		ASCII_TABLE.put("62", "b");
		ASCII_TABLE.put("63", "c");
		ASCII_TABLE.put("64", "d");
		ASCII_TABLE.put("65", "e");
		ASCII_TABLE.put("66", "f");
	}


	/**
	 * 获取ASCII值
	 * @param b 字节值
	 * @return ASCII值
	 */
	public static String getAscii(final byte b) {
		if (b == 0) {
			return "0";
		}
		return ASCII_TABLE.get(LKHexUtils.binaryToHex(b));
	}


	/**
	 * 获取ASCII值
	 * @param b1 字节值
	 * @param b2 字节值
	 * @return ASCII值
	 */
	public static String getAscii(final byte b1, final byte b2) {
		return getAscii(b1) + getAscii(b2);
	}


	/**
	 * 获取十进制值
	 * @param b1 字节值
	 * @param b2 字节值
	 * @return 十进制值
	 */
	public static int getInt(final byte b1, final byte b2) {
		return LKHexUtils.hexToDecimal(getAscii(b1, b2).toUpperCase(Locale.getDefault()));
	}

}
