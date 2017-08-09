package com.lichkin.framework.utils.security;

import java.security.KeyPair;

import com.lichkin.framework.utils.lang.LKHexUtils;

import lombok.Getter;

/**
 * 秘钥对
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
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


	@Override
	public String toString() {
		return "LKKeyPair [privateKey=" + privateKey + ", publicKey=" + publicKey + "]";
	}

}
