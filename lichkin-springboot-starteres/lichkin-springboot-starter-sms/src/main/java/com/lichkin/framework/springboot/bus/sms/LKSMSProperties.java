package com.lichkin.framework.springboot.bus.sms;

import com.lichkin.framework.springboot.utils.LKPropertiesUtils;

/**
 * 使用本包相关配置值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKSMSProperties extends LKSMSConfigs {

	/** 配置值 */
	public static final String SMS_HAIYAN_ENCODING = LKPropertiesUtils.getProperty(CONFIG_SMS_HAIYAN_ENCODING, "UTF-8");

	/** 配置值 */
	public static final String SMS_HAIYAN_USERID = LKPropertiesUtils.getProperty(CONFIG_SMS_HAIYAN_USERID, "");

	/** 配置值 */
	public static final String SMS_HAIYAN_ACCOUNT = LKPropertiesUtils.getProperty(CONFIG_SMS_HAIYAN_ACCOUNT, "");

	/** 配置值 */
	public static final String SMS_HAIYAN_PASSWORD = LKPropertiesUtils.getProperty(CONFIG_SMS_HAIYAN_PASSWORD, "");

}
