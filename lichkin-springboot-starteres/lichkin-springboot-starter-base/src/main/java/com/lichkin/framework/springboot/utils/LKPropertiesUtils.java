package com.lichkin.framework.springboot.utils;

import com.lichkin.LKMain;

/**
 * 属性工具类，被spring管理的所有属性配置。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPropertiesUtils {

	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @return 参数值
	 */
	public static String getProperty(final String key) {
		return LKPropertiesUtils.getProperty(key, null);
	}


	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @param defaultValue 默认值
	 * @return 参数值
	 */
	public static String getProperty(final String key, final String defaultValue) {
		return LKMain.env.getProperty(key, defaultValue);
	}

}
