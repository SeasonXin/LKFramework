package com.lichkin.framework.android.bluetooth.services;

import java.util.UUID;

import com.lichkin.framework.android.bluetooth.LKBluetoothActionEnum;
import com.lichkin.framework.android.bluetooth.LKBluetoothGattStateEnum;
import com.lichkin.framework.android.bluetooth.LKBluetoothStatics;
import com.lichkin.framework.android.statics.LKStatics;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class LKBluetoothService extends Service {

	public static LKBluetoothService ctx;

	private BluetoothManager mBluetoothManager;

	private BluetoothAdapter mBluetoothAdapter;

	private String mBluetoothDeviceAddress;

	private BluetoothGatt mBluetoothGatt;

	private LKBluetoothGattStateEnum mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;

	private Handler mHandler;

	private Runnable mDisconnectRunnable;

	private boolean mDelayed = false;

	public static final String DISONNECT_FROM_STATE = "接收到onConnectionStateChange变为disconnect";

	public static final String DISCONNECT_FROM_DELAY = "连接超时或连接成功后获取数据超时";


	@Override
	public void onCreate() {
		super.onCreate();
		mHandler = new Handler();
		mDisconnectRunnable = new Runnable() {

			@Override
			public void run() {
				if (mConnectionState != LKBluetoothGattStateEnum.DISCONNECTED) {
					mDelayed = false;
					disconnect();
				}
			}
		};
		ctx = this;
	}


	// 连接的回调方法
	private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {

		// 连接状态发生改变
		@Override
		public void onConnectionStateChange(final BluetoothGatt gatt, final int status, final int newState) {
			LKBluetoothActionEnum intentAction;
			if ((newState == BluetoothProfile.STATE_CONNECTED) && (mConnectionState != LKBluetoothGattStateEnum.CONNECTED)) {
				removeDelayOperation();
				// 如果连接成功，通过广播方式告知MainAcivity
				addDelayOperation(10 * 1000);
				intentAction = LKBluetoothActionEnum.GATT_CONNECTED;
				mConnectionState = LKBluetoothGattStateEnum.CONNECTED;
				sendBroadcast(new Intent(intentAction.toString()));
				mBluetoothGatt.discoverServices();
			} else if ((newState == BluetoothProfile.STATE_DISCONNECTED) && (mConnectionState != LKBluetoothGattStateEnum.DISCONNECTED)) {
				removeDelayOperation();
				// 如果连接断开，通过广播方式告知MainActivity
				intentAction = LKBluetoothActionEnum.GATT_DISCONNECTED;
				mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;
				sendBroadcast(new Intent(intentAction.toString()));
			}
		};


		// 发现services
		@Override
		public void onServicesDiscovered(final BluetoothGatt gatt, final int status) {

			if (status == BluetoothGatt.GATT_SUCCESS) {
				sendBroadcast(new Intent(LKBluetoothActionEnum.GATT_SERVICES_DISCOVERED.toString()));
			}
		};


		// 读取characteristic
		@Override
		public void onCharacteristicRead(final BluetoothGatt gatt, final android.bluetooth.BluetoothGattCharacteristic characteristic, final int status) {
			if (status == BluetoothGatt.GATT_SUCCESS) {
				broadcastUpdate(LKBluetoothActionEnum.DATA_AVAILABLE, characteristic);
			}
		};


		// 写入characteristic
		@Override
		public void onCharacteristicWrite(final BluetoothGatt gatt, final android.bluetooth.BluetoothGattCharacteristic characteristic, final int status) {
			System.out.println("on write success   " + characteristic.getValue());
		};


		// characteristic改变，接受notify的数据
		@Override
		public void onCharacteristicChanged(final BluetoothGatt gatt, final android.bluetooth.BluetoothGattCharacteristic characteristic) {
			removeDelayOperation();
			broadcastUpdate(LKBluetoothActionEnum.DATA_AVAILABLE, characteristic);
		};

	};


	@Override
	public IBinder onBind(final Intent intent) {
		return new Binder();
	}


	@Override
	public boolean onUnbind(final Intent intent) {
		close();
		return super.onUnbind(intent);
	}


	// 在做完操作后，需要关闭连接和服务
	public void close() {
		removeDelayOperation();
		disconnect();
		if (mBluetoothGatt == null) {
			return;
		}
		mBluetoothGatt.close();
		mBluetoothGatt = null;
	}


	// 将数据转换成16进制后发送广播
	private void broadcastUpdate(final LKBluetoothActionEnum action, final BluetoothGattCharacteristic characteristic) {
		final Intent intent = new Intent(action.toString());
		final byte[] data = characteristic.getValue();
		// 将数据转换成16进制
		if ((data != null) && (data.length > 0)) {
			final StringBuilder stringBuilder = new StringBuilder(data.length);
			for (final byte byteChar : data) {
				stringBuilder.append(String.format("%02x ", byteChar));
			}
			Log.i(LKStatics.TAG, String.valueOf(data.length) + "     " + characteristic.getUuid().toString());
			// 将数据放入intent中
			intent.putExtra(LKBluetoothStatics.DATAS, stringBuilder.toString().trim());
		}
		sendBroadcast(intent);
	}


	// 开启或关闭characteristic告知
	public void setCharacteristicNotification(final BluetoothGattCharacteristic characteristic, final boolean enabled) {
		if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
			return;
		}
		final BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
		if (descriptor != null) {
			descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
			mBluetoothGatt.writeDescriptor(descriptor);
		}
		mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
	}


	// 初始化参数
	public boolean initialize() {
		if (mBluetoothManager == null) {
			mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
			if (mBluetoothManager == null) {
				return false;
			}
		}

		mBluetoothAdapter = mBluetoothManager.getAdapter();
		if (mBluetoothAdapter == null) {
			return false;
		}

		return true;
	}


	// 根据address连接设备
	public boolean connect(final String address) {
		if ((mBluetoothAdapter == null) || (address == null)) {
			mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;
			return false;
		}
		final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
		if (device == null) {
			mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;
			return false;
		}
		if ((mBluetoothDeviceAddress != null) && address.equals(mBluetoothDeviceAddress) && (mBluetoothGatt != null)) {
			if (mBluetoothGatt.connect()) {
				mConnectionState = LKBluetoothGattStateEnum.CONNECTED;
				return true;
			} else {
				mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;
				return false;
			}
		}
		mBluetoothGatt = device.connectGatt(this, false, mGattCallback);
		mBluetoothDeviceAddress = address;
		mConnectionState = LKBluetoothGattStateEnum.CONNECTED;
		return true;
	}


	public boolean connect(final String address, final int overtime) {
		removeDelayOperation();
		final boolean result = connect(address);
		addDelayOperation(overtime);
		return result;
	}


	// 断开连接
	public void disconnect() {
		if (mBluetoothGatt == null) {
			return;
		}
		mBluetoothGatt.disconnect();
		if (mConnectionState != LKBluetoothGattStateEnum.DISCONNECTED) {
			mConnectionState = LKBluetoothGattStateEnum.DISCONNECTED;
			sendBroadcast(new Intent(LKBluetoothActionEnum.GATT_DISCONNECTED.toString()));
		}
	}


	public LKBluetoothGattStateEnum getConnectState() {
		return mConnectionState;
	}


	// 根据UUID获取service
	public BluetoothGattService getServiceByUuid(final String uuid) {
		if (mBluetoothGatt == null) {
			return null;
		}
		return mBluetoothGatt.getService(UUID.fromString(uuid));
	}


	private void removeDelayOperation() {

		if (mDelayed) {
			mHandler.removeCallbacks(mDisconnectRunnable);
			mDelayed = false;
		}
	}


	private void addDelayOperation(final int delayMillis) {
		if (!mDelayed) {
			mDelayed = mHandler.postDelayed(mDisconnectRunnable, delayMillis);
		}
	}


	// 向characteristic写入value
	public void writeCharacteristic(final BluetoothGattCharacteristic characteristic) {
		if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
			return;
		}
		mBluetoothGatt.writeCharacteristic(characteristic);
	}


	// 读取characteristic中的value
	public void readCharacteristic(final BluetoothGattCharacteristic characteristic) {
		if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
			return;
		}
		mBluetoothGatt.readCharacteristic(characteristic);
	}

}
