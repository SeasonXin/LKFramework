package com.lichkin.framework.utils.lang.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.utils.lang.LKObjectUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * JSON工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKJSONUtils {

	private static JsonConfig conf = new JsonConfig();

	static {
		final LKJSONProcessor processor = new LKJSONProcessor();
		LKJSONUtils.conf.registerJsonValueProcessor(LKDatas.class, processor);
		LKJSONUtils.conf.registerJsonValueProcessor(Date.class, processor);
	}


	/**
	 * 将对象解析为JSON字符串
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toJson(Object, boolean, boolean)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toJson(Object, boolean, boolean)
	 * @param obj 对象
	 * @param nullable 是否可以为null
	 * @param isArray 是否是数组或列表
	 * @return JSON字符串
	 */
	@Deprecated
	public static String toJson(final Object obj, final boolean nullable, final boolean isArray) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(obj, null))) {
			if (nullable) {
				return null;
			}
			if (isArray) {
				return "[]";
			}
			return "{}";
		}

		if (isArray) {
			if ((obj instanceof List<?>) || (obj instanceof Object[])) {
				return JSONArray.fromObject(obj, LKJSONUtils.conf).toString();
			}
			return "[" + JSONObject.fromObject(obj, LKJSONUtils.conf).toString() + "]";
		}

		return JSONObject.fromObject(obj, LKJSONUtils.conf).toString();
	}


	/**
	 * 将对象转换成对象
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toBean(Object, Class)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toBean(Object, Class)
	 * @param <T> 类型
	 * @param obj 对象
	 * @param clazz 对象类型
	 * @return 对象
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static <T> T toBean(final Object obj, final Class<T> clazz) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(obj, null))) {
			return null;
		}
		return (T) JSONObject.toBean(JSONObject.fromObject(obj), clazz);
	}


	/**
	 * 将对象转换成对象列表
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toListBean(Object, Class)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toListBean(Object, Class)
	 * @param <T> 类型
	 * @param obj 对象
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static <T> List<T> toListBean(final Object obj, final Class<T> clazz) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(obj, null))) {
			return null;
		}
		return (List<T>) JSONArray.toCollection(JSONArray.fromObject(obj), clazz);
	}


	/**
	 * 将JSON字符串解析为对象
	 * @param <T> 类型
	 * @param jsonStr JSON字符串
	 * @param clazz 对象类型
	 * @param isSerializeArray 是否为序列化的表单提交
	 * @return 对象
	 */
	@Deprecated
	public static <T> T toBean(final String jsonStr, final Class<T> clazz, final boolean isSerializeArray) {
		if (LKStringUtils.isBlank(jsonStr)) {
			return null;
		}
		if (isSerializeArray) {
			final LKJSONSerializeModel[] models = (LKJSONSerializeModel[]) JSONArray.toArray(JSONArray.fromObject(jsonStr), LKJSONSerializeModel.class);
			final Map<String, String> map = new HashMap<>();
			if (!ArrayUtils.isEmpty(models)) {
				for (final LKJSONSerializeModel model : models) {
					map.put(model.getKey(), model.getValue());
				}
			}
			return LKJSONUtils.toBean(map, clazz);
		}
		return LKJSONUtils.toBean(jsonStr, clazz);
	}


	/**
	 * 将JSON字符串解析为数据集合
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toDatas(String, boolean)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toDatas(String, boolean)
	 * @param jsonStr JSON字符串
	 * @return 数据集合
	 */
	@Deprecated
	public static LKDatas toDatas(final String jsonStr) {
		if (LKStringUtils.isBlank(jsonStr)) {
			return null;
		}
		final JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		final LKDatas datas = new LKDatas();
		for (final Iterator<?> iterator = jsonObj.keys(); iterator.hasNext();) {
			final Object key = iterator.next();
			datas.put(String.valueOf(key), jsonObj.get(key));
		}
		return datas;
	}


	/**
	 * 将对象转换成对象
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toBean(String, String, Class)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toBean(String, String, Class)
	 * @param <T> 类型
	 * @param jsonStr JSON字符串
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> T toBean(final String jsonStr, final String key, final Class<T> clazz) {
		return LKJSONUtils.toBean(JSONObject.fromObject(LKJSONUtils.getJsonObj(jsonStr, key)), clazz);
	}


	/**
	 * 将对象转换成对象列表
	 * @deprecated 使用方法替代com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toListBean(String, String, Class)
	 * @see com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils#toListBean(String, String, Class)
	 * @param <T> 类型
	 * @param jsonStr JSON字符串
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	@Deprecated
	public static <T> List<T> toListBean(final String jsonStr, final String key, final Class<T> clazz) {
		return LKJSONUtils.toListBean(JSONArray.fromObject(LKJSONUtils.getJsonObj(jsonStr, key)), clazz);
	}


	/**
	 * 获取对象
	 * @param jsonStr JSON字符串
	 * @param key 键
	 * @return 对象
	 */
	@Deprecated
	private static Object getJsonObj(final String jsonStr, final String key) {
		return JSONObject.fromObject(jsonStr).get(key);
	}

}
