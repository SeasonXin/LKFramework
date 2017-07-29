package com.lichkin.framework.http.response;

import javax.servlet.http.HttpServletResponse;;

/**
 * 响应写入对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKResponseWriter4Exception extends LKResponseWriter {

	/** 异常信息 */
	protected Exception exception;


	/**
	 * 构造方法
	 * @param response HttpServletResponse
	 * @param charset 字符集编码
	 * @param exception 异常信息
	 */
	public LKResponseWriter4Exception(final HttpServletResponse response, final String charset, final Exception exception) {
		super(response, charset, "TXT", "download file failed.txt");
		this.exception = exception;
	}


	@Override
	protected void doWrite(final HttpServletResponse response, final String charset, final String extName, final String showName) throws Exception {
		// 写入错误信息
		response.getWriter().write(exception.getMessage());
	}

}
