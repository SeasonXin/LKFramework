package com.lichkin.framework.android.widgets.webview;

import java.util.Properties;

/**
 * 网页配置属性
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKWebViewProperties {

	/** 配置属性 */
	private static Properties properties;

	/** 环境 */
	private static String ENVIRONMENT;

	static {
		final Properties pro = new Properties();
		try {
			pro.load(LKWebViewProperties.class.getResourceAsStream("/assets/webview.properties"));
		} catch (final Exception e) {
			e.printStackTrace();
		}
		properties = pro;
		ENVIRONMENT = pro.getProperty("environment");
	}


	public static Properties getProperties() {
		return properties;
	}


	public static String getUrl(final String key) {
		return getUrl(key, ENVIRONMENT);
	}


	public static String getUrl(final String key, final String environment) {
		return properties.getProperty(key + "." + environment);
	}

}
