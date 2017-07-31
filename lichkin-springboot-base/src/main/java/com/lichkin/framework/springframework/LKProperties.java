package com.lichkin.framework.springframework;

import com.lichkin.framework.springboot.utils.LKPropertiesUtils;

/**
 * 使用本包相关配置值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKProperties implements LKConfigs {

	/** 配置值 */
	public static final String LK_SYSTEM_TAG = LKPropertiesUtils.getProperty(CONFIG_LK_SYSTEM_TAG, "lichkin");

	/** 配置值 */
	public static final String LK_SYSTEM_NAME = LKPropertiesUtils.getProperty(CONFIG_LK_SYSTEM_NAME, "鑫宏利业");

}
