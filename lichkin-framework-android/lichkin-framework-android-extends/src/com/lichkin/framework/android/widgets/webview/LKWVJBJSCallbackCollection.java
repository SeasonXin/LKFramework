package com.lichkin.framework.android.widgets.webview;

import java.util.HashMap;
import java.util.Map;

import com.lichkin.framework.android.utils.LKLogUtils;

import android.webkit.JavascriptInterface;

/**
 * 回调方法集合
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class LKWVJBJSCallbackCollection {

	/** 回调方法集合 */
	private final Map<String, LKWVJBJSCallback> callbacks = new HashMap<>();


	/**
	 * 增加回调方法
	 * @param key 键
	 * @param callback 回调方法
	 */
	public void addCallback(final String key, final LKWVJBJSCallback callback) {
		callbacks.put(key, callback);
	}


	/**
	 * 执行结束后调用方法
	 * @param key 键
	 * @param value 值
	 */
	@JavascriptInterface
	public void onResultForScript(final String key, final String value) {
		LKLogUtils.d("onResultForScript: " + value);
		final LKWVJBJSCallback callback = callbacks.remove(key);
		if (callback != null) {
			callback.onReceiveValue(value);
		}
	}

}
