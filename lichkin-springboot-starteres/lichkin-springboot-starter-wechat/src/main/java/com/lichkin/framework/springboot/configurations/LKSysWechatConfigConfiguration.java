package com.lichkin.framework.springboot.configurations;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;

/**
 * 系统配置信息配置
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component
public class LKSysWechatConfigConfiguration extends LKDBService implements ApplicationListener<ApplicationContextEvent> {

	@Override
	public void onApplicationEvent(final ApplicationContextEvent event) {
		// debug
		LKWechatConfigStatics.debug = LKPropertiesUtils.getProperty("lichkin.framework.wechat.debug", false);

		// debugOpenid
		LKWechatConfigStatics.debugOpenid = LKPropertiesUtils.getProperty("lichkin.framework.wechat.debug.openid");

		// appid
		final String appid = LKPropertiesUtils.getProperty("lichkin.framework.wechat.appid");
		if (appid == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.appid is null.");
		}
		LKWechatConfigStatics.appid = appid;

		// secret
		final String secret = LKPropertiesUtils.getProperty("lichkin.framework.wechat.secret");
		if (secret == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.secret is null.");
		}
		LKWechatConfigStatics.secret = secret;

		final String token = LKPropertiesUtils.getProperty("lichkin.framework.wechat.token");
		if (token == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.token is null.");
		}
		LKWechatConfigStatics.token = token;

		// projectUrl
		final String projectUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.project.url");
		if (projectUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.project.url is null.");
		}
		LKWechatConfigStatics.projectUrl = projectUrl;

		// authorizeUrl
		String authorizeUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.apiUrls.authorize");
		if (authorizeUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.apiUrls.authorize is null.");
		}
		try {
			authorizeUrl = LKStringUtils.replaceDatas(authorizeUrl, new LKDatas().put("#appid", appid).put("#projectUrl", URLEncoder.encode(projectUrl, "UTF-8")));
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
		}
		LKWechatConfigStatics.authorizeUrl = authorizeUrl;

		// getOpenidUrl
		String getOpenidUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.apiUrls.getOpenid");
		if (getOpenidUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.apiUrls.getOpenid is null.");
		}
		getOpenidUrl = LKStringUtils.replaceDatas(getOpenidUrl, new LKDatas().put("#appid", appid).put("#secret", secret));
		LKWechatConfigStatics.getOpenidUrl = getOpenidUrl;

		String getAccessTokenUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.apiUrls.getAccessToken");
		if (getAccessTokenUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.apiUrls.getAccessToken is null.");
		}

		getAccessTokenUrl = LKStringUtils.replaceDatas(getAccessTokenUrl, new LKDatas().put("#appid", appid).put("#secret", secret));
		LKWechatConfigStatics.getAccessTokenUrl = getAccessTokenUrl;

		final String menuCreateUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.apiUrls.menuCreate");
		if (menuCreateUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.apiUrls.menuCreate is null.");
		}
		LKWechatConfigStatics.menuCreateUrl = menuCreateUrl;

		final String getJsTicketUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.apiUrls.getJsTicket");
		if (getJsTicketUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.apiUrls.getJsTicket is null.");
		}
		LKWechatConfigStatics.getJsTicketUrl = getJsTicketUrl;

		final String welcomeTitle = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg.welcome.title");
		if (welcomeTitle == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg.welcome.title is null.");
		}
		LKWechatConfigStatics.welcomeTitle = welcomeTitle;

		final String welcomeDescription = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg.welcome.description");
		if (welcomeDescription == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg.welcome.description is null.");
		}
		LKWechatConfigStatics.welcomeDescription = welcomeDescription;

		final String welcomePicUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg.welcome.picUrl");
		if (welcomePicUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg.welcome.picUrl is null.");
		}
		LKWechatConfigStatics.welcomePicUrl = welcomePicUrl;

		final String welcomeUrl = LKPropertiesUtils.getProperty("lichkin.framework.wechat.msg.welcome.url");
		if (welcomeUrl == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.msg.welcome.url is null.");
		}
		LKWechatConfigStatics.welcomeUrl = welcomeUrl;
	}

}
