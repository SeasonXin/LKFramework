package com.lichkin.framework.android.utils;

import com.lichkin.framework.android.beans.LKScreenBean;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * 安卓应用工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKAndroidUtils {

	/** 安卓应用 */
	private static Application app;

	/** 屏幕像素比例 */
	private static float dpTopxRatio;


	/**
	 * 获取安卓应用
	 * @return 安卓应用
	 */
	public static Application getApp() {
		return app;
	}


	/**
	 * 设置安卓应用
	 * @param app 安卓应用
	 */
	public static void setApp(final Application app) {
		LKAndroidUtils.app = app;
		dpTopxRatio = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, app.getResources().getDisplayMetrics());
	}


	/**
	 * 获取屏幕像素比例
	 * @return 屏幕像素比例
	 */
	public static float getDpTopxRatio() {
		return dpTopxRatio;
	}


	/**
	 * 获取屏幕分辨率
	 * @param context 安卓上下文
	 * @return 屏幕分辨率
	 */
	public static LKScreenBean getScreenDispaly() {
		final DisplayMetrics dm = new DisplayMetrics();

		final WindowManager windowManager = (WindowManager) app.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);

		return new LKScreenBean(dm.widthPixels, dm.heightPixels);
	}


	/**
	 * 根据px值获取dp值
	 * @param px px值
	 * @return dp值
	 */
	public static int getDpValueByPxValue(final int px) {
		return (int) (dpTopxRatio * px);
	}


	/**
	 * 根据dp值获取px值
	 * @param dp dp值
	 * @return px值
	 */
	public static int getPxValueByDpValue(final int dp) {
		return (int) (dp / dpTopxRatio);
	}

}
