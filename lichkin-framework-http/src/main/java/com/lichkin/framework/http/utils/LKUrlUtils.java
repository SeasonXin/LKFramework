package com.lichkin.framework.http.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * URL工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKUrlUtils {

	/**
	 * 获取站点根路径
	 * @param request HttpServletRequest
	 * @return 站点根路径
	 */
	public static String getBasePath(final HttpServletRequest request) {
		final String port = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
		return StringUtils.join(request.getScheme(), "://", request.getServerName(), port, request.getContextPath());
	}


	/**
	 * 获取请求全路径
	 * @param request HttpServletRequest
	 * @return 请求全路径
	 */
	public static String getFullPath(final HttpServletRequest request) {
		return StringUtils.join(LKUrlUtils.getBasePath(request), LKUrlUtils.getRequestURIWithoutCtx(request.getContextPath(), request.getRequestURI()));
	}


	/**
	 * 获取请求路径（不包含环境上下文）
	 * @param contextPath 请求环境上下文
	 * @param requestURI （包含环境上下文）
	 * @return 获取请求路径（不包含环境上下文）
	 */
	public static String getRequestURIWithoutCtx(final String contextPath, String requestURI) {
		if (LKStringUtils.isNotBlank(contextPath) && requestURI.startsWith(contextPath)) {
			requestURI = requestURI.substring(contextPath.length());
		}
		return requestURI;
	}

}
