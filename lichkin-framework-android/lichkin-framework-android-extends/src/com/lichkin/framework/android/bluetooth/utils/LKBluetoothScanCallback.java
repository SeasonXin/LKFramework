package com.lichkin.framework.android.bluetooth.utils;

import java.util.List;

import android.bluetooth.BluetoothDevice;

/**
 * 蓝牙扫描回调处理
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKBluetoothScanCallback {

	/**
	 * 扫描开始回调方法
	 */
	public abstract void onScanStarting();


	/**
	 * 扫描中回调方法
	 */
	public abstract void onScanning();


	/**
	 * 扫描结束回调方法
	 * @param listBluetoothDevice 蓝牙设备列表
	 */
	public abstract void onScanStoped(List<BluetoothDevice> listDevice);

}
