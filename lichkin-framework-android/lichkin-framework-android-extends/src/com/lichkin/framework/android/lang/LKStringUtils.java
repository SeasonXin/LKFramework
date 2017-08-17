package com.lichkin.framework.android.lang;

/**
 * 字符串工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKStringUtils {

	/**
	 * 是否为空
	 * @param str 字符串
	 * @return null,"","null","NULL"返回false，否则返回true。
	 */
	public static boolean isBlank(final String str) {
		if ((str == null) || "".equals(str.trim()) || "NULL".equalsIgnoreCase(str.trim())) {
			return true;
		}
		return false;
	}


	/**
	 * 是否为非空
	 * @param str 字符串
	 * @return null,"","null","NULL"返回true，否则返回false。
	 */
	public static boolean isNotBlank(final String str) {
		return !isBlank(str);
	}

}
