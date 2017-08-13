package com.lichkin.framework.android.utils;

/**
 * 资源工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKResourceUtils {

	/**
	 * 获取string值
	 * @param stringId string标签配置的name值
	 * @return string标签配置的值
	 */
	public static String getString(final int stringId) {
		return LKContextUtils.getInstance().getString(stringId);
	}


	/**
	 * 获取color值
	 * @param colorId color标签配置的name值
	 * @return color标签配置的值
	 */
	public static int getColor(final int colorId) {
		return LKContextUtils.getInstance().getResources().getColor(colorId);
	}


	/**
	 * 获取color值
	 * @param dimenId dimenId标签配置的name值
	 * @return color标签配置的值
	 */
	public static int getDimensionPixelSize(final int dimenId) {
		return LKContextUtils.getInstance().getResources().getDimensionPixelSize(dimenId);
	}

}
