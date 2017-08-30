package com.lichkin.framework.android.widgets.webview;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 消息对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class LKWVJBMessage {

	/** 数据 */
	Object data = null;

	/** 回调方法ID */
	String callbackId = null;

	/** 处理方法名 */
	String handlerName = null;

	/** 响应ID */
	String responseId = null;

	/** 响应数据 */
	Object responseData = null;


	/**
	 * 转换为JSON字符串
	 * @return JSON字符串
	 */
	public String toJSON() {
		return toJSONObject().toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"").replaceAll("\'", "\\\\\'").replaceAll("\n", "\\\\\n").replaceAll("\r", "\\\\\r").replaceAll("\f", "\\\\\f");
	}


	/**
	 * 转换为JSON对象
	 * @return JSON对象
	 */
	public JSONObject toJSONObject() {
		final JSONObject jo = new JSONObject();
		try {
			if (callbackId != null) {
				jo.put("callbackId", callbackId);
			}
			if (data != null) {
				jo.put("data", data);
			}
			if (handlerName != null) {
				jo.put("handlerName", handlerName);
			}
			if (responseId != null) {
				jo.put("responseId", responseId);
			}
			if (responseData != null) {
				jo.put("responseData", responseData);
			}
		} catch (final JSONException e) {
			e.printStackTrace();
		}
		return jo;
	}


	/**
	 * 构造方法
	 */
	public LKWVJBMessage() {
		super();
	}


	/**
	 * 构造方法
	 * @param jo JSON对象
	 */
	public LKWVJBMessage(final JSONObject jo) {
		try {
			if (jo.has("callbackId")) {
				callbackId = jo.getString("callbackId");
			}
			if (jo.has("data")) {
				data = jo.get("data");
			}
			if (jo.has("handlerName")) {
				handlerName = jo.getString("handlerName");
			}
			if (jo.has("responseId")) {
				responseId = jo.getString("responseId");
			}
			if (jo.has("responseData")) {
				responseData = jo.get("responseData");
			}
		} catch (final JSONException e) {
			e.printStackTrace();
		}
	}

}
