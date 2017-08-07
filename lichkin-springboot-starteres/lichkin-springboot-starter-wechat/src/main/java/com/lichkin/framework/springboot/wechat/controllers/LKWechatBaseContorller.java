package com.lichkin.framework.springboot.wechat.controllers;

import com.lichkin.framework.springboot.web.controllers.LKController;
import com.lichkin.framework.springboot.wechat.LKWechatProperties;
import com.lichkin.framework.wechat.statics.LKWechatStatics;

/**
 * 微信基本控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKWechatBaseContorller extends LKController {

	/**
	 * 获取openid
	 * @return openid
	 */
	public String getOpenid() {
		if (LKWechatProperties.WECHAT_DEBUG) {
			return LKWechatProperties.WECHAT_DEBUG_OPENID;
		}
		Object openid = session.getAttribute(LKWechatStatics.OPENID);
		if (openid == null) {
			openid = request.getParameter(LKWechatStatics.OPENID);
			if (openid == null) {
				return null;
			}
			session.setAttribute(LKWechatStatics.OPENID, openid);
		}
		return openid.toString();
	}

}
