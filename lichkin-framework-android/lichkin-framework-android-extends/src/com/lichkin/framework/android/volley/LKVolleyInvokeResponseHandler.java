package com.lichkin.framework.android.volley;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

/**
 * LichKin标准接口请求回调处理接口
 */
public interface LKVolleyInvokeResponseHandler {

	/**
	 * 请求成功回调方法
	 * @param context 调用请求的对象上下文
	 * @param response 响应数据
	 * @throws JSONException
	 */
	public void doSuccess(Context context, JSONObject response) throws JSONException;


	/**
	 * 请求失败回调方法
	 * @param context 调用请求的对象上下文
	 * @param response 响应数据
	 * @throws JSONException
	 */
	public void doError(Context context, JSONObject response) throws JSONException;


	/**
	 * 接口调用异常后续处理
	 * @param context 调用请求的对象上下文
	 */
	public void doConnectionError(Context context);

}
