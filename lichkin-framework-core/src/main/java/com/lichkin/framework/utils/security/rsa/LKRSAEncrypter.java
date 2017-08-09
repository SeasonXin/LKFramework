package com.lichkin.framework.utils.security.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import com.lichkin.framework.utils.base64.LKBase64Decoder;
import com.lichkin.framework.utils.base64.LKBase64Encoder;
import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * RSA加密工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRSAEncrypter extends LKRSA {

	/**
	 * 使用十六进制表示的公钥加密成十进制表示的密文
	 * @param plaintext 明文
	 * @param publicKey 十六进制表示的公钥
	 * @return 十进制表示的密文
	 */
	public static String encryptToDecimalWithHexPublicKey(final String plaintext, final String publicKey) {
		try {
			final RSAPublicKey rsaPubKey = (RSAPublicKey) LKRSA.keyFactory.generatePublic(new X509EncodedKeySpec(LKHexUtils.toBytesFromHex(publicKey)));

			final BigInteger coded = new BigInteger(plaintext.getBytes("UTF-8")).modPow(rsaPubKey.getPublicExponent(), rsaPubKey.getModulus());

			return coded.toString();
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 使用十六进制表示的公钥加密成Base64表示的密文
	 * @param plaintext 明文
	 * @param publicKey 十六进制表示的公钥
	 * @return Base64表示的密文
	 */
	public static String encryptToBase64WithHexPublicKey(final String plaintext, final String publicKey) {
		return LKBase64Encoder.encodeWithDecimal(encryptToDecimalWithHexPublicKey(plaintext, publicKey));
	}


	/**
	 * 使用Base64表示的公钥加密成十进制表示的密文
	 * @param plaintext 明文
	 * @param publicKey Base64表示的公钥
	 * @return 十进制表示的密文
	 */
	public static String encryptToDecimalWithBase64PublicKey(final String plaintext, final String publicKey) {
		return encryptToDecimalWithHexPublicKey(plaintext, LKBase64Decoder.decodeToHex(publicKey));
	}


	/**
	 * 使用Base64表示的公钥加密成Base64表示的密文
	 * @param plaintext 明文
	 * @param publicKey Base64表示的公钥
	 * @return Base64表示的密文
	 */
	public static String encryptToBase64WithBase64PublicKey(final String plaintext, final String publicKey) {
		return LKBase64Encoder.encodeWithDecimal(encryptToDecimalWithHexPublicKey(plaintext, LKBase64Decoder.decodeToHex(publicKey)));
	}

}
