package com.lichkin.framework.utils.lang.json.alibaba;

import java.util.List;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.utils.lang.LKObjectUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * JSON工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKJSONUtils {

	/**
	 * 将对象解析为JSON字符串
	 * @param obj 对象
	 * @param nullable 是否可以为null
	 * @param isArray 是否是数组或列表
	 * @return JSON字符串
	 */
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
				return JSON.parseArray(JSON.toJSONString(obj)).toJSONString();
			}
			return "[" + JSON.parseObject(JSON.toJSONString(obj)).toJSONString() + "]";
		}

		return JSON.parseObject(JSON.toJSONString(obj)).toJSONString();
	}


	/**
	 * 将对象转换成对象
	 * @param <T> 类型
	 * @param obj 对象
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public static <T> T toBean(final Object obj, final Class<T> clazz) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(obj, null))) {
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(obj), clazz);
	}


	/**
	 * 将对象转换成对象列表
	 * @param <T> 类型
	 * @param obj 对象
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	public static <T> List<T> toListBean(final Object obj, final Class<T> clazz) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(obj, null))) {
			return null;
		}
		return JSON.parseArray(JSON.toJSONString(obj), clazz);
	}


	/**
	 * 将对象转换成对象
	 * @param <T> 类型
	 * @param jsonStr JSON字符串
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public static <T> T toBean(final String jsonStr, final String key, final Class<T> clazz) {
		if (LKStringUtils.isBlank(jsonStr)) {
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(jsonStr)).getObject(key, clazz);
	}


	/**
	 * 将对象转换成对象列表
	 * @param <T> 类型
	 * @param jsonStr JSON字符串
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	public static <T> List<T> toListBean(final String jsonStr, final String key, final Class<T> clazz) {
		if (LKStringUtils.isBlank(jsonStr)) {
			return null;
		}
		return JSON.parseArray(JSON.parseObject(JSON.toJSONString(jsonStr)).getJSONArray(key).toJSONString(), clazz);
	}


	/**
	 * 将JSON字符串解析为数据集合
	 * @param jsonStr JSON字符串
	 * @param nullable 是否可空
	 * @return 数据集合
	 */
	public static LKDatas toDatas(final String jsonStr, final boolean nullable) {
		final LKDatas datas = new LKDatas();
		if (LKStringUtils.isNotBlank(jsonStr)) {
			final JSONObject jsonObj = JSON.parseObject(jsonStr);
			for (final Entry<String, Object> entry : jsonObj.entrySet()) {
				datas.put(entry.getKey(), entry.getValue());
			}
		} else {
			if (nullable) {
				return null;
			}
		}
		return datas;
	}

}
