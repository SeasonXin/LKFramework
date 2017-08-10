package com.lichkin.framework.http.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.lang.LKObjectUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * POST请求工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPoster extends LKRequester {

	/**
	 * 发送POST请求，返回响应信息字符串。
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param charset 字符集
	 * @param useSSL 使用SSL请求
	 * @return 响应信息字符串
	 */
	public static String post(final String url, final List<NameValuePair> params, String charset, final boolean useSSL) {
		if (charset == null) {
			charset = "UTF-8";
		}

		final CloseableHttpClient client = useSSL ? LKRequester.createSSLClient() : LKRequester.createClient();
		final HttpPost httpPost = LKRequester.buildHttpPost(url, params, charset);
		CloseableHttpResponse response = null;
		try {
			response = client.execute(httpPost);
		} catch (final IOException e) {
			e.printStackTrace();
			HttpClientUtils.closeQuietly(client);
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口失败");
		}

		final int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			try {
				return EntityUtils.toString(response.getEntity(), charset);
			} catch (ParseException | IOException e) {
				e.printStackTrace();
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口响应信息解析失败");
			} finally {
				HttpClientUtils.closeQuietly(response);
				HttpClientUtils.closeQuietly(client);
			}
		} else {
			HttpClientUtils.closeQuietly(response);
			HttpClientUtils.closeQuietly(client);
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口失败");
		}
	}


	/**
	 * 发送POST请求，返回响应信息字符串。
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param charset 字符集
	 * @param useSSL 使用SSL请求
	 * @return 响应信息字符串
	 */
	public static String postString(final String url, final String params, String charset, final boolean useSSL) {
		if (charset == null) {
			charset = "UTF-8";
		}

		final CloseableHttpClient client = useSSL ? LKRequester.createSSLClient() : LKRequester.createClient();
		final HttpPost httpPost = LKRequester.buildHttpPost(url, params, charset);
		CloseableHttpResponse response = null;
		try {
			response = client.execute(httpPost);
		} catch (final IOException e) {
			e.printStackTrace();
			HttpClientUtils.closeQuietly(client);
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口失败");
		}

		final int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			try {
				return EntityUtils.toString(response.getEntity(), charset);
			} catch (ParseException | IOException e) {
				e.printStackTrace();
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口响应信息解析失败");
			} finally {
				HttpClientUtils.closeQuietly(response);
				HttpClientUtils.closeQuietly(client);
			}
		} else {
			HttpClientUtils.closeQuietly(response);
			HttpClientUtils.closeQuietly(client);
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "请求接口失败");
		}
	}


	/**
	 * 发送POST请求，返回响应信息字符串。
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param charset 字符集
	 * @param useSSL 使用SSL请求
	 * @return 响应信息字符串
	 */
	public static String postMap(final String url, final Map<String, String> params, final String charset, final boolean useSSL) {
		return post(url, toListNameValuePair(params, false), charset, useSSL);
	}


	/**
	 * 转换为键值对参数列表
	 * @param mapParams map参数集合
	 * @param nullable 是否可空
	 * @return 键值对参数列表
	 */
	public static List<NameValuePair> toListNameValuePair(final Map<String, String> mapParams, final boolean nullable) {
		final List<NameValuePair> params = new ArrayList<>();
		if (MapUtils.isNotEmpty(mapParams)) {
			for (final Entry<String, String> entry : mapParams.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		} else {
			if (nullable) {
				return null;
			}
		}
		return params;
	}


	/**
	 * 发送POST请求，返回响应信息字符串。
	 * @param url 请求地址
	 * @param params 请求参数（JSON）
	 * @param charset 字符集
	 * @param useSSL 使用SSL请求
	 * @return 响应信息字符串
	 */
	public static String postJson(final String url, final String params, final String charset, final boolean useSSL) {
		return post(url, toListNameValuePair(params, false), charset, useSSL);
	}


	/**
	 * 将JSON字符串解析为数据集合
	 * @param jsonStr JSON字符串
	 * @param nullable 是否可空
	 * @return 数据集合
	 */
	public static List<NameValuePair> toListNameValuePair(final String jsonStr, final boolean nullable) {
		final List<NameValuePair> listParam = new ArrayList<>();
		if (LKStringUtils.isNotBlank(jsonStr)) {
			final JSONObject jsonObj = JSON.parseObject(jsonStr);
			for (final Entry<String, Object> entry : jsonObj.entrySet()) {
				listParam.add(new BasicNameValuePair(entry.getKey(), LKObjectUtils.toString(entry.getValue(), "")));
			}
		} else {
			if (nullable) {
				return null;
			}
		}
		return listParam;
	}

}
