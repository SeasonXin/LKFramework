package com.lichkin.framework.wechat.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信调用对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public final class LKWechatBean {

	/** 微信公众号ID */
	private String accountOpenid;

	/** 用户ID */
	private String openid;

	/** 按钮名称 */
	private String btnName;

	/** 微信回调参数 */
	private String code;

	/** OAUTH2回调URL拼接参数 */
	private String state;

	/** 扫描动态二维码输入参数 */
	private String sceneId;

}
