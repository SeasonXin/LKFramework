package com.lichkin.framework.utils.security.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import com.lichkin.framework.utils.base64.LKBase64Decoder;
import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * RSA解密工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRSADecrypter extends LKRSA {

	/**
	 * 使用十六进制表示的私钥从十进制表示的密文中解密出明文
	 * @param ciphertext 十进制表示的密文
	 * @param privateKey 十六进制表示的私钥
	 * @return 明文
	 */
	public static String decryptFromDecimalWithHexPrivateKey(final String ciphertext, final String privateKey) {
		try {
			final RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) LKRSA.keyFactory.generatePrivate(new PKCS8EncodedKeySpec(LKHexUtils.toBytesFromHex(privateKey)));

			return new String(new BigInteger(ciphertext).modPow(rsaPrivateKey.getPrivateExponent(), rsaPrivateKey.getModulus()).toByteArray(), "UTF-8");
		} catch (final Exception e) {
			return null;
		}
	}


	/**
	 * 使用十六进制表示的私钥从Base64表示的密文中解密出明文
	 * @param ciphertext Base64表示的密文
	 * @param privateKey 十六进制表示的私钥
	 * @return 明文
	 */
	public static String decryptFromBase64WithHexPrivateKey(final String ciphertext, final String privateKey) {
		return decryptFromDecimalWithHexPrivateKey(LKBase64Decoder.decodeToDecimal(ciphertext), privateKey);
	}


	/**
	 * 使用Base64表示的私钥从十进制表示的密文中解密出明文
	 * @param ciphertext 十进制表示的密文
	 * @param privateKey Base64表示的私钥
	 * @return 明文
	 */
	public static String decryptFromDecimalWithBase64PrivateKey(final String ciphertext, final String privateKey) {
		return decryptFromDecimalWithHexPrivateKey(ciphertext, LKBase64Decoder.decodeToHex(privateKey));
	}


	/**
	 * 使用Base64表示的私钥从Base64表示的密文中解密出明文
	 * @param ciphertext Base64表示的密文
	 * @param privateKey Base64表示的私钥
	 * @return 明文
	 */
	public static String decryptFromBase64WithBase64PrivateKey(final String ciphertext, final String privateKey) {
		return decryptFromDecimalWithHexPrivateKey(LKBase64Decoder.decodeToDecimal(ciphertext), LKBase64Decoder.decodeToHex(privateKey));
	}

}
