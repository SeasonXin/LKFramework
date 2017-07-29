package com.lichkin.framework.utils.base64;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * base64解码工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBase64Decoder {

	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 字节数组
	 */
	public static byte[] decodeToBinaryData(final String base64String) {
		return Base64.decodeBase64(base64String);
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 十六进制表示的字符串
	 */
	public static String decodeToHex(final String base64String) {
		return LKHexUtils.toHexFromBinaryData(LKBase64Decoder.decodeToBinaryData(base64String));
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 十六进制表示的字符串（字节表示，即两位十六进制表示一个字节）
	 */
	public static String decodeToHexBytes(final String base64String) {
		return LKHexUtils.toHexBytesFromBinaryData(LKBase64Decoder.decodeToBinaryData(base64String));
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 十进制表示的字符串
	 */
	public static String decodeToDecimal(final String base64String) {
		return LKBase64Decoder.decodeToBigInteger(base64String).toString();
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 大整型
	 */
	public static BigInteger decodeToBigInteger(final String base64String) {
		byte[] decodeToBinaryData = LKBase64Decoder.decodeToBinaryData(base64String);
		if (ArrayUtils.isNotEmpty(decodeToBinaryData)) {
			if (decodeToBinaryData[0] < 0) {
				decodeToBinaryData = ArrayUtils.add(decodeToBinaryData, 0, (byte) 0);
			}
		}
		return new BigInteger(decodeToBinaryData);
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 长整型
	 */
	public static long decodeToLong(final String base64String) {
		return new BigInteger(LKBase64Decoder.decodeToBinaryData(base64String)).longValue();
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 整型
	 */
	public static int decodeToInteger(final String base64String) {
		return new BigInteger(LKBase64Decoder.decodeToBinaryData(base64String)).intValue();
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 短整型
	 */
	public static short decodeToShort(final String base64String) {
		return new BigInteger(LKBase64Decoder.decodeToBinaryData(base64String)).shortValue();
	}


	/**
	 * base64解码
	 * @param base64String base64编码的字符串
	 * @return 字节型
	 */
	public static byte decodeToByte(final String base64String) {
		return new BigInteger(LKBase64Decoder.decodeToBinaryData(base64String)).byteValue();
	}

}
