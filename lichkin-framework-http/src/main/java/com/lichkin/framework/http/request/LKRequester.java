package com.lichkin.framework.http.request;

import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 请求工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class LKRequester {

	/**
	 * 创建请求客户端
	 * @return 请求客户端
	 */
	protected static CloseableHttpClient createClient() {
		return HttpClients.createDefault();
	}


	/**
	 * 创建SSL请求客户端
	 * @return SSL请求客户端
	 */
	protected static CloseableHttpClient createSSLClient() {
		final TrustStrategy trustStrategy = new TrustStrategy() {

			@Override
			public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
				return true;
			}

		};

		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, trustStrategy).build();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		if (sslContext == null) {
			return HttpClients.createDefault();
		}

		final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}


	/**
	 * 构建POST请求数据对象
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param charset 字符集
	 * @return 请求数据对象
	 */
	protected static HttpPost buildHttpPost(final String url, final List<NameValuePair> params, final String charset) {
		final HttpPost httpPost = new HttpPost(url);

		if (CollectionUtils.isEmpty(params)) {
			return httpPost;
		}

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, charset));
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR);
		}

		return httpPost;
	}


	/**
	 * 构建POST请求数据对象
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param charset 字符集
	 * @return 请求数据对象
	 */
	protected static HttpPost buildHttpPost(final String url, final String params, final String charset) {
		final HttpPost httpPost = new HttpPost(url);

		if (LKStringUtils.isBlank(params)) {
			return httpPost;
		}

		try {
			httpPost.setEntity(new StringEntity(params));
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR);
		}

		return httpPost;
	}

}
