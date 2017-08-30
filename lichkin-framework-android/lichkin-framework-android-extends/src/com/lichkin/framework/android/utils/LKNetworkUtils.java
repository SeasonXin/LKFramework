package com.lichkin.framework.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKNetworkUtils {

	/**
	 * 网络是否可用
	 * @param networkType 网络类型
	 * @return 可用返回true，否则返回false。
	 */
	public static boolean isNetworkAvailable(final int networkType) {
		final ConnectivityManager mConnectivityManager = (ConnectivityManager) LKAndroidUtils.getApp().getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo mWiFiNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (mWiFiNetworkInfo != null) {
			return mWiFiNetworkInfo.isAvailable();
		}
		return false;
	}


	/**
	 * WIFI网络是否可用
	 * @return 可用返回true，否则返回false。
	 */
	public static boolean isWifiAvailable() {
		return isNetworkAvailable(ConnectivityManager.TYPE_WIFI);
	}


	/**
	 * 移动网络是否可用
	 * @return 可用返回true，否则返回false。
	 */
	public static boolean isMobileConnected() {
		return isNetworkAvailable(ConnectivityManager.TYPE_MOBILE);
	}


	/**
	 * 网络是否可用
	 * @param networkType 网络类型
	 * @return 可用返回true，否则返回false。
	 */
	public static boolean isNetworkAvailable() {
		return isWifiAvailable() ? true : (isMobileConnected() ? true : false);
	}


	/**
	 * 当前网络类型
	 * @return 移动网络返回0，WIFI网络返回1，无网络返回-1。
	 */
	public static int getConnectedType() {
		return isWifiAvailable() ? ConnectivityManager.TYPE_WIFI : (isMobileConnected() ? ConnectivityManager.TYPE_MOBILE : -1);
	}

}
