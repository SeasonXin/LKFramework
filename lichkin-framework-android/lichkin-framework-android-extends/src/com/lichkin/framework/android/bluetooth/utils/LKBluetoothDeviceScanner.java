package com.lichkin.framework.android.bluetooth.utils;

import java.util.ArrayList;
import java.util.List;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.statics.LKStatics;
import com.lichkin.framework.android.utils.LKDialogUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;
import com.lichkin.framework.android.widgets.LKLoadingDialog;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * 蓝牙设备扫描器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBluetoothDeviceScanner {

	/** 单例 */
	private static LKBluetoothDeviceScanner instance;


	/**
	 * 构造方法
	 */
	private LKBluetoothDeviceScanner() {
	}


	/**
	 * 获取单例
	 * @return 单例
	 */
	public static synchronized LKBluetoothDeviceScanner getInstance(final BluetoothAdapter bluetoothAdapter) {
		if (instance == null) {
			instance = new LKBluetoothDeviceScanner();
		}
		instance.bluetoothAdapter = bluetoothAdapter;
		return instance;
	}


	/** 默认5秒超时 */
	private final static int TIME_OUT = 5000;

	/** 是否扫描中 */
	private boolean scanning = false;

	/** 蓝牙适配器 */
	private BluetoothAdapter bluetoothAdapter;

	/** 设备列表 */
	private final List<BluetoothDevice> listDevice = new ArrayList<BluetoothDevice>();


	/**
	 * 扫描设备
	 * @param callback 回调方法
	 */
	public void scan(final LKBluetoothScanCallback callback, final Context ctx) {
		scan(callback, ctx, TIME_OUT);
	}


	/**
	 * 扫描设备
	 * @param callback 回调方法
	 * @param timeout 超时时长
	 */
	public void scan(final LKBluetoothScanCallback callback, final Context ctx, final int timeout) {
		// 扫描开始时开启loading效果
		final LKLoadingDialog loading = LKDialogUtils.loading(ctx, LKResourceUtils.getString(R.string.bluetooth_device_scanning));

		// 处于扫描中则不再次进行扫描
		if (scanning) {
			Log.d(LKStatics.TAG, "蓝牙扫描中，本次跳过");
			callback.onScanning();
			loading.cancel();
			return;
		}

		// 清空设备列表
		listDevice.clear();

		// 开始扫描设备
		Log.d(LKStatics.TAG, "开始蓝牙扫描");
		bluetoothAdapter.startLeScan(leScanCallback);
		callback.onScanStarting();

		scanning = true;

		// 超时时间后执行
		Log.d(LKStatics.TAG, timeout + "毫秒后将结束蓝牙扫描");
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// 设置停止扫描状态
				scanning = false;

				// 扫描结束时退出loading效果
				loading.cancel();

				// 停止扫描设备
				Log.d(LKStatics.TAG, "结束蓝牙扫描");
				bluetoothAdapter.stopLeScan(leScanCallback);
				callback.onScanStoped(listDevice);
			}

		}, timeout);
	}


	/** 扫描回调方法 */
	private final LeScanCallback leScanCallback = new LeScanCallback() {

		@Override
		public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
			Log.i(LKStatics.TAG, "扫描到蓝牙设备=>address -> " + device.getAddress() + "; name -> " + device.getName() + "; uuids -> " + device.getUuids() + "; rssi -> " + rssi + "]" + "; scanRecord -> " + scanRecord + "。");
			if ((device != null) && !listDevice.contains(device)) {
				// 如果设备列表中没有此设备，则增加该设备。
				listDevice.add(device);
			}
		}

	};

}
