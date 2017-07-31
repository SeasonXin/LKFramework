package com.lichkin.framework.springboot.web.controllers;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.http.utils.LKUrlUtils;

/**
 * 通用控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKController {

	/** 成功 */
	protected static final String SUCCESS = "success";

	/** 失败 */
	protected static final String ERROR = "error";

	/** 请求对象 */
	@Autowired
	protected HttpServletRequest request;

	/** 响应对象 */
	@Autowired
	protected HttpServletResponse response;

	/** 会话对象 */
	@Autowired
	protected HttpSession session;


	/**
	 * 获取视图模型对象
	 * @return 视图模型对象
	 */
	protected ModelAndView getModelAndView() {
		return getModelAndView(new LKDatas());
	}


	/**
	 * 获取视图模型对象
	 * @param requestDatas 请求数据，通过Spring自动注入参数即可。
	 * @return 视图模型对象
	 */
	protected ModelAndView getModelAndView(final LKDatas requestDatas) {
		// 计算请求相关路径
		final String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		if (requestURI.contains(LKStringStatics.STR_SEMICOLON)) {
			requestURI = requestURI.substring(0, requestURI.indexOf(LKStringStatics.STR_SEMICOLON));
		}
		final String requestURIWithoutCtx = LKUrlUtils.getRequestURIWithoutCtx(contextPath, requestURI);
		final String requestURIRoot = getRootRequestMappingValue();

		// 在请求数据中加入请求相关路径的参数
		requestDatas.put(LKWebStatics.LK_REQUEST_CTX, contextPath);
		requestDatas.put(LKWebStatics.LK_REQUEST_URI, requestURI);
		requestDatas.put(LKWebStatics.LK_REQUEST_URI_WITHOUT_CTX, requestURIWithoutCtx);
		requestDatas.put(LKWebStatics.LK_REQUEST_URI_ROOT, requestURIRoot);
		requestDatas.put(LKWebStatics.LK_REQUEST_URI_SUB, requestURIWithoutCtx.substring(requestURIRoot.length()).replace(LKWebStatics.VIEW_REQUEST_SUFFIX, LKStringStatics.STR_EMPTY));

		// 初始化视图模型对象
		final ModelAndView mv = new ModelAndView();
		mv.addObject(LKWebStatics.REQUEST_DATAS, requestDatas.getMap());
		String viewName = requestURIWithoutCtx.replace(LKWebStatics.VIEW_REQUEST_SUFFIX, LKStringStatics.STR_EMPTY);
		if ("/".equals(viewName)) {
			viewName = "/index";
		}
		mv.setViewName(viewName);
		return mv;
	}


	/**
	 * 通过读取注解的方式获取获取映射根路径
	 * @return 映射根路径
	 */
	protected String getRootRequestMappingValue() {
		final Annotation[] annotations = this.getClass().getAnnotations();
		if (ArrayUtils.isNotEmpty(annotations)) {
			for (final Annotation annotation : annotations) {
				if (annotation.annotationType() == RequestMapping.class) {
					final String[] values = ((RequestMapping) annotation).value();
					if (ArrayUtils.isNotEmpty(values) && (values.length == 1)) {
						return values[0];
					}
				}
			}
		}
		return LKStringStatics.STR_EMPTY;
	}

}
