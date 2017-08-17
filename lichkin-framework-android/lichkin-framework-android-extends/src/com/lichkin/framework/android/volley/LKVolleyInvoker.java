package com.lichkin.framework.android.volley;

import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lichkin.framework.android.R;
import com.lichkin.framework.android.lang.LKStringUtils;
import com.lichkin.framework.android.utils.LKDialogUtils;
import com.lichkin.framework.android.utils.LKLogUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;
import com.lichkin.framework.android.widgets.LKLoadingDialog;

import android.content.Context;

/**
 * LichKin标准接口请求工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKVolleyInvoker {

	/**
	 * 获取绝对路径
	 * @param version 版本号
	 * @param relativeUrl 相对路径
	 * @param serverName 服务器名称
	 * @return 绝对路径
	 */
	private static String getAbsoluteUrl(final String version, final String relativeUrl, final String serverName) {
		final StringBuilder sb = new StringBuilder();
		if (LKStringUtils.isBlank(serverName)) {
			sb.append(LKVolleyProperties.getBASE_URL());
			sb.append("/V").append(version);
			sb.append("/").append(relativeUrl);
			sb.append(LKVolleyProperties.getSUFFIX());
		} else {
			final Properties properties = LKVolleyProperties.getProperties();
			sb.append(properties.getProperty("baseUrl[" + serverName + "]." + properties.getProperty("environment[" + serverName + "]")));
			sb.append("/V").append(version);
			sb.append("/").append(relativeUrl);
			sb.append(properties.getProperty("suffix[" + serverName + "]"));
		}
		return sb.toString();
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param version 版本号
	 * @param methodName 方法名
	 * @param params 请求参数
	 * @param responseHandler 回调处理对象
	 * @param serverName 服务器名称
	 */
	public static void invoke(final Context context, final String version, final String methodName, final Map<String, Object> params, final LKVolleyInvokeResponseHandler responseHandler, final String serverName) {
		// 准备调用接口所需的请求参数
		final JSONObject jsonObject = new JSONObject();
		try {
			if (LKStringUtils.isBlank(serverName)) {
				jsonObject.put("callerName", LKVolleyProperties.getCALLER_NAME());
				jsonObject.put("password", LKVolleyProperties.getPASSWORD());
			} else {
				final Properties properties = LKVolleyProperties.getProperties();
				jsonObject.put("callerName", properties.getProperty("callerName[" + serverName + "]"));
				jsonObject.put("password", properties.getProperty("password[" + serverName + "]"));
			}
			jsonObject.put("requestDatas", LKVolley.convertToJsonObject(params));
		} catch (final JSONException e) {
			// 这个异常理论上是永远不会存在的。
			e.printStackTrace();

			// 输出错误日志
			LKLogUtils.e("LKVolley.JSONException=>" + e);

			// 友好提示
			LKDialogUtils.alert(context, LKResourceUtils.getString(R.string.request_params_error));
			return;
		}

		// 显示加载遮罩页面
		final LKLoadingDialog loadingDialog = new LKLoadingDialog(context, LKResourceUtils.getString(R.string.loading));
		loadingDialog.show();

		// 发送请求
		LKVolley.post(context, getAbsoluteUrl(version, methodName, serverName), jsonObject, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(final JSONObject response) {
				// 输出日志
				if (LKVolleyProperties.isSHOW_LOG()) {
					LKLogUtils.i("LKVolley.onSuccess=>response=>" + response.toString());
				}

				// 请求成功回调方法。这个成功是只HTTP请求成功，即状态码200，OK的状态。
				// 正常情况下肯定是成功的，除非网络异常，服务器宕机等才会不成功。
				// 请求成功，只说明通信成功了，并不异味着业务成功了。

				// 关闭加载遮罩页面
				loadingDialog.dismiss();

				// 进行业务处理
				try {
					// 从相应参数中解析出code，此值必有，无需非空判断。
					final String code = response.getString("code");
					// 对错误编码进行判断
					if ("0".equals(code)) {
						// 业务成功编码，执行正常业务逻辑。
						responseHandler.doSuccess(context, response);
					} else {
						// 其它编码都意味着业务失败，给出友好的用户提示，不要使用info值，info值是给程序员看的，不是给用户看的。
						// 正常情况下，程序调通后不可能出现这种情况。如果出现了这种情况可能性有以下两类。
						// 一、不可避免的异常情况。如服务器内存溢出，硬盘空间不足，与数据库间的通信中断，数据库锁表等等。这些情况不能通过单纯的软件解决，需要人工维护。
						// 二、人为强制报错。如接口内部有业务逻辑不正确，需要临时停用接口或永久停用接口，服务器会主动修改编码报错。
						responseHandler.doError(context, response);
					}
				} catch (final JSONException e) {
					// 这个异常理论上是永远不会存在的。
					e.printStackTrace();

					// 输出错误日志
					LKLogUtils.e("LKVolley.JSONException=>" + e);

					// 友好提示
					LKDialogUtils.alert(context, LKResourceUtils.getString(R.string.request_again));
				}
			}

		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(final VolleyError error) {
				LKLogUtils.e("LKVolley.onFailure=>error=>" + error.getMessage(), error.getCause());

				// 关闭加载遮罩页面
				loadingDialog.dismiss();

				// 接口调用异常
				responseHandler.doConnectionError(context);
			}

		});
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param methodName 方法名
	 * @param params 请求参数
	 * @param responseHandler 回调处理对象
	 * @param serverName 服务器名称
	 */
	public static void invoke(final Context context, final String methodName, final Map<String, Object> params, final LKVolleyInvokeResponseHandler responseHandler, final String serverName) {
		invoke(context, LKStringUtils.isBlank(serverName) ? LKVolleyProperties.getVERSION() : LKVolleyProperties.getProperties().getProperty("version[" + serverName + "]"), methodName, params, responseHandler, serverName);
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param methodName 方法名
	 * @param responseHandler 回调处理对象
	 * @param serverName 服务器名称
	 */
	public static void invoke(final Context context, final String methodName, final LKVolleyInvokeResponseHandler responseHandler, final String serverName) {
		invoke(context, LKStringUtils.isBlank(serverName) ? LKVolleyProperties.getVERSION() : LKVolleyProperties.getProperties().getProperty("version[" + serverName + "]"), methodName, null, responseHandler, serverName);
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param version 版本号
	 * @param methodName 方法名
	 * @param params 请求参数
	 * @param responseHandler 回调处理对象
	 */
	public static void invoke(final Context context, final String version, final String methodName, final Map<String, Object> params, final LKVolleyInvokeResponseHandler responseHandler) {
		invoke(context, version, methodName, params, responseHandler, null);
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param methodName 方法名
	 * @param params 请求参数
	 * @param responseHandler 回调处理对象
	 */
	public static void invoke(final Context context, final String methodName, final Map<String, Object> params, final LKVolleyInvokeResponseHandler responseHandler) {
		invoke(context, LKVolleyProperties.getVERSION(), methodName, params, responseHandler, null);
	}


	/**
	 * 统一POST请求接口
	 * @param context 调用请求的对象上下文
	 * @param methodName 方法名
	 * @param responseHandler 回调处理对象
	 */
	public static void invoke(final Context context, final String methodName, final LKVolleyInvokeResponseHandler responseHandler) {
		invoke(context, LKVolleyProperties.getVERSION(), methodName, null, responseHandler, null);
	}

}
