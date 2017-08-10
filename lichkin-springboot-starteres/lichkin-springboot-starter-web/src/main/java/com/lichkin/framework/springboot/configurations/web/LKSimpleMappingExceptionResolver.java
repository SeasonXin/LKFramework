package com.lichkin.framework.springboot.configurations.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lichkin.framework.bases.vos.LKReturnValueVo;
import com.lichkin.framework.springboot.applications.LKApplicationContext;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 异常处理类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	@SuppressWarnings("resource")
	protected ModelAndView doResolveException(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) {
		logger.error(ex);

		if ((handler != null) && (handler instanceof HandlerMethod)) {
			boolean isDataRequest = false;

			// 判断.do型请求
			if (!isDataRequest && LKStringUtils.endsWith(request.getRequestURI(), ".do")) {
				isDataRequest = true;
			}

			// 判断RestController注解
			if (!isDataRequest && (((HandlerMethod) handler).getBean().getClass().getAnnotation(RestController.class) != null)) {
				isDataRequest = true;
			}

			// 判断ResponseBody注解
			if (!isDataRequest && (((HandlerMethod) handler).getMethodAnnotation(ResponseBody.class) != null)) {
				isDataRequest = true;
			}

			if (isDataRequest) {// 方法使用了ResponseBody注解，则视为数据请求。
				try {
					final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(LKApplicationContext.getContext()).build();
					final JsonGenerator generator = objectMapper.getFactory().createGenerator(new ServletServerHttpResponse(response).getBody(), JsonEncoding.UTF8);
					final ObjectWriter objectWriter = objectMapper.writer();

					final CharSequence callback = LKStringUtils.toString(request.getParameter("callback"), "");
					if (LKStringUtils.isNotBlank(callback)) {// JSONP请求
						generator.writeRaw(callback + "(");
						objectWriter.writeValue(generator, new LKReturnValueVo(ex));
						generator.writeRaw(");");
					} else {// JSON请求
						response.setHeader("Content-Type", "application/json");
						objectWriter.writeValue(generator, new LKReturnValueVo(ex));
					}

					generator.flush();
				} catch (final Exception e) {
					logger.error(e);
				}

				return new ModelAndView();
			}
		}

		return super.doResolveException(request, response, handler, ex);
	}

}
