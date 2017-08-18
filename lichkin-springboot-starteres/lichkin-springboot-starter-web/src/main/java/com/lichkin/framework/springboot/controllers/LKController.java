package com.lichkin.framework.springboot.controllers;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.http.utils.LKUrlUtils;

/**
 * 通用控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKController implements LKWebStatics {

	/** 日志记录对象 */
	public final Log logger = LogFactory.getLog(getClass());

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
		if (requestURI.contains(";")) {
			requestURI = requestURI.substring(0, requestURI.indexOf(";"));
		}
		final String requestURIWithoutCtx = LKUrlUtils.getRequestURIWithoutCtx(contextPath, requestURI);
		final String requestURIRoot = getRootRequestMappingValue();

		// 在请求数据中加入请求相关路径的参数
		requestDatas.put(LK_REQUEST_CTX, contextPath);
		requestDatas.put(LK_REQUEST_URI, requestURI);
		requestDatas.put(LK_REQUEST_URI_WITHOUT_CTX, requestURIWithoutCtx);
		requestDatas.put(LK_REQUEST_URI_ROOT, requestURIRoot);
		requestDatas.put(LK_REQUEST_URI_SUB, requestURIWithoutCtx.substring(requestURIRoot.length()).replace(VIEW_REQUEST_SUFFIX, ""));

		// 初始化视图模型对象
		final ModelAndView mv = new ModelAndView();
		mv.addObject(REQUEST_DATAS, requestDatas.getMap());
		String viewName = requestURIWithoutCtx.replace(VIEW_REQUEST_SUFFIX, "");
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
		return "";
	}


	/**
	 * 验证参数（只做非空验证，""、" "、null都将视为空。）
	 * @param requestDatas 请求数据
	 * @param keys 参数key数组
	 */
	public void validateParams(final LKDatas requestDatas, final String... keys) {
		for (final String key : keys) {
			if (requestDatas.getString(key, null) == null) {
				throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
			}
		}
	}

}
