package com.lichkin.framework.wechat;

import com.lichkin.framework.springboot.wechat.LKWechatProperties;

/**
 * 接口地址
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWechatApiUrls {

	/** 获取接口调用凭据 */
	public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + LKWechatProperties.WECHAT_PROJECT_APPID + "&secret=" + LKWechatProperties.WECHAT_PROJECT_SECRET;

	/** 获取OAUTH2接口调用凭据 */
	public static final String GET_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + LKWechatProperties.WECHAT_PROJECT_APPID + "&secret=" + LKWechatProperties.WECHAT_PROJECT_SECRET + "&code=${code}&grant_type=authorization_code";

	/** OAUTH2跳转地址 */
	public static final String OAUTH2_TOGO = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + LKWechatProperties.WECHAT_PROJECT_APPID + "&redirect_uri=http%3A%2F%2F" + LKWechatProperties.WECHAT_PROJECT_DOMAINNAME + (("".equals(LKWechatProperties.WECHAT_PROJECT_NAME)) ? "" : ("%2F" + LKWechatProperties.WECHAT_PROJECT_NAME)) + "%2Flichkin%2Fwechat%2Foauth2%2Fredirect.html%3FbtnName%3D${btnName}&response_type=code&scope=snsapi_base&state=${state}#wechat_redirect";

	/** 获取脚本接口调用凭证 */
	public static final String GET_JS_API_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=${access_token}&type=jsapi";

	/** 欢迎消息点击跳转地址 */
	public static final String MSG_WELCOME_URL = "http://" + LKWechatProperties.WECHAT_PROJECT_DOMAINNAME + "/" + LKWechatProperties.WECHAT_PROJECT_NAME + LKWechatProperties.WECHAT_MSG_WELCOME_DIRECT_URL + "&openid=";

	/** 创建菜单 */
	public static final String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";

}
