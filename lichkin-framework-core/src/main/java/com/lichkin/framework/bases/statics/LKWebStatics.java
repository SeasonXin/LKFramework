package com.lichkin.framework.bases.statics;

import java.nio.charset.Charset;

/**
 * web常量
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWebStatics extends LKStatics {

	/** 请求ID */
	public static final String REQUEST_ID = "requestId";

	/** 请求时间 */
	public static final String REQUEST_TIME = "requestTime";

	/** 请求IP */
	public static final String REQUEST_IP = "requestIp";

	/** 请求地址 */
	public static final String REQUEST_URL = "requestUrl";

	/** 请求参数 */
	public static final String REQUEST_DATAS = "requestDatas";

	/** 请求参数（文件类型只存放文件名） */
	public static final String REQUEST_DATAS_REDUCE = "requestDatasReduce";

	/** 请求环境上下文 */
	public static final String REQUEST_CTX = "requestCtx";

	/** 请求路径（包含环境上下文） */
	public static final String REQUEST_URI = "requestURI";

	/** 请求路径（不包含环境上下文） */
	public static final String REQUEST_URI_WITHOUT_CTX = "requestURIWithoutCtx";

	/** 请求根路径 */
	public static final String REQUEST_URI_ROOT = "requestURIRoot";

	/** 请求子路径 */
	public static final String REQUEST_URI_SUB = "requestURISub";

	/** 关闭页面回调方法名 */
	public static final String ONCLOSE_FUNC_NAME = "onCloseFuncName";

	/** 请求处理类 */
	public static final String REQUEST_HANDLER_CLASS = "requestHandlerClass";

	/** 请求处理方法 */
	public static final String REQUEST_HANDLER_METHOD = "requestHandlerMethod";

	/** 页面请求后缀 */
	public static final String VIEW_REQUEST_SUFFIX = ".html";

	/** 数据请求后缀 */
	public static final String DATA_REQUEST_SUFFIX = ".do";

	/** 响应时间 */
	public static final String RESPONSE_TIME = "responseTime";

	/** 响应耗时 */
	public static final String RESPONSE_ELAPSED_TIME = "responseElapsedTime";

	/** 编码 */
	public static final String DEFAULT_ENCODING = "UTF-8";

	/** 默认编码 */
	public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_ENCODING);

	/** 请求ID */
	public static final String LK_REQUEST_ID = LICHKIN_ + REQUEST_ID;

	/** 请求时间 */
	public static final String LK_REQUEST_TIME = LICHKIN_ + REQUEST_TIME;

	/** 请求IP */
	public static final String LK_REQUEST_IP = LICHKIN_ + REQUEST_IP;

	/** 请求地址 */
	public static final String LK_REQUEST_URL = LICHKIN_ + REQUEST_URL;

	/** 请求参数 */
	public static final String LK_REQUEST_DATAS = LICHKIN_ + REQUEST_DATAS;

	/** 请求参数（文件类型只存放文件名） */
	public static final String LK_REQUEST_DATAS_REDUCE = LICHKIN_ + REQUEST_DATAS_REDUCE;

	/** 请求环境上下文 */
	public static final String LK_REQUEST_CTX = LICHKIN_ + REQUEST_CTX;

	/** 请求路径（包含环境上下文） */
	public static final String LK_REQUEST_URI = LICHKIN_ + REQUEST_URI;

	/** 请求路径（不包含环境上下文） */
	public static final String LK_REQUEST_URI_WITHOUT_CTX = LICHKIN_ + REQUEST_URI_WITHOUT_CTX;

	/** 请求根路径 */
	public static final String LK_REQUEST_URI_ROOT = LICHKIN_ + REQUEST_URI_ROOT;

	/** 请求子路径 */
	public static final String LK_REQUEST_URI_SUB = LICHKIN_ + REQUEST_URI_SUB;

	/** 关闭页面回调方法名 */
	public static final String LK_ONCLOSE_FUNC_NAME = LICHKIN_ + ONCLOSE_FUNC_NAME;

}
