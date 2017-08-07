package com.lichkin.framework.springboot.wechat;

import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.wechat.LKWechatConfigKeys;

/**
 * 使用本包相关配置值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKWechatProperties {

	/** 配置值： wechat.debug */
	public static final boolean WECHAT_DEBUG = Boolean.parseBoolean(LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_DEBUG, "false"));

	/** 配置值： wechat.debug.openid */
	public static final String WECHAT_DEBUG_OPENID = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_DEBUG_OPENID, "oZwfPviq9MDTmNSwnpOHzSJmtijA");

	/** 配置值： wechat.project.appid */
	public static final String WECHAT_PROJECT_APPID = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_PROJECT_APPID, "wx1234567890");

	/** 配置值：wechat.project.secret */
	public static final String WECHAT_PROJECT_SECRET = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_PROJECT_SECRET, "1234567890");

	/** 配置值：wechat.project.domainName */
	public static final String WECHAT_PROJECT_DOMAINNAME = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_PROJECT_DOMAINNAME, "wechat.lichkin.com");

	/** 配置值：wechat.project.name */
	public static final String WECHAT_PROJECT_NAME = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_PROJECT_NAME, "");

	/** 配置值：wechat.project.token */
	public static final String WECHAT_PROJECT_TOKEN = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_PROJECT_TOKEN, "lichkin");

	/** 配置值： wechat.msg.welcom.title */
	public static final String WECHAT_MSG_WELCOME_TITLE = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_WELCOME_TITLE, "欢迎访问鑫宏利业微信公众号");

	/** 配置值：wechat.msg.welcom.description */
	public static final String WECHAT_MSG_WELCOME_DESCRIPTION = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_WELCOME_DESCRIPTION, "苏州鑫宏利业信息科技有限公司");

	/** 配置值：wechat.msg.welcom.picUrl */
	public static final String WECHAT_MSG_WELCOME_PICURL = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_WELCOME_PICURL, "http://yun.baidu.com/share/link?shareid=1843259259&uk=1469070818");

	/** 配置值：wechat.msg.welcom.directUrl */
	public static final String WECHAT_MSG_WELCOME_DIRECT_URL = LKPropertiesUtils.getProperty(LKWechatConfigKeys.CONFIG_WECHAT_MSG_WELCOME_DIRECT_URL, "/index.html?1=1");

}
