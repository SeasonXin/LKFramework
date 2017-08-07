package com.lichkin.framework.wechat.statics;

import com.lichkin.framework.springboot.wechat.LKWechatProperties;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * wechat常量
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWechatStatics {

	/** 微信公众号ID */
	public static final String OPENID = "openid";

	/** 关注 */
	public static final String SUBSCRIBE = "subscribe";

	/** 取消关注 */
	public static final String UNSUBSCRIBE = "unsubscribe";

	/** 项目路径 */
	public static final String PROJECT_URL = "http://" + LKWechatProperties.WECHAT_PROJECT_DOMAINNAME + (LKStringUtils.isBlank(LKWechatProperties.WECHAT_PROJECT_NAME) ? "" : LKWechatProperties.WECHAT_PROJECT_NAME);

	/** 扫描二维码sence_id前缀 */
	public static final String SENCE_ID_PREFIX = "qrscene_";

	/** 扫描二维码sence_id前缀长度 */
	public static final int SENCE_ID_PREFIX_LENGTH = LKWechatStatics.SENCE_ID_PREFIX.length();

}
