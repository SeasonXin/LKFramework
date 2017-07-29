package com.lichkin.framework.utils.security.rsa;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

/**
 * RSA工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class LKRSA {

	/** 钥匙工厂 */
	protected static KeyFactory keyFactory;

	static {
		try {
			LKRSA.keyFactory = KeyFactory.getInstance("RSA");
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
