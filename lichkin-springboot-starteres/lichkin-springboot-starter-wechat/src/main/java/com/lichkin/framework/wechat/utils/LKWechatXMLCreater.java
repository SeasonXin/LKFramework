package com.lichkin.framework.wechat.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lichkin.framework.springboot.wechat.LKWechatProperties;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.xml.LKXmlUtils;
import com.lichkin.framework.wechat.LKWechatApiUrls;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.vo.Article;

/**
 * 微信消息创建工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKWechatXMLCreater {

	/**
	 * 回复文本消息
	 * @param bean 微信调用对象
	 * @param msg 消息内容
	 * @return 消息
	 */
	public static String createContentMsg(final LKWechatBean bean, final String msg) {
		final StringBuffer sb = new StringBuffer();
		sb.append("<xml>");

		sb.append("<ToUserName>");
		sb.append(LKXmlUtils.appendCData(bean.getOpenid()));
		sb.append("</ToUserName>");

		sb.append("<FromUserName>");
		sb.append(LKXmlUtils.appendCData(bean.getAccountOpenid()));
		sb.append("</FromUserName>");

		sb.append("<CreateTime>");
		sb.append(new Date().getTime());
		sb.append("</CreateTime>");

		sb.append("<MsgType>");
		sb.append(LKXmlUtils.appendCData("text"));
		sb.append("</MsgType>");

		sb.append("<Content>");
		sb.append(LKXmlUtils.appendCData(msg));
		sb.append("</Content>");
		sb.append("<MsgId>");
		sb.append(LKRandomUtils.createNumber(16));
		sb.append("</MsgId>");
		sb.append("</xml>");
		return sb.toString();
	}


	/**
	 * 回复图文消息
	 * @param bean 微信调用对象
	 * @param articles 消息内容
	 * @return 消息
	 */
	public static String createNews(final LKWechatBean bean, final List<Article> articles) {
		final StringBuffer sb = new StringBuffer();
		sb.append("<xml>");

		sb.append("<ToUserName>");
		sb.append(LKXmlUtils.appendCData(bean.getOpenid()));
		sb.append("</ToUserName>");

		sb.append("<FromUserName>");
		sb.append(LKXmlUtils.appendCData(bean.getAccountOpenid()));
		sb.append("</FromUserName>");

		sb.append("<CreateTime>");
		sb.append(new Date().getTime());
		sb.append("</CreateTime>");

		sb.append("<MsgType>");
		sb.append(LKXmlUtils.appendCData("news"));
		sb.append("</MsgType>");

		sb.append("<ArticleCount>");
		sb.append(articles.size());
		sb.append("</ArticleCount>");

		sb.append("<Articles>");
		for (final Article article : articles) {
			sb.append("<item>");

			sb.append("<Title>");
			sb.append(LKXmlUtils.appendCData(article.getTitle()));
			sb.append("</Title>");

			sb.append("<Description>");
			sb.append(LKXmlUtils.appendCData(article.getDescription()));
			sb.append("</Description>");

			sb.append("<PicUrl>");
			sb.append(LKXmlUtils.appendCData(article.getPicUrl()));
			sb.append("</PicUrl>");

			sb.append("<Url>");
			sb.append(LKXmlUtils.appendCData(article.getUrl()));
			sb.append("</Url>");

			sb.append("</item>");
		}
		sb.append("</Articles>");

		sb.append("</xml>");
		return sb.toString();
	}


	/**
	 * 创建欢迎页消息
	 * @param bean 微信调用对象
	 * @return 欢迎消息
	 */
	public static String createNewsWelcom(final LKWechatBean bean) {
		final List<Article> articles = new ArrayList<>();
		final Article article = new Article();
		article.setTitle(LKWechatProperties.WECHAT_MSG_WELCOME_TITLE);
		article.setDescription(LKWechatProperties.WECHAT_MSG_WELCOME_DESCRIPTION);
		article.setPicUrl(LKWechatProperties.WECHAT_MSG_WELCOME_PICURL);
		article.setUrl(LKWechatApiUrls.MSG_WELCOME_URL + bean.getOpenid());
		articles.add(article);
		return LKWechatXMLCreater.createNews(bean, articles);
	}

}
