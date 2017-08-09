package com.lichkin.framework.springboot.utils;

import static com.lichkin.framework.statics.LKSmsConfigs.CONFIG_PREFIX_SMS_MSG;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 使用本包相关工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSmsUtils {

	/**
	 * 获取短信消息，从配置文件中读取lichkin.business.sms.msg.busType的配置值
	 * @param busType 业务类型
	 * @return 短信消息
	 */
	public static String getSmsMsg(final LKPrototypeEnum busType) {
		return LKPropertiesUtils.getProperty(CONFIG_PREFIX_SMS_MSG + busType.toString());
	}


	/**
	 * 获取短信消息，从配置文件中读取lichkin.business.sms.msg.busType的配置值
	 * @param busType 业务类型
	 * @param replaceDatas 数据集合。用于替换内容中的动态值。
	 * @return 短信消息
	 */
	public static String getSmsMsg(final LKPrototypeEnum busType, final LKDatas replaceDatas) {
		return LKStringUtils.replaceDatas(getSmsMsg(busType), replaceDatas);
	}

}
