package com.lichkin.framework.utils.base64;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Base64;

import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * base64编码工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBase64Encoder {

	/**
	 * 使用字节数组进行编码
	 * @param binaryData 十六进制表示的字符串
	 * @return base64编码字符串
	 */
	public static String encodeWithBinaryData(final byte[] binaryData) {
		return new String(Base64.encodeBase64(binaryData));
	}


	/**
	 * 使用十六进制表示的字符串进行编码
	 * @param hex 十六进制表示的字符串
	 * @return base64编码字符串
	 */
	public static String encodeWithHex(final String hex) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromHex(hex));
	}


	/**
	 * 使用十进制表示的字符串进行编码
	 * @param decimal 十进制表示的字符串
	 * @return base64编码字符串
	 */
	public static String encodeWithDecimal(final String decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromDecimal(decimal));
	}


	/**
	 * 使用大整型进行编码
	 * @param decimal 大整型
	 * @return base64编码字符串
	 */
	public static String encodeWithBigInteger(final BigInteger decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromBigInteger(decimal));
	}


	/**
	 * 使用长整型进行编码
	 * @param decimal 长整型
	 * @return base64编码字符串
	 */
	public static String encodeWithLong(final long decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromLong(decimal));
	}


	/**
	 * 使用整型进行编码
	 * @param decimal 整型
	 * @return base64编码字符串
	 */
	public static String encodeWithInteger(final int decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromInteger(decimal));
	}


	/**
	 * 使用短整型进行编码
	 * @param decimal 短整型
	 * @return base64编码字符串
	 */
	public static String encodeWithShort(final short decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromShort(decimal));
	}


	/**
	 * 使用字节型组进行编码
	 * @param decimal 字节型
	 * @return base64编码字符串
	 */
	public static String encodeWithByte(final byte decimal) {
		return encodeWithBinaryData(LKHexUtils.toBytesFromByte(decimal));
	}

}
