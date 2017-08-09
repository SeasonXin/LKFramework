package com.lichkin.framework.springboot.controllers;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;

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
		if (LKWechatConfigStatics.debug) {
			final String openid = LKWechatConfigStatics.debugOpenid;
			if (openid == null) {
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "lichkin.framework.wechat.debug.openid openid is null.");
			}
			return openid;
		}
		Object openid = session.getAttribute("openid");
		if (openid == null) {
			openid = request.getParameter("openid");
			if (openid == null) {
				return null;
			}
			session.setAttribute("openid", openid);
		}
		return openid.toString();
	}

}
