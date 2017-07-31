package com.lichkin.framework.springboot.applications;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 应用上下文
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component
public class LKApplicationContext implements ApplicationContextAware {

	protected static final Log LOGGER = LogFactory.getLog(LKApplicationContext.class);

	/** 应用上下文 */
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	/**
	 * 获取应用上下文
	 * @return 应用上下文
	 */
	public static ApplicationContext getContext() {
		if (context == null) {
			LOGGER.error("ApplicationContext is not ready.");
		}
		return context;
	}

	/**
	 * 获取对象
	 * @param name 类名称
	 * @see org.springframework.context.ApplicationContext#getBean(String)
	 * @return 对象
	 */
	public final static Object getBean(String name) {
		ApplicationContext context = getContext();
		if (context != null) {
			return getContext().getBean(name);
		}
		LOGGER.error("ApplicationContext is not ready.");
		return null;
	}

	/**
	 * 获取对象
	 * @param <T> 类型
	 * @param requiredType 类型
	 * @see org.springframework.context.ApplicationContext#getBean(String)
	 * @return 对象
	 */
	public final static <T> T getBean(Class<T> requiredType) {
		ApplicationContext context = getContext();
		if (context != null) {
			return getContext().getBean(requiredType);
		}
		LOGGER.error("ApplicationContext is not ready.");
		return null;
	}

}
