package com.lichkin.framework.utils.security.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * MD5加密工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKMD5Encrypter {

	/** MD对象 */
	private static MessageDigest md5;

	static {
		try {
			LKMD5Encrypter.md5 = MessageDigest.getInstance("MD5");
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 加密
	 * @param plaintext 明文
	 * @return 密文
	 */
	public static String encrypt(final String plaintext) {
		return LKMD5Encrypter.encrypt(plaintext, LKStringStatics.STR_CHARSET_UTF_8, "");
	}


	/**
	 * 加密
	 * @param plaintext 明文
	 * @param charset 字符集
	 * @return 密文
	 */
	public static String encrypt(final String plaintext, final String charset) {
		return LKMD5Encrypter.encrypt(plaintext, charset, "");
	}


	/**
	 * 加密
	 * @param plaintext 明文
	 * @param charset 字符集
	 * @param key 辅助加密
	 * @return 密文
	 */
	public static String encrypt(final String plaintext, final String charset, final String key) {
		try {
			LKMD5Encrypter.md5.update((plaintext + key).getBytes(charset));
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
		}
		final byte[] bytes = LKMD5Encrypter.md5.digest();
		return LKHexUtils.toHexBytesFromBinaryData(bytes);
	}

}
