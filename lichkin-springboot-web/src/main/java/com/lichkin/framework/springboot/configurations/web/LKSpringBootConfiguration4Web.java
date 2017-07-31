package com.lichkin.framework.springboot.configurations.web;

import java.util.concurrent.TimeUnit;

import javax.servlet.MultipartConfigElement;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.DispatcherServlet;

import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.springboot.web.LKWebProperties;

/**
 * Web项目基础配置
 */
@Configuration
public class LKSpringBootConfiguration4Web {

	/**
	 * 构建servle容器
	 * @return EmbeddedServletContainerFactory
	 */
	@Bean
	public TomcatEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		final TomcatEmbeddedServletContainerFactory embeddedServletContainerFactory = new TomcatEmbeddedServletContainerFactory();

		embeddedServletContainerFactory.addContextCustomizers(new TomcatContextCustomizer() {

			@Override
			public void customize(final Context context) {
				// 增加编码过滤器
				final FilterDef encodingFilter = new FilterDef();
				encodingFilter.setDisplayName("encodingFilter");
				encodingFilter.setFilterName("encodingFilter");
				encodingFilter.setFilterClass("org.springframework.web.filter.CharacterEncodingFilter");
				encodingFilter.addInitParameter("encoding", "UTF-8");
				encodingFilter.addInitParameter("forceEncoding", "true");

				final FilterMap encodingFilterMap = new FilterMap();
				encodingFilterMap.setFilterName("encodingFilter");
				encodingFilterMap.addURLPattern("/*");
				context.addFilterDef(encodingFilter);
				context.addFilterMap(encodingFilterMap);

				// 增加压缩包过滤器
				final FilterDef gzipFilter = new FilterDef();
				gzipFilter.setDisplayName("gzipFilter");
				gzipFilter.setFilterName("gzipFilter");
				gzipFilter.setFilterClass("com.lichkin.framework.springboot.configurations.web.LKGZipFilter");

				final FilterMap gzipFilterMap = new FilterMap();
				gzipFilterMap.setFilterName("gzipFilter");
				gzipFilterMap.addURLPattern("*.gzjs");
				gzipFilterMap.addURLPattern("*.gzcss");
				context.addFilterDef(gzipFilter);
				context.addFilterMap(gzipFilterMap);

				// 增加默认访问页面
				context.addWelcomeFile("index.jsp");
			}

		});

		embeddedServletContainerFactory.setSessionTimeout(30, TimeUnit.MINUTES);

		embeddedServletContainerFactory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, LKWebProperties.LK_WEB_PAGE_ERROR_URL));

		return embeddedServletContainerFactory;
	}


	/**
	 * 配置servlet
	 * @param dispatcherServlet 由spring自动注入
	 * @return ServletRegistrationBean
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean(final DispatcherServlet dispatcherServlet) {
		final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.addUrlMappings("*" + LKWebStatics.VIEW_REQUEST_SUFFIX);// 添加页面请求映射
		registration.addUrlMappings("*" + LKWebStatics.DATA_REQUEST_SUFFIX);// 添加数据请求映射
		registration.setLoadOnStartup(1);// 设置顺序
		return registration;
	}


	/**
	 * 配置文件请求
	 * @return MultipartConfigElement
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		final MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("10MB");// 设置上传文件大小
		factory.setMaxRequestSize("10MB");// 设置请求数据大小
		return factory.createMultipartConfig();
	}

}
