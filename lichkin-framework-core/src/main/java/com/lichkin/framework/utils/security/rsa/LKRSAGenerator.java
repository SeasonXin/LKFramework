package com.lichkin.framework.utils.security.rsa;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com.lichkin.framework.utils.security.LKKeyPair;

/**
 * RSA秘钥生成器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRSAGenerator {

	/**
	 * 生成秘钥对
	 * @param keysize 秘钥大小
	 * @return 秘钥对
	 */
	public static LKKeyPair generatKeys(final int keysize) {
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (keyPairGenerator == null) {
			return null;
		}
		final SecureRandom random = new SecureRandom();
		random.setSeed(("" + (System.currentTimeMillis() * Math.random() * Math.random())).getBytes());
		keyPairGenerator.initialize(keysize, random);
		return new LKKeyPair(keyPairGenerator.genKeyPair());
	}

}
