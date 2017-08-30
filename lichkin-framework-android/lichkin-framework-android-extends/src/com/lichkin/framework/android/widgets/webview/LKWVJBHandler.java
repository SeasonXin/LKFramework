package com.lichkin.framework.android.widgets.webview;

/**
 * 处理方法
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
interface LKWVJBHandler {

	/**
	 * 请求方法
	 * @param data 数据
	 * @param callback 回调方法
	 */
	public void request(Object data, LKWVJBResponseCallback callback);

}
