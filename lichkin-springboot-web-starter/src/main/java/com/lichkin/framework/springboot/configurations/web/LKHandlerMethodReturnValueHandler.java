package com.lichkin.framework.springboot.configurations.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 返回值处理器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public boolean supportsReturnType(final MethodParameter returnType) {
		return true;
	}


	@Override
	public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest) throws Exception {
		// TODO
		logger.debug(returnValue);
		logger.debug(returnType);
		logger.debug(mavContainer);
		logger.debug(webRequest);
	}

}
