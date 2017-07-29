package com.lichkin.framework.utils.security;

import java.security.KeyPair;

import com.lichkin.framework.utils.lang.LKHexUtils;

/**
 * 秘钥对
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKKeyPair {

	/** 秘钥对 */
	private final KeyPair keyPair;

	/** 私钥 */
	private final String privateKey;

	/** 公钥 */
	private final String publicKey;


	/**
	 * 构造方法
	 * @param keyPair 钥匙对
	 */
	public LKKeyPair(final KeyPair keyPair) {
		super();
		this.keyPair = keyPair;
		privateKey = LKHexUtils.toHexFromBinaryData(keyPair.getPrivate().getEncoded());
		publicKey = LKHexUtils.toHexFromBinaryData(keyPair.getPublic().getEncoded());
	}


	/**
	 * 获取钥匙对
	 * @return 钥匙对
	 */
	public KeyPair getKeyPair() {
		return keyPair;
	}


	/**
	 * 获取私钥
	 * @return 私钥
	 */
	public String getPrivateKey() {
		return privateKey;
	}


	/**
	 * 获取公钥
	 * @return 公钥
	 */
	public String getPublicKey() {
		return publicKey;
	}


	@Override
	public String toString() {
		return "LKKeyPair [privateKey=" + privateKey + ", publicKey=" + publicKey + "]";
	}

}
