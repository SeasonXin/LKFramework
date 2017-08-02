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
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		LKApplicationContext.context = applicationContext;
	}


	/**
	 * 获取应用上下文
	 * @return 应用上下文
	 */
	public static ApplicationContext getContext() {
		if (LKApplicationContext.context == null) {
			LKApplicationContext.LOGGER.error("ApplicationContext is not ready.");
		}
		return LKApplicationContext.context;
	}


	/**
	 * 获取对象
	 * @param name 类名称
	 * @see org.springframework.context.ApplicationContext#getBean(String)
	 * @return 对象
	 */
	public final static Object getBean(final String name) {
		final ApplicationContext context = LKApplicationContext.getContext();
		if (context != null) {
			return LKApplicationContext.getContext().getBean(name);
		}
		LKApplicationContext.LOGGER.error("ApplicationContext is not ready.");
		return null;
	}


	/**
	 * 获取对象
	 * @param <T> 类型
	 * @param requiredType 类型
	 * @see org.springframework.context.ApplicationContext#getBean(String)
	 * @return 对象
	 */
	public final static <T> T getBean(final Class<T> requiredType) {
		final ApplicationContext context = LKApplicationContext.getContext();
		if (context != null) {
			return LKApplicationContext.getContext().getBean(requiredType);
		}
		LKApplicationContext.LOGGER.error("ApplicationContext is not ready.");
		return null;
	}

}
