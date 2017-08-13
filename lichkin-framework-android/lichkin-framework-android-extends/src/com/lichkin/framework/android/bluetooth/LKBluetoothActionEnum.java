package com.lichkin.framework.android.bluetooth;

/**
 * 蓝牙活动状态
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKBluetoothActionEnum {

	/** GATT已连接 */
	GATT_CONNECTED,

	/** GATT断开连接 */
	GATT_DISCONNECTED,

	/** GATT服务被发现 */
	GATT_SERVICES_DISCOVERED,

	/** 数据取得 */
	DATA_AVAILABLE;

}
