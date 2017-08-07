package com.lichkin.framework.wechat.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 签名
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class Signature {

	/** 应用ID */
	private String appid;

	/** 地址 */
	private String url;

	/** 微信脚本票据 */
	private String jsapiTicket;

	/** 随机数 */
	private String nonceStr;

	/** 时间戳 */
	private String timestamp;

	/** 签名 */
	private String signature;

}
