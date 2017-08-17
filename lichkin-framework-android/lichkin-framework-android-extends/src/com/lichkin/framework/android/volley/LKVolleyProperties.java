package com.lichkin.framework.android.volley;

import java.util.Properties;

/**
 * 请求配置属性
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKVolleyProperties {

	/** 配置属性 */
	private static Properties properties;

	/** 接口基本路径 */
	private static String BASE_URL;

	/** 接口版本号 */
	private static String VERSION;

	/** 接口后缀名 */
	private static String SUFFIX;

	/** 接口请求方用户名 */
	private static String CALLER_NAME;

	/** 接口请求方密码 */
	private static String PASSWORD;

	/** 超时时长 */
	private static int TIMEOUT;

	/** 是否打印日志 */
	private static boolean SHOW_LOG;

	static {
		final Properties pro = new Properties();
		try {
			pro.load(LKVolleyProperties.class.getResourceAsStream("/assets/request.properties"));
		} catch (final Exception e) {
			e.printStackTrace();
		}
		properties = pro;
		BASE_URL = pro.getProperty("baseUrl." + pro.getProperty("environment"), "");
		VERSION = pro.getProperty("version", "0100");
		SUFFIX = pro.getProperty("suffix", ".do");
		CALLER_NAME = pro.getProperty("callerName", "");
		PASSWORD = pro.getProperty("password", "");
		TIMEOUT = Integer.parseInt(pro.getProperty("timeout", "15000"));
		SHOW_LOG = Boolean.parseBoolean(pro.getProperty("showLog", "false"));
	}


	public static Properties getProperties() {
		return properties;
	}


	public static String getBASE_URL() {
		return BASE_URL;
	}


	public static String getVERSION() {
		return VERSION;
	}


	public static String getSUFFIX() {
		return SUFFIX;
	}


	public static String getCALLER_NAME() {
		return CALLER_NAME;
	}


	public static String getPASSWORD() {
		return PASSWORD;
	}


	public static int getTIMEOUT() {
		return TIMEOUT;
	}


	public static boolean isSHOW_LOG() {
		return SHOW_LOG;
	}

}
