package com.lichkin.framework.springboot.configurations.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * WebMvc配置适配器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
public class LKWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(new LKHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/res/**", "/webjars/**");// 添加拦截器
	}


	@Override
	public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new LKDatasHandlerMethodArgumentResolver());// 添加LKDatas参数解析器
		argumentResolvers.add(new LKInvokeValueVoHandlerMethodArgumentResolver());// 添加LKInvokeValueVo参数解析器
	}


	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		final LKFastJsonHttpMessageConverter fastJsonHttpMessageConverter = new LKFastJsonHttpMessageConverter();// 使用fastJson处理消息
		fastJsonHttpMessageConverter.setFeatures(SerializerFeature.WriteMapNullValue); // 设置默认不忽略null值
		final List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.valueOf("application/json"));
		supportedMediaTypes.add(MediaType.valueOf("application/*+json"));
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(fastJsonHttpMessageConverter);
	}


	@Override
	public void extendHandlerExceptionResolvers(final List<HandlerExceptionResolver> exceptionResolvers) {
		final LKSimpleMappingExceptionResolver simpleMappingExceptionResolver = new LKSimpleMappingExceptionResolver();
		simpleMappingExceptionResolver.setDefaultErrorView("/error");// 设置默认错误页面
		final Properties mappings = new Properties();
		mappings.setProperty("java.lang.Throwable", "/error");// 映射处理所有异常
		simpleMappingExceptionResolver.setExceptionMappings(mappings);
		exceptionResolvers.add(simpleMappingExceptionResolver);// 添加异常处理器
	}


	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/res/**").addResourceLocations("/res/", "classpath:/META-INF/resources/res/", "classpath*:/META-INF/resources/res/");// 添加资源
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/", "classpath:/META-INF/resources/webjars/", "classpath*:/META-INF/resources/webjars/");// 添加资源
	}


	@Override
	public void addReturnValueHandlers(final List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		returnValueHandlers.add(new LKHandlerMethodReturnValueHandler());// 添加返回参数处理器
	}


	@Override
	public void configureViewResolvers(final ViewResolverRegistry registry) {
		final InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver("/WEB-INF/pages", ".jsp");// 设置前后缀
		internalResourceViewResolver.setContentType("text/html;charset=UTF-8");// 设置内容类型及编码
		internalResourceViewResolver.setOrder(2);// 设置顺序
		internalResourceViewResolver.setRedirectHttp10Compatible(false);// 设置HTTP 1.0不跳转
		registry.viewResolver(internalResourceViewResolver);// 添加视图解析器
	}

}
