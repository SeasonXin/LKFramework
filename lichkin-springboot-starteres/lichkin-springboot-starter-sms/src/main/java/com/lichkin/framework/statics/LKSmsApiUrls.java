package com.lichkin.framework.statics;

import static com.lichkin.framework.statics.LKSmsProperties.SMS_HAIYAN_ACCOUNT;
import static com.lichkin.framework.statics.LKSmsProperties.SMS_HAIYAN_PASSWORD;
import static com.lichkin.framework.statics.LKSmsProperties.SMS_HAIYAN_USERID;

/**
 * 使用本包相关接口地址
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKSmsApiUrls {

	/** 海岩短信推送地址 */
	public static final String SMS_HAIYAN_SEND_URL = "http://www.duanxin10086.com/sms.aspx?action=send&userid=" + SMS_HAIYAN_USERID + "&account=" + SMS_HAIYAN_ACCOUNT + "&password=" + SMS_HAIYAN_PASSWORD;

}
