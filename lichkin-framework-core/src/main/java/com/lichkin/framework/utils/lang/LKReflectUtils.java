package com.lichkin.framework.utils.lang;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKReflectUtils {

	/**
	 * 获取读写属性数组
	 * @param clazz 类型
	 * @return 读写属性数组
	 */
	public static PropertyDescriptor[] getBeanProperties(final Class<?> clazz) {
		return LKReflectUtils.getPropertiesHelper(clazz, true, true);
	}


	/**
	 * 获取读属性数组
	 * @param clazz 类型
	 * @return 读属性数组
	 */
	public static PropertyDescriptor[] getBeanGetters(final Class<?> clazz) {
		return LKReflectUtils.getPropertiesHelper(clazz, true, false);
	}


	/**
	 * 获取写属性数组
	 * @param clazz 类型
	 * @return 写属性数组
	 */
	public static PropertyDescriptor[] getBeanSetters(final Class<?> clazz) {
		return LKReflectUtils.getPropertiesHelper(clazz, false, true);
	}


	/**
	 * 获取属性数组
	 * @param clazz 类型
	 * @param read 是否包含读属性
	 * @param write 是否包含写属性
	 * @return 属性数组
	 */
	private static PropertyDescriptor[] getPropertiesHelper(final Class<?> clazz, final boolean read, final boolean write) {
		try {
			final BeanInfo info = Introspector.getBeanInfo(clazz, Object.class);
			final PropertyDescriptor[] all = info.getPropertyDescriptors();
			if ((read) && (write)) {
				return all;
			}
			final List<PropertyDescriptor> properties = new ArrayList<>(all.length);
			for (final PropertyDescriptor pd : all) {
				if (((read) && (pd.getReadMethod() != null)) || ((write) && (pd.getWriteMethod() != null))) {
					properties.add(pd);
				}
			}
			return properties.toArray(new PropertyDescriptor[properties.size()]);
		} catch (final IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}

}