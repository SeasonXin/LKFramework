package com.lichkin.framework.http.response;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.lichkin.framework.bases.enums.LKContentTypeEnum;
import com.lichkin.framework.bases.enums.utils.LKEnumUtils;;

/**
 * 响应写入对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKResponseWriter {

	/** HttpServletResponse */
	private final HttpServletResponse response;

	/** 字符集编码 */
	private final String charset;

	/** 扩展名 */
	private final String extName;

	/** 显示名 */
	private final String showName;


	/**
	 * 构造方法
	 * @param response HttpServletResponse
	 * @param charset 字符集编码
	 * @param extName 扩展名
	 * @param showName 显示名
	 */
	public LKResponseWriter(final HttpServletResponse response, final String charset, final String extName, final String showName) {
		this.response = response;
		this.charset = charset;
		this.extName = extName;
		this.showName = showName;
	}


	/**
	 * 写入响应
	 * @throws Exception 写入可能抛出异常
	 */
	public void write() throws Exception {
		// 设置响应相关
		response.reset();
		response.setCharacterEncoding(charset);
		response.setContentType((LKEnumUtils.getEnumByKey(LKContentTypeEnum.values(), extName)).getName());
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(showName, charset));

		doWrite(response, charset, extName, showName);

		// 刷新响应
		response.getWriter().flush();
	}


	/**
	 * 写入响应
	 * @param response HttpServletResponse
	 * @param charset 字符集编码
	 * @param extName 扩展名
	 * @param showName 显示名
	 * @throws Exception 写入可能抛出异常
	 */
	protected abstract void doWrite(HttpServletResponse response, String charset, String extName, String showName) throws Exception;

}
