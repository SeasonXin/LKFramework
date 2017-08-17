package com.lichkin.framework.android.utils;

import com.lichkin.framework.android.statics.LKStatics;

import android.util.Log;

/**
 * 日志工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKLogUtils {

	private static final String TAG = LKStatics.TAG;


	public static void v(final String msg) {
		Log.v(TAG, msg);
	}


	public static void v(final String msg, final Throwable tr) {
		Log.v(TAG, msg, tr);
	}


	public static void d(final String msg) {
		Log.d(TAG, msg);
	}


	public static void d(final String msg, final Throwable tr) {
		Log.d(TAG, msg, tr);
	}


	public static void i(final String msg) {
		Log.i(TAG, msg);
	}


	public static void i(final String msg, final Throwable tr) {
		Log.i(TAG, msg, tr);
	}


	public static void w(final String msg) {
		Log.w(TAG, msg);
	}


	public static void w(final String msg, final Throwable tr) {
		Log.w(TAG, msg, tr);
	}


	public static void w(final Throwable tr) {
		Log.w(TAG, tr);
	}


	public static void e(final String msg) {
		Log.e(TAG, msg);
	}


	public static void e(final String msg, final Throwable tr) {
		Log.e(TAG, msg, tr);
	}


	public static void wtf(final String msg) {
		Log.wtf(TAG, msg);
	}


	public static void wtf(final String msg, final Throwable tr) {
		Log.wtf(TAG, msg, tr);
	}


	public static void wtf(final Throwable tr) {
		Log.wtf(TAG, tr);
	}

}
