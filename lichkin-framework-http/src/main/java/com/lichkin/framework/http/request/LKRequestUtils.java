package com.lichkin.framework.http.request;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.lichkin.framework.bases.statics.LKStringStatics;

/**
 * 请求工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKRequestUtils {

	/**
	 * 提交请求
	 * @param url 请求路径
	 * @return 响应信息
	 * @throws Exception 请求时可能发生的异常
	 */
	@Deprecated
	public static String doRequest(final String url) throws Exception {
		return LKRequestUtils.doRequest(url, LKStringStatics.STR_CHARSET_UTF_8);
	}


	/**
	 * 提交请求
	 * @param url 请求路径
	 * @param charset 字符集
	 * @return 响应信息
	 * @throws Exception 请求时可能发生的异常
	 */
	@Deprecated
	public static String doRequest(final String url, final String charset) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		InputStream is = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(1000 * 15);
			is = conn.getInputStream();
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			final StringBuffer str = new StringBuffer(255);
			String line = "";
			while ((line = br.readLine()) != null) {
				str.append(line);
			}
			return str.toString();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final Exception e) {
					is = null;
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (final Exception e) {
					isr = null;
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (final Exception e) {
					br = null;
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (final Exception e) {
					conn = null;
				}
			}
		}
	}


	/**
	 * 提交请求
	 * @param url URL
	 * @param jsonStr JSON字符串
	 * @return 响应信息
	 * @throws Exception 请求时可能发生的异常
	 */
	@Deprecated
	public static String doRequestStream(final String url, final String jsonStr) throws Exception {
		return LKRequestUtils.doRequestStream(url, jsonStr, LKStringStatics.STR_CHARSET_UTF_8);
	}


	/**
	 * 提交请求
	 * @param url URL
	 * @param jsonStr JSON字符串
	 * @param charset 字符集
	 * @return 响应信息
	 * @throws Exception 请求时可能发生的异常
	 */
	@Deprecated
	public static String doRequestStream(final String url, final String jsonStr, final String charset) throws Exception {
		HttpURLConnection conn = null;
		OutputStream os = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		InputStream is = null;
		try {
			final byte[] data = jsonStr.getBytes(charset);
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(1000 * 15);
			conn.setRequestProperty("Content-Length", String.valueOf(data.length));
			conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
			os = conn.getOutputStream();
			os.write(data);
			os.flush();
			is = conn.getInputStream();
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			final StringBuffer str = new StringBuffer(255);
			String line = "";
			while ((line = br.readLine()) != null) {
				str.append(line);
			}
			return str.toString();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final Exception e) {
					is = null;
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (final Exception e) {
					isr = null;
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (final Exception e) {
					br = null;
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (final Exception e) {
					os = null;
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (final Exception e) {
					conn = null;
				}
			}
		}
	}

}
