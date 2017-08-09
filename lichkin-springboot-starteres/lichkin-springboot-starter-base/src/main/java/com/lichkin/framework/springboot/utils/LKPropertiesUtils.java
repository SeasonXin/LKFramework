package com.lichkin.framework.springboot.utils;

import com.lichkin.LKMain;
import com.lichkin.framework.bases.statics.configs.LKSysConfigs;

/**
 * 属性工具类，被spring管理的所有属性配置。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPropertiesUtils {

	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @param defaultValue 默认值
	 * @return 参数值
	 */
	public static String getProperty(final String key, final String defaultValue) {
		String value = LKSysConfigs.get(key);// 先从框架中找配置值
		if (value == null) {// 框架中没有配置，则到配置文件中找配置值。
			value = LKMain.env.getProperty(key, defaultValue);
		}
		return value;
	}


	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @return 参数值
	 */
	public static String getProperty(final String key) {
		return getProperty(key, null);
	}


	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @param defaultValue 默认值
	 * @return 参数值
	 */
	public static boolean getProperty(final String key, final boolean defaultValue) {
		return Boolean.parseBoolean(getProperty(key, String.valueOf(defaultValue)));
	}


	/**
	 * 获取配置参数值
	 * @param key 参数名
	 * @param defaultValue 默认值
	 * @return 参数值
	 */
	public static int getProperty(final String key, final int defaultValue) {
		return Integer.parseInt(getProperty(key, String.valueOf(defaultValue)));
	}

}
