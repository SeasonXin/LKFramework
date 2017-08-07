package com.lichkin.framework.wechat;

/**
 * 使用本包相关配置项
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWechatConfigKeys {

	/** 配置项： wechat.debug */
	public static final String CONFIG_WECHAT_DEBUG = "wechat.debug";

	/** 配置项： wechat.debug.openid */
	public static final String CONFIG_WECHAT_DEBUG_OPENID = "wechat.debug.openid";

	/** 配置项： wechat.project.appid */
	public static final String CONFIG_WECHAT_PROJECT_APPID = "wechat.project.appid";

	/** 配置项：wechat.project.secret */
	public static final String CONFIG_WECHAT_PROJECT_SECRET = "wechat.project.secret";

	/** 配置项：wechat.project.domainName */
	public static final String CONFIG_WECHAT_PROJECT_DOMAINNAME = "wechat.project.domainName";

	/** 配置项：wechat.project.name */
	public static final String CONFIG_WECHAT_PROJECT_NAME = "wechat.project.name";

	/** 配置项：wechat.project.token */
	public static final String CONFIG_WECHAT_PROJECT_TOKEN = "wechat.project.token";

	/** 配置项： wechat.msg.welcome.title */
	public static final String CONFIG_WECHAT_MSG_WELCOME_TITLE = "wechat.msg.welcome.title";

	/** 配置项：wechat.msg.welcome.description */
	public static final String CONFIG_WECHAT_MSG_WELCOME_DESCRIPTION = "wechat.msg.welcome.description";

	/** 配置项：wechat.msg.welcome.picUrl */
	public static final String CONFIG_WECHAT_MSG_WELCOME_PICURL = "wechat.msg.welcome.picUrl";

	/** 配置项：wechat.msg.welcome.directUrl，需要地址后至少加一个参数，如没有参数可以加?1=1。框架中会增加一个openid参数。 */
	public static final String CONFIG_WECHAT_MSG_WELCOME_DIRECT_URL = "wechat.msg.welcome.directUrl";

	/** 配置项：wechat.msg. 微信消息前缀。 */
	public static final String CONFIG_WECHAT_MSG_PREFIX = "wechat.msg.";

	/** 配置项：.url 微信消息后缀，URL。 */
	public static final String CONFIG_WECHAT_MSG_SUFFIX_URL = ".url";

	/** 配置项：.templateId 微信消息后缀，模板ID。 */
	public static final String CONFIG_WECHAT_MSG_SUFFIX_TEMPLATE_ID = ".templateId";

}
