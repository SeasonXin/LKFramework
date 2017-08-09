package com.lichkin.framework.bases.statics.configs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 系统配置对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@NoArgsConstructor
public class LKSysConfig {

	/** 配置键 */
	private String configKey;

	/** 配置值 */
	private String configValue;


	/**
	 * 构造方法
	 * @param configKey 配置键
	 * @param configValue 配置值
	 */
	public LKSysConfig(final String configKey, final String configValue) {
		super();
		this.configKey = configKey;
		this.configValue = configValue;
	}


	/**
	 * 构造方法
	 * @param configKey 配置键
	 * @param configValue 配置值
	 */
	public LKSysConfig(final String configKey, final boolean configValue) {
		this(configKey, String.valueOf(configValue));
	}


	/**
	 * 构造方法
	 * @param configKey 配置键
	 * @param configValue 配置值
	 */
	public LKSysConfig(final String configKey, final int configValue) {
		this(configKey, String.valueOf(configValue));
	}

}
