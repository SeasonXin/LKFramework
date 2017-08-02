package com.lichkin.framework.springboot.configurations.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * GZIP压缩文件过滤器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKGZipFilter implements Filter {

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
	}


	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		if (response instanceof HttpServletResponse) {
			request.setCharacterEncoding("UTF-8");
			((HttpServletResponse) response).setHeader("Content-Encoding", "gzip");
		}
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {
	}

}
