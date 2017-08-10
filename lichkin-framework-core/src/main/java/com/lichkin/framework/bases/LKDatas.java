package com.lichkin.framework.bases;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.alibaba.fastjson.JSONObject;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.utils.lang.LKObjectUtils;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 数据集合类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@NoArgsConstructor
public final class LKDatas {

	/** serialVersionUID */
	static final long serialVersionUID = -8905781986536180572L;

	/** 内置集合 */
	private Map<String, Object> map = new HashMap<>();


	/**
	 * 构造方法
	 * @param map 内置集合
	 */
	public LKDatas(final Map<String, Object> map) {
		super();
		if ((map != null) && !map.isEmpty()) {
			this.map = map;
		}
	}


	/**
	 * 获取内置集合（只读），除去框架内部定义参数。
	 * @return 内置集合
	 */
	public Map<String, Object> getMapWithOutFrameworkParams() {
		final Map<String, Object> newMap = new HashMap<>();
		for (final Entry<String, Object> entry : map.entrySet()) {
			final String key = entry.getKey();
			final Object value = entry.getValue();
			if (LKWebStatics.REQUEST_ID.equals(key) || LKWebStatics.REQUEST_IP.equals(key) || LKWebStatics.REQUEST_TIME.equals(key) || LKWebStatics.REQUEST_URL.equals(key)) {
				continue;
			}
			newMap.put(key, value);
		}
		return newMap;
	}


	/**
	 * 除去框架内部定义参数
	 * @return 内置集合
	 */
	public LKDatas clearFrameworkParams() {
		map.remove(LKWebStatics.REQUEST_ID);
		map.remove(LKWebStatics.REQUEST_IP);
		map.remove(LKWebStatics.REQUEST_TIME);
		map.remove(LKWebStatics.REQUEST_URL);
		return this;
	}


	/**
	 * 设置值
	 * @param key 键
	 * @param value 值
	 * @return 内置集合
	 */
	public LKDatas put(final String key, final Object value) {
		map.put(key, value);
		return this;
	}


	/**
	 * 获取值
	 * @param key 键
	 * @return 值
	 */
	public Object get(final String key) {
		if ("requestDatas".equals(key)) {
			final Object requestDatas = map.get(key);
			if (requestDatas != null) {
				return requestDatas;
			}
			final JSONObject jsonObject = new JSONObject();
			for (final Entry<String, Object> entry : map.entrySet()) {
				final String keyStr = entry.getKey();
				if (keyStr.startsWith("requestDatas[") && keyStr.endsWith("]")) {
					jsonObject.put(keyStr.substring(keyStr.indexOf("[") + 1, keyStr.indexOf("]")), entry.getValue());
				}
			}
			return jsonObject;
		}

		return map.get(key);
	}


	/**
	 * 获取String类型对象
	 * @param key 键
	 * @return String类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toString(Object, String)
	 */
	public String getString(final String key) {
		return getString(key, "");
	}


	/**
	 * 获取String类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return String类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toString(Object, String)
	 */
	public String getString(final String key, final String defaultValue) {
		return LKObjectUtils.toString(get(key), defaultValue);
	}


	/**
	 * 获取Long类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Long类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toLong(Object, Long)
	 */
	public Long getLong(final String key, final Long defaultValue) {
		return LKObjectUtils.toLong(get(key), defaultValue);
	}


	/**
	 * 获取Integer类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Integer类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toInteger(Object, Integer)
	 */
	public Integer getInteger(final String key, final Integer defaultValue) {
		return LKObjectUtils.toInteger(get(key), defaultValue);
	}


	/**
	 * 获取Short类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Short类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toShort(Object, Short)
	 */
	public Short getShort(final String key, final Short defaultValue) {
		return LKObjectUtils.toShort(get(key), defaultValue);
	}


	/**
	 * 获取Byte类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Byte类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toByte(Object, Byte)
	 */
	public Byte getByte(final String key, final Byte defaultValue) {
		return LKObjectUtils.toByte(get(key), defaultValue);
	}


	/**
	 * 获取Float类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Float类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toFloat(Object, Float)
	 */
	public Float getFloat(final String key, final Float defaultValue) {
		return LKObjectUtils.toFloat(get(key), defaultValue);
	}


	/**
	 * 获取Double类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Double类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toDouble(Object, Double)
	 */
	public Double getDouble(final String key, final Double defaultValue) {
		return LKObjectUtils.toDouble(get(key), defaultValue);
	}


	/**
	 * 获取Boolean类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return Boolean类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toBoolean(Object, Boolean)
	 */
	public Boolean getBoolean(final String key, final Boolean defaultValue) {
		return LKObjectUtils.toBoolean(get(key), defaultValue);
	}


	/**
	 * 获取BigDecimal类型对象
	 * @param key 键
	 * @param defaultValue 默认值
	 * @return BigDecimal类型对象
	 * @see com.lichkin.framework.utils.lang.LKObjectUtils#toBigDecimal(Object, BigDecimal)
	 */
	public BigDecimal getBigDecimal(final String key, final BigDecimal defaultValue) {
		return LKObjectUtils.toBigDecimal(get(key), defaultValue);
	}


	/**
	 * 获取集合大小
	 * @return 集合大小
	 */
	public int size() {
		return map.size();
	}


	/**
	 * 判断集合是否无元素
	 * @return 无元素返回true，否则返回false。
	 */
	public boolean isEmpty() {
		return map.isEmpty();
	}


	/**
	 * 是否包含键
	 * @param key 键
	 * @return 包含键返回true，否则返回false。
	 */
	public boolean containsKey(final String key) {
		return map.containsKey(key);
	}


	/**
	 * 是否包含值
	 * @param value 值
	 * @return 包含值返回true，否则返回false。
	 */
	public boolean containsValue(final String value) {
		return map.containsValue(value);
	}


	/**
	 * 移除指定键值对
	 * @param key 键
	 * @return 移除的值
	 */
	public Object remove(final String key) {
		return map.remove(key);
	}


	/**
	 * 清空键值对
	 */
	public void clear() {
		map.clear();
	}


	/**
	 * 获取键集合
	 * @return 键集合
	 */
	public Set<String> keySet() {
		return map.keySet();
	}


	/**
	 * 获取值集合
	 * @return 值集合
	 */
	public Collection<Object> values() {
		return map.values();
	}


	/**
	 * 获取集合对象
	 * @return 集合对象
	 */
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return map.entrySet();
	}


	@Override
	public String toString() {
		return LKJSONUtils.toJson(map, false, false);
	}


	/**
	 * 获取对象
	 * @deprecated 使用方法替代com.lichkin.framework.bases.LKDatas#toBean(Class)
	 * @see com.lichkin.framework.bases.LKDatas#toBean(Class)
	 * @param clazz 对象类型
	 * @return 对象
	 */
	@Deprecated
	public <T> T getBean(final Class<T> clazz) {
		return getBean(null, clazz);
	}


	/**
	 * 获取对象
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public <T> T toBean(final Class<T> clazz) {
		return toBean(null, clazz);
	}


	/**
	 * 获取对象
	 * @deprecated 使用方法替代com.lichkin.framework.bases.LKDatas#toBean(String, Class)
	 * @see com.lichkin.framework.bases.LKDatas#toBean(String, Class)
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象
	 */
	@Deprecated
	public <T> T getBean(final String key, final Class<T> clazz) {
		return LKJSONUtils.toBean(getObject(key), clazz);
	}


	/**
	 * 获取对象
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象
	 */
	public <T> T toBean(final String key, final Class<T> clazz) {
		return com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils.toBean(getObject(key), clazz);
	}


	/**
	 * 获取对象列表
	 * @deprecated 使用方法替代com.lichkin.framework.bases.LKDatas#toListBean(Class)
	 * @see com.lichkin.framework.bases.LKDatas#toListBean(Class)
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	@Deprecated
	public <T> List<T> getListBean(final Class<T> clazz) {
		return getListBean(null, clazz);
	}


	/**
	 * 获取对象列表
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	public <T> List<T> toListBean(final Class<T> clazz) {
		return toListBean(null, clazz);
	}


	/**
	 * 获取对象列表
	 * @deprecated 使用方法替代com.lichkin.framework.bases.LKDatas#toListBean(String, Class)
	 * @see com.lichkin.framework.bases.LKDatas#toListBean(String, Class)
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	@Deprecated
	public <T> List<T> getListBean(final String key, final Class<T> clazz) {
		return LKJSONUtils.toListBean(getObject(key), clazz);
	}


	/**
	 * 获取对象列表
	 * @param key 键
	 * @param clazz 对象类型
	 * @return 对象列表
	 */
	public <T> List<T> toListBean(final String key, final Class<T> clazz) {
		return com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils.toListBean(getObject(key), clazz);
	}


	/**
	 * 获取对象
	 * @param key 键
	 * @return 内置集合本身或内置集合中键对应的值
	 */
	private Object getObject(final String key) {
		Object obj = null;
		if (key == null) {
			if (map.containsKey(null)) {
				obj = map.get(null);
			} else {
				obj = map;
			}
		} else {
			obj = map.get(key);
		}
		return obj;
	}


	/**
	 * 获取数据集合
	 * @param key 键
	 * @return 数据集合
	 */
	public LKDatas getDatas(final String key) {
		final Object value = get(key);

		if (value == null) {
			return null;
		}

		final LKDatas datas = new LKDatas();
		if (value instanceof JSONObject) {
			final JSONObject jsonObject = (JSONObject) value;
			for (final Entry<String, Object> entry : jsonObject.entrySet()) {
				datas.put(entry.getKey(), entry.getValue());
			}
		} else {
			datas.put(null, value);
		}
		return datas;
	}


	/**
	 * 获取请求ID
	 * @return 请求ID
	 */
	public String getRequestId() {
		return this.getString(LKWebStatics.REQUEST_ID);
	}


	/**
	 * 获取请求IP
	 * @return 请求IP
	 */
	public String getRequestIp() {
		return this.getString(LKWebStatics.REQUEST_IP);
	}


	/**
	 * 获取请求时间
	 * @return 请求时间
	 */
	public String getRequestTime() {
		return this.getString(LKWebStatics.REQUEST_TIME);
	}


	/**
	 * 获取请求时间
	 * @param datePatternEnum 日期模式枚举
	 * @return 请求时间
	 */
	public String getRequestTime(final LKDatePatternEnum datePatternEnum) {
		return DateTime.parse(this.getString(LKWebStatics.REQUEST_TIME), DateTimeFormat.forPattern(LKDatePatternEnum.TIMESTAP.getNameEn())).toString(datePatternEnum.getNameEn());
	}


	/**
	 * 获取请求URL
	 * @return 请求URL
	 */
	public String getRequestUrl() {
		return this.getString(LKWebStatics.REQUEST_URL);
	}

}
