package com.lichkin.framework.springboot.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.controllers.LKController;
import com.lichkin.framework.springboot.services.impl.LKWechatTokenService;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.utils.LKWechatSignatureValidator;

/**
 * 微信Token验证控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
@RequestMapping(value = "/lichkin/wechat/token")
public final class LKWechatTokenController extends LKController {

	/** 微信Token验证服务类 */
	@Autowired
	private LKWechatTokenService service;


	/**
	 * 微信Token验证，关注、取消关注、点击按钮事件等都会调用此方法。
	 * @param requestDatas 请求参数
	 */
	@ResponseBody
	@RequestMapping(value = "/verify.do")
	public Object verifyToken(final LKDatas requestDatas) {
		// 参数验证
		final Long echostr = requestDatas.getLong("echostr", null);
		final String event = requestDatas.getString("Event", null);
		if (LKStringUtils.isBlank(event)) {// 没有事件，则是第一次调用验证，返回echostr原文。
			logger.info("no event, return echostr.");
			return echostr;
		}

		// 事件调用按照微信API进行签名验证
		LKWechatSignatureValidator.check(requestDatas.getString("signature", null), requestDatas.getString("timestamp", null), requestDatas.getString("nonce", null));

		final LKWechatBean bean = new LKWechatBean();
		bean.setAccountOpenid(requestDatas.getString("ToUserName", null));
		bean.setOpenid(requestDatas.getString("FromUserName", null));

		final String msg = service.verifyToken(bean, event.toLowerCase(), requestDatas.getString("EventKey", ""));
		if (msg == null) {
			logger.debug("msg is null, return echostr.");
			return echostr;
		}
		return msg;
	}

}
