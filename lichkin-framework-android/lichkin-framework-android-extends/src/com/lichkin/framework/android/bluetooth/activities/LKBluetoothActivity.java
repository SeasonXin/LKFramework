package com.lichkin.framework.android.bluetooth.activities;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.activities.LKActivity;
import com.lichkin.framework.android.bluetooth.utils.LKBluetoothDeviceScanner;
import com.lichkin.framework.android.bluetooth.utils.LKBluetoothScanCallback;
import com.lichkin.framework.android.utils.LKDialogUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;
import com.lichkin.framework.android.widgets.LKCallback;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * 蓝牙功能页面
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKBluetoothActivity extends LKActivity {

	/** 调用蓝牙特殊定义的编码 */
	public static final int BLUETOOTH_ACTION_REQUEST_ENABLE_CODE = 0x0001;

	/** 蓝牙适配器 */
	protected BluetoothAdapter bluetoothAdapter;

	/** 扫描状态变更广播接收器 */
	protected BroadcastReceiver stateChangedActionBroadcastReceiver;

	/** 设备扫描工具 */
	protected LKBluetoothDeviceScanner deviceScanner;

	/** 是否获取到ActivityResult */
	private boolean resultOk = false;


	/**
	 * 获取扫描回调方法
	 * @return 扫描回调方法
	 */
	protected abstract LKBluetoothScanCallback getScanCallback();


	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
			// 不支持蓝牙，则提示并退出。
			LKDialogUtils.alert(ctx, LKResourceUtils.getString(R.string.bluetooth_nonsupport_tip), new LKCallback() {

				@Override
				public void callback() {
					finish();
				}

			});
		}

		// 确定支持蓝牙功能后才初始化各个参数
		bluetoothAdapter = ((BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter();
		stateChangedActionBroadcastReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(final Context context, final Intent intent) {
				checkBluetooth();
			}

		};
		deviceScanner = LKBluetoothDeviceScanner.getInstance(bluetoothAdapter);
		deviceScanner.scan(getScanCallback(), ctx);
	}


	@Override
	protected void onResume() {
		super.onStop();
		if (!resultOk) {
			checkBluetooth();
			registerReceiver(stateChangedActionBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
		}
	}


	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(stateChangedActionBroadcastReceiver);
	}


	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == BLUETOOTH_ACTION_REQUEST_ENABLE_CODE) {
			switch (resultCode) {
				case RESULT_CANCELED:
					resultOk = false;
					LKDialogUtils.alert(ctx, LKResourceUtils.getString(R.string.bluetooth_off_tip), new LKCallback() {

						@Override
						public void callback() {
							checkBluetooth();
						}

					});
					checkBluetooth();
				break;
				case RESULT_OK:
					resultOk = true;
				break;
				case RESULT_FIRST_USER:
					resultOk = false;
				break;
				default:
					resultOk = false;
				break;
			}
		}
	}


	/**
	 * 检查蓝牙是否打开
	 */
	private void checkBluetooth() {
		if ((bluetoothAdapter != null) && bluetoothAdapter.isEnabled()) {
			final Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, BLUETOOTH_ACTION_REQUEST_ENABLE_CODE);
		}
	}

}
