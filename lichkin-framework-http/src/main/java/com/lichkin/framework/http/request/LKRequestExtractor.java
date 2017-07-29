package com.lichkin.framework.http.request;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;
import com.lichkin.framework.utils.lang.xml.LKXmlUtils;

/**
 * 请求参数提取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRequestExtractor {

	/**
	 * 获取请求中的参数集合
	 * @param request HttpServletRequest
	 * @return 参数集合
	 */
	public static LKDatas getRequestParamsFromParameter(final HttpServletRequest request) {
		final LKDatas datas = new LKDatas();
		for (final Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
			final String key = e.nextElement();
			final String[] values = request.getParameterValues(key);
			if (values.length == 1) {
				datas.put(key, values[0]);
			} else {
				datas.put(key, values);
			}
		}
		return datas;
	}


	/**
	 * 获取请求中的参数集合
	 * @param request HttpServletRequest
	 * @return 参数集合
	 * @throws IOException 读取输入流时可能抛出异常
	 */
	public static LKDatas getRequestParamsFromStream(final HttpServletRequest request) throws IOException {
		ServletInputStream is = null;
		try {
			final int length = request.getContentLength();
			if (length <= 0) {
				return new LKDatas();
			}
			final BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
			final byte[] b = new byte[1024];
			final StringBuilder sb = new StringBuilder();
			for (int i = bis.read(b); i != -1; i = bis.read(b)) {
				sb.append(new String(b, 0, i, "UTF-8"));
			}
			String str = sb.toString();

			if (str.startsWith("<xml")) {
				str = LKXmlUtils.toJson(str);
			}

			if (!str.startsWith("{")) {
				final LKDatas datas = new LKDatas();
				final String[] params = str.split("&");
				if (!ArrayUtils.isEmpty(params)) {
					for (final String param : params) {
						final String[] data = param.split("=");
						if (!ArrayUtils.isEmpty(data)) {
							if (data.length == 2) {
								datas.put(data[0], URLDecoder.decode(data[1], "utf-8"));
							} else if (data.length == 1) {
								datas.put(data[0], "");
							}
						}
					}
				}
				return datas;
			}
			return LKJSONUtils.toDatas(str, true);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final IOException e) {
					e.printStackTrace();
					is = null;
				}
			}
		}
	}


	/**
	 * 获取请求中的参数集合
	 * @param request HttpServletRequest
	 * @return 参数集合
	 * @throws IOException 读取输入流时可能抛出异常
	 */
	public static LKDatas getRequestParamsFromAll(final HttpServletRequest request) throws IOException {
		final LKDatas datas = new LKDatas();

		final LKDatas datasParameter = LKRequestExtractor.getRequestParamsFromParameter(request);
		final Set<Entry<String, Object>> datasParameterEntrySet = datasParameter.getMap().entrySet();
		for (final Entry<String, Object> entry : datasParameterEntrySet) {
			datas.put(entry.getKey(), entry.getValue());
		}

		final LKDatas datasStream = LKRequestExtractor.getRequestParamsFromStream(request);
		final Set<Entry<String, Object>> datasStreamEntrySet = datasStream.getMap().entrySet();
		for (final Entry<String, Object> entry : datasStreamEntrySet) {
			datas.put(entry.getKey(), entry.getValue());
		}

		return datas;
	}

}
