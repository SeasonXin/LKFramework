package com.lichkin.framework.bases.statics.configs;

import java.util.HashMap;
import java.util.Map;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

/**
 * 系统配置集合类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSysConfigs implements LKSysConfigKeys {

	/** 配置集合 */
	public static Map<String, String> map = new HashMap<>();


	/**
	 * 增加配置
	 * @param config 配置对象
	 */
	public static void put(final LKSysConfig config) {
		map.put(config.getConfigKey(), config.getConfigValue());
	}


	/**
	 * 获取配置值
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 配置值
	 */
	public static String get(final String key, final String defaultValue) {
		final String value = map.get(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}


	/**
	 * 获取配置值
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 配置值
	 */
	public static int get(final String key, final int defaultValue) {
		final String value = map.get(key);
		if (value == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(value);
		} catch (final Exception e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
		}
	}


	/**
	 * 获取配置值
	 * @param key 键
	 * @return 配置值
	 */
	public static String get(final String key) {
		String defaultValue = null;
		switch (key) {
			case CONFIG_LK_SYSTEM_TAG:
				defaultValue = "LichKin-Project";
			break;
			case CONFIG_LK_SYSTEM_NAME:
				defaultValue = "鑫宏利业项目";
			break;
			case CONFIG_LK_SYSTEM_LOGLEVEL:
				defaultValue = "warn";
			break;
			case CONFIG_LK_SYSTEM_PRODUCTION:
				defaultValue = "false";
			break;
			default:
			break;
		}
		return get(key, defaultValue);
	}

}
