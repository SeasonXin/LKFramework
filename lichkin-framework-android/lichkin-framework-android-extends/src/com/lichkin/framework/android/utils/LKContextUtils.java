package com.lichkin.framework.android.utils;

import android.app.Application;

/**
 * 上下文工具类
 */
public class LKContextUtils extends Application {

	/** 单例 */
	private static LKContextUtils instance;


	/**
	 * 构造方法
	 */
	public LKContextUtils() {
		super();
	}


	/**
	 * 获取单例
	 * @return 单例
	 */
	public static synchronized LKContextUtils getInstance() {
		if (instance == null) {
			instance = new LKContextUtils();
		}
		return instance;
	}


	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		LKAndroidUtils.setApp(instance);
	}

}