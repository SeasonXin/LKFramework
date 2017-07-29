package com.lichkin.framework.utils.lang;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

import com.lichkin.framework.bases.statics.LKStringStatics;

/**
 * Map工具类，继承自org.apache.commons.collections.MapUtils
 * @see org.apache.commons.collections.MapUtils
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@SuppressWarnings("rawtypes")
public final class LKMapUtils extends MapUtils {

	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toBoolean(Object, Boolean)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 布尔值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toBoolean(Object, Boolean)
	 */
	public static Boolean getBoolean(final Map map, final Object key, final Boolean defaultValue) {
		if (map != null) {
			return LKObjectUtils.toBoolean(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toByte(Object, Byte)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 字节值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toByte(Object, Byte)
	 */
	public static Byte getByte(final Map map, final Object key, final Byte defaultValue) {
		if (map != null) {
			return LKObjectUtils.toByte(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toShort(Object, Short)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 短整型值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toShort(Object, Short)
	 */
	public static Short getShort(final Map map, final Object key, final Short defaultValue) {
		if (map != null) {
			return LKObjectUtils.toShort(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toInteger(Object, Integer)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 整型值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toInteger(Object, Integer)
	 */
	public static Integer getInteger(final Map map, final Object key, final Integer defaultValue) {
		if (map != null) {
			return LKObjectUtils.toInteger(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toLong(Object, Long)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 长整型值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toLong(Object, Long)
	 */
	public static Long getLong(final Map map, final Object key, final Long defaultValue) {
		if (map != null) {
			return LKObjectUtils.toLong(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toFloat(Object, Float)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 单精度浮点值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toFloat(Object, Float)
	 */
	public static Float getFloat(final Map map, final Object key, final Float defaultValue) {
		if (map != null) {
			return LKObjectUtils.toFloat(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toDouble(Object, Double)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 双精度浮点值
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toDouble(Object, Double)
	 */
	public static Double getDouble(final Map map, final Object key, final Double defaultValue) {
		if (map != null) {
			return LKObjectUtils.toDouble(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 从Map中获取对应key的value。
	 *
	 * <pre>
	 * map为null或找不到对应值时返回defaultValue；
	 * 有对应值时，调用com.lichkin.framework.utils.lang.LKObjectUtils#toString(Object, String)方法。
	 * </pre>
	 *
	 * @param map 集合
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return 字符串
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toString(Object, String)
	 */
	public static String getString(final Map map, final Object key, final String defaultValue) {
		if (map != null) {
			return LKObjectUtils.toString(map.get(key), defaultValue);
		}
		return defaultValue;
	}


	/**
	 * 去除空值的键值对
	 * @param <T> 类型
	 * @param map 集合
	 * @return 去除空值的键值对后的集合
	 */
	public static <T> Map<String, T> clearBlankValue(final Map<String, T> map) {
		final Map<String, T> result = new HashMap<>();

		if ((map == null) || (map.size() <= 0)) {
			return result;
		}

		for (Entry<String, T> entry : map.entrySet()) {
			final String key = entry.getKey();
			final T value = entry.getValue();
			if ((value == null) || value.equals(LKStringStatics.STR_EMPTY)) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}


	/**
	 * 编码
	 * @param <T> 类型
	 * @param map 集合
	 * @param charset 字符集
	 * @return 编码后的集合
	 * @throws UnsupportedEncodingException 不支持的字符集
	 */
	public static <T> Map<String, String> encode(final Map<String, T> map, final String charset) throws UnsupportedEncodingException {
		final Map<String, String> result = new HashMap<>();

		if ((map == null) || (map.size() <= 0)) {
			return result;
		}

		for (Entry<String, T> entry : map.entrySet()) {
			final String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				value = LKStringStatics.STR_EMPTY;
			}
			result.put(key, URLEncoder.encode(value.toString(), charset));
		}

		return result;
	}


	/**
	 * 创建URL参数字符串
	 * @param <T> 类型
	 * @param map 集合
	 * @param charset 字符集
	 * @param encode 是否需要编码
	 * @param sort 是否需要排序
	 * @return URL参数字符串
	 * @throws UnsupportedEncodingException 不支持的字符集
	 */
	public static <T> String createUrlParamsString(final Map<String, T> map, final String charset, final boolean encode, final boolean sort) throws UnsupportedEncodingException {
		final StringBuilder sb = new StringBuilder();

		if ((map == null) || map.isEmpty()) {
			return sb.toString();
		}

		if (sort) {
			final List<String> keys = new ArrayList<>(map.keySet());
			Collections.sort(keys);

			for (final String key : keys) {
				Object value = map.get(key);
				if (value == null) {
					value = LKStringStatics.STR_EMPTY;
				}
				if (encode) {
					value = URLEncoder.encode(value.toString(), charset);
				}
				sb.append(LKStringStatics.STR_AND).append(key).append(LKStringStatics.STR_EQUAL).append(value);
			}
		} else {
			for (Entry<String, T> entry : map.entrySet()) {
				final String key = entry.getKey();
				Object value = entry.getValue();
				if (value == null) {
					value = LKStringStatics.STR_EMPTY;
				}
				if (encode) {
					value = URLEncoder.encode(value.toString(), charset);
				}
				sb.append(LKStringStatics.STR_AND).append(key).append(LKStringStatics.STR_EQUAL).append(value);
			}
		}
		return sb.substring(1);
	}


	/**
	 * 转换泛型
	 * @param <T> 类型
	 * @param map 原集合
	 * @return 新集合
	 */
	public static <T> Map<String, String> changeGenericityToStringString(final Map<String, T> map) {
		final Map<String, String> result = new HashMap<>();

		if ((map == null) || (map.size() <= 0)) {
			return result;
		}

		for (Entry<String, T> entry : map.entrySet()) {
			final String key = entry.getKey();
			final T value = entry.getValue();
			if (value == null) {
				result.put(key, null);
			} else {
				result.put(key, value.toString());
			}
		}

		return result;
	}


	/**
	 * 转换泛型
	 * @param <T> 类型
	 * @param map 原集合
	 * @return 新集合
	 */
	public static <T> Map<String, Object> changeGenericityToStringObject(final Map<String, T> map) {
		final Map<String, Object> result = new HashMap<>();

		if ((map == null) || (map.size() <= 0)) {
			return result;
		}

		for (Entry<String, T> entry : map.entrySet()) {
			final String key = entry.getKey();
			final T value = entry.getValue();
			if (value == null) {
				result.put(key, null);
			} else {
				result.put(key, value);
			}
		}

		return result;
	}

}
