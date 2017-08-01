package com.lichkin.framework.springboot.configurations.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * LKDatas处理，主要是将请求中的参数放入LKDatas中，方便后续取值，以及将请求相关参数放入request中。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDatasHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public boolean supportsParameter(final MethodParameter parameter) {
		return LKDatas.class.equals(parameter.getParameterType());
	}


	@Override
	public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
		final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

		// 请求相关参数初始化
		final String handlerClass = parameter.getContainingClass().getName();
		final String handlerMethod = parameter.getMethod().getName();

		// 记录日志
		final Map<String, Object> map = new HashMap<>();
		map.put(LKWebStatics.REQUEST_ID, request.getAttribute(LKWebStatics.LK_REQUEST_ID));
		map.put(LKWebStatics.REQUEST_DATAS, ((LKDatas) request.getAttribute(LKWebStatics.LK_REQUEST_DATAS_REDUCE)).getMap());
		map.put(LKWebStatics.REQUEST_HANDLER_CLASS, handlerClass);
		map.put(LKWebStatics.REQUEST_HANDLER_METHOD, handlerMethod);
		logger.info(LKJSONUtils.toJson(map, true, false));

		final LKDatas datas = (LKDatas) request.getAttribute(LKWebStatics.LK_REQUEST_DATAS);
		datas.put(LKWebStatics.REQUEST_ID, request.getAttribute(LKWebStatics.LK_REQUEST_ID));
		datas.put(LKWebStatics.REQUEST_TIME, ((DateTime) request.getAttribute(LKWebStatics.LK_REQUEST_TIME)).toString(LKDatePatternEnum.TIMESTAP.getNameEn()));
		datas.put(LKWebStatics.REQUEST_IP, request.getAttribute(LKWebStatics.LK_REQUEST_IP));
		datas.put(LKWebStatics.REQUEST_URL, request.getAttribute(LKWebStatics.LK_REQUEST_URL));
		return datas;
	}

}
