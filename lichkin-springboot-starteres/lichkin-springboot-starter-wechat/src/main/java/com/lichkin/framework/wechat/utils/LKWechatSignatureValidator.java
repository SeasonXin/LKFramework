package com.lichkin.framework.wechat.utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.bases.beans.LKHexMessage;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springboot.wechat.LKWechatProperties;

/**
 * 签名验证工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKWechatSignatureValidator {

	/**
	 * 验证
	 * @param signature 传入的签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return 验证成功返回true，否则返回false。
	 */
	public static void check(final String signature, final String timestamp, final String nonce) {
		final String[] arr = { LKWechatProperties.WECHAT_PROJECT_TOKEN, timestamp, nonce };

		Arrays.sort(arr);

		final StringBuilder sb = new StringBuilder();
		for (final String str : arr) {
			sb.append(str);
		}
		final String result = new LKHexMessage(DigestUtils.sha1(sb.toString())).getMessage();

		if (!StringUtils.equalsIgnoreCase(result, signature)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PERMISSION_DENIED, "");
		}
	}

}
