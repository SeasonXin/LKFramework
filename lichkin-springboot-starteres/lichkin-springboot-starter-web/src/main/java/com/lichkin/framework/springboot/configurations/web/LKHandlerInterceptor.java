package com.lichkin.framework.springboot.configurations.web;

import static com.lichkin.framework.bases.enums.LKDatePatternEnum.ALL;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.AllowReuqestIpKey;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.bases.enums.LKRangeTypeEnum;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.http.utils.LKIpUtils;
import com.lichkin.framework.http.utils.LKUrlUtils;
import com.lichkin.framework.springboot.utils.LKMultipartFileUtils;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.springboot.utils.LKRequestExtractorOnSpring;
import com.lichkin.framework.springboot.web.LKSessionUser;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 拦截器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKHandlerInterceptor implements HandlerInterceptor, LKWebStatics {

	/** 日志对象 */
	private final Log logger = LogFactory.getLog(getClass());


	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
		// 解析请求参数
		final String requestId = LKRandomUtils.create(32, LKRangeTypeEnum.NUMBER_AND_LETTER_FULL_LOWERCASE);
		final DateTime requestTime = DateTime.now();
		final String requestIp = LKIpUtils.getIp(request);
		final String requestUrl = LKUrlUtils.getFullPath(request);
		final LKDatas requestDatas = LKRequestExtractorOnSpring.getRequestParamsFromAll(request);
		final LKDatas requestDatasReduce = LKMultipartFileUtils.convertMultipartFiles(requestDatas);

		// 设置自定义的参数
		request.setAttribute(LK_REQUEST_ID, requestId);
		request.setAttribute(LK_REQUEST_TIME, requestTime);
		request.setAttribute(LK_REQUEST_IP, requestIp);
		request.setAttribute(LK_REQUEST_URL, requestUrl);
		request.setAttribute(LK_REQUEST_DATAS, requestDatas);
		request.setAttribute(LK_REQUEST_DATAS_REDUCE, requestDatasReduce);

		// 记录日志
		final Map<String, Object> map = new HashMap<>();
		map.put(REQUEST_ID, requestId);
		map.put(REQUEST_TIME, requestTime.toString(ALL.getNameEn()));
		map.put(REQUEST_IP, requestIp);
		map.put(REQUEST_URL, requestUrl);
		map.put(REQUEST_DATAS, requestDatasReduce.getMap());
		logger.info(LKJSONUtils.toJson(map, true, false));

		if ((handler != null) && (handler instanceof HandlerMethod)) {
			// 先判断IP地址是否允许访问
			final AllowReuqestIpKey allowReuqestIpKey = ((HandlerMethod) handler).getMethodAnnotation(AllowReuqestIpKey.class);
			if (allowReuqestIpKey != null) {
				boolean allowRequest = false;
				String key = allowReuqestIpKey.key();
				if (LKStringUtils.isBlank(key)) {
					key = ((HandlerMethod) handler).getBeanType().getSimpleName() + "." + ((HandlerMethod) handler).getMethod().getName();
				}
				final String value = LKPropertiesUtils.getProperty("lichkin.business.AllowReuqestIpKey." + key, "0:0:0:0:0:0:0:1,127.0.0.1,localhost");
				final String[] ips = value.split(",");
				for (final String ip : ips) {
					if (requestIp.equals(ip)) {
						allowRequest = true;
					}
					if (ip.equals("*")) {
						allowRequest = true;
					}
					if (ip.endsWith("*") && requestIp.substring(0, requestIp.lastIndexOf(".")).equals(ip.substring(0, ip.lastIndexOf(".")))) {
						allowRequest = true;
					}
				}
				if (!allowRequest) {// 不允许访问
					return false;
				}
			}

			// 再判断是否允许不登录访问
			if (((HandlerMethod) handler).getMethodAnnotation(WithOutLogin.class) != null) {// 配置了无登录访问
				return true;
			}

			if (((HandlerMethod) handler).getClass().getAnnotation(WithOutLogin.class) != null) {// 配置了无登录访问
				return true;
			}

			if (LKSessionUser.isLogin()) {// 已登录
				return true;
			}

			response.sendRedirect(LKUrlUtils.getBasePath(request) + "/login.html");
			return false;
		}

		return true;
	}


	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView mav) throws Exception {
		// 记录日志
		final Map<String, Object> map = new HashMap<>();
		map.put(REQUEST_ID, request.getAttribute(LK_REQUEST_ID));
		map.put(REQUEST_HANDLER_CLASS, ((HandlerMethod) handler).getBean().toString());
		map.put(REQUEST_HANDLER_METHOD, ((HandlerMethod) handler).getMethod().getName());
		logger.info(JSON.toJSONString(map));
	}


	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
		// 计算时间
		final DateTime now = DateTime.now();
		final DateTime requestTime = (DateTime) request.getAttribute(LK_REQUEST_TIME);
		final long responseElapsedTime = now.getMillis() - requestTime.getMillis();

		// 记录日志
		final Map<String, Object> map = new HashMap<>();
		map.put(REQUEST_ID, request.getAttribute(LK_REQUEST_ID));
		map.put(REQUEST_TIME, requestTime.toString(ALL.getNameEn()));
		map.put(RESPONSE_TIME, now.toString(ALL.getNameEn()));
		map.put(RESPONSE_ELAPSED_TIME, responseElapsedTime + "ms");
		logger.info(JSON.toJSONString(map));
	}

}
