package com.lichkin.framework.springboot.bus.sms.utils;

import static com.lichkin.framework.springboot.bus.sms.LKSMSConfigs.CONFIG_PREFIX_SMS_MSG;

import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;

/**
 * 使用本包相关工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSMSUtils {

	/**
	 * 获取短信消息，从配置文件中读取lichkin.business.sms.msg.busType的配置值
	 * @param busType 业务类型
	 * @return 短信消息
	 */
	public static String getSmsMsg(LKPrototypeEnum busType) {
		return LKPropertiesUtils.getProperty(CONFIG_PREFIX_SMS_MSG + busType.toString());
	}

}
