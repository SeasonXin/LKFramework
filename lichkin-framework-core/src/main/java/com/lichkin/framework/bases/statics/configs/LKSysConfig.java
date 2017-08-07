package com.lichkin.framework.bases.statics.configs;

/**
 * 系统配置对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSysConfig {

	/** 配置键 */
	private String configKey;

	/** 配置值 */
	private String configValue;


	/**
	 * 构造方法
	 */
	public LKSysConfig() {
		super();
	}


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


	/**
	 * 获取配置键
	 * @return 配置键
	 */
	public String getConfigKey() {
		return configKey;
	}


	/**
	 * 设置配置键
	 * @param configKey 配置键
	 */
	public void setConfigKey(final String configKey) {
		this.configKey = configKey;
	}


	/**
	 * 获取配置值
	 * @return 配置值
	 */
	public String getConfigValue() {
		return configValue;
	}


	/**
	 * 设置配置值
	 * @param configValue 配置值
	 */
	public void setConfigValue(final String configValue) {
		this.configValue = configValue;
	}

}
