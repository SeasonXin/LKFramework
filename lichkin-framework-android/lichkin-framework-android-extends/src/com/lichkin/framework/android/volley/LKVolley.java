package com.lichkin.framework.android.volley;

import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lichkin.framework.android.utils.LKLogUtils;

import android.content.Context;

/**
 * 请求工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKVolley {

	/**
	 * POST请求接口
	 * @param context 上下文
	 * @param url 接口地址
	 * @param params 请求参数
	 * @param success 成功回调
	 * @param error 失败回调
	 */
	public static void post(final Context context, final String url, final JSONObject params, final Response.Listener<JSONObject> success, final Response.ErrorListener error) {
		if (LKVolleyProperties.isSHOW_LOG()) {
			LKLogUtils.i("LKVolley.requestUrl=>" + url);
		}
		String jsonStr = "";
		if (params != null) {
			jsonStr = params.toString();
		}
		if (LKVolleyProperties.isSHOW_LOG()) {
			LKLogUtils.i("LKVolley.requestParams=>" + jsonStr);
		}

		final RequestQueue mQueue = Volley.newRequestQueue(context);

		final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, params, success, error);
		jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(LKVolleyProperties.getTIMEOUT(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

		mQueue.add(jsonObjectRequest);
	}


	/**
	 * POST请求接口
	 * @param context 上下文
	 * @param url 接口地址
	 * @param params 请求参数
	 * @param success 成功回调
	 * @param error 失败回调
	 */
	public static void post(final Context context, final String url, final Map<String, Object> params, final Response.Listener<JSONObject> success, final Response.ErrorListener error) {
		post(context, url, convertToJsonObject(params), success, error);
	}


	/**
	 * POST请求接口
	 * @param context 上下文
	 * @param url 接口地址
	 * @param success 成功回调
	 * @param error 失败回调
	 */
	public static void post(final Context context, final String url, final Response.Listener<JSONObject> success, final Response.ErrorListener error) {
		post(context, url, (JSONObject) null, success, error);
	}


	/**
	 * 转换成JSON对象
	 * @param params 请求参数
	 * @return JSON对象
	 */
	static JSONObject convertToJsonObject(final Map<String, Object> params) {
		if (params != null) {
			final JSONObject jsonObject = new JSONObject();
			try {
				for (final Entry<String, Object> entry : params.entrySet()) {
					jsonObject.put(entry.getKey(), entry.getValue());
				}
				return jsonObject;
			} catch (final JSONException e) {
				e.printStackTrace();
			}
		}
		return new JSONObject();
	}

}
