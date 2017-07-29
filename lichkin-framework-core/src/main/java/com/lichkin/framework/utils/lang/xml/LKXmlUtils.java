package com.lichkin.framework.utils.lang.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * XML转换工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKXmlUtils {

	/**
	 * XML文本转换为JSON文本
	 * @param xml XML文本
	 * @return JSON文本
	 */
	@SuppressWarnings("unchecked")
	public static String toJson(final String xml) {
		final String json = "{}";
		try {
			final Document document = DocumentHelper.parseText(xml);
			final Element root = document.getRootElement();
			final List<Element> list = root.elements();
			final Map<Object, Object> map = new HashMap<>();
			for (final Element element : list) {
				final String name = element.getName();
				map.put(name, root.elementText(name));
			}
			return LKJSONUtils.toJson(map, false, false);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return json;
	}


	/**
	 * 拼接CDATA格式
	 * @param str 内容
	 * @return 消息
	 */
	public static String appendCData(final String str) {
		final StringBuffer sb = new StringBuffer();
		sb.append("<![CDATA[");
		sb.append(str);
		sb.append("]]>");
		return sb.toString();
	}

}
