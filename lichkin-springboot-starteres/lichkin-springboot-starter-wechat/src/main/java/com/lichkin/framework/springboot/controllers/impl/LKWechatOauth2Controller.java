package com.lichkin.framework.springboot.controllers.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springboot.controllers.LKController;
import com.lichkin.framework.springboot.services.impl.LKWechatOauth2Service;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;

/**
 * 微信oauth2控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
@RequestMapping(value = "/lichkin/wechat/oauth2")
public final class LKWechatOauth2Controller extends LKController {

	/** 微信Token验证服务类 */
	@Autowired
	private LKWechatOauth2Service service;


	/**
	 * 微信oauth2跳转
	 * @param requestDatas 请求参数
	 */
	@RequestMapping(value = "/redirect.html", method = RequestMethod.GET)
	public String toRedirect(final LKDatas requestDatas) throws Exception {
		// 参数验证
		final String code = requestDatas.getString("code", null);
		final String btnName = requestDatas.getString("btnName", null);
		final String state = requestDatas.getString("state", null);
		if (StringUtils.isBlank(code) || StringUtils.isBlank(btnName) || StringUtils.isBlank(state)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "请求参数有误");
		}

		// 判断openid是否已经缓存过
		Object openid = session.getAttribute("openid");
		if (openid == null) {
			// 从微信获取openid
			openid = service.getOpenid(code);
			if (openid == null) {
				// 重新请求验证

				return "redirect:" + LKStringUtils.replaceDatas(LKWechatConfigStatics.authorizeUrl, new LKDatas().put("#btnName", btnName).put("#state", state));
			}
			// 缓存openid
			session.setAttribute("openid", openid);
		}

		// 业务处理
		final LKWechatBean bean = new LKWechatBean();
		bean.setOpenid(openid.toString());
		bean.setBtnName(btnName);
		bean.setCode(code);
		bean.setState(state);

		final String redirectUrl = service.getRedirectUrl(bean);
		return "redirect:" + (LKStringUtils.isBlank(redirectUrl) ? "/error.html" : redirectUrl);
	}

}
