package com.lichkin.framework.android.bluetooth.utils;

import java.util.List;

import com.lichkin.framework.android.statics.LKStatics;

import android.bluetooth.BluetoothDevice;
import android.util.Log;

/**
 * 
 * 蓝牙扫描回调处理实现
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBluetoothScanCallbackImpl implements LKBluetoothScanCallback {

	@Override
	public void onScanStarting() {
		Log.d(LKStatics.TAG, "开始扫描回调");
	}


	@Override
	public void onScanning() {
		Log.d(LKStatics.TAG, "扫描中回调");
	}


	@Override
	public void onScanStoped(List<BluetoothDevice> listDevice) {
		Log.d(LKStatics.TAG, "扫描结束回调");
		Log.i(LKStatics.TAG, "扫描到" + listDevice.size() + "个蓝牙设备");
		for (BluetoothDevice device : listDevice) {
			Log.i(LKStatics.TAG, "address -> " + device.getAddress() + "; name -> " + device.getName() + "; uuids -> " + device.getUuids() + "。");
		}
	}

}
