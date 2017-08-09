package com.lichkin.framework.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.http.request.LKRequestUtils;
import com.lichkin.framework.springboot.services.LKWechatTodoService;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;

/**
 * 微信oauth2服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKWechatOauth2Service extends LKWechatDoService {

	/** 微信事件服务类 */
	@Autowired
	private LKWechatTodoService service;


	@Override
	protected LKWechatTodoService getService() {
		return service;
	}


	/**
	 * 获取跳转地址
	 * @param bean 微信对象
	 * @return 跳转地址
	 */
	public String getRedirectUrl(final LKWechatBean bean) {
		return doService(bean);
	}


	/**
	 * 获取微信ID
	 * @param code 微信oauth2跳转时的code参数
	 * @return 微信ID
	 * @throws Exception 请求微信接口时可能抛出异常
	 */
	public String getOpenid(final String code) throws Exception {
		final String url = LKStringUtils.replaceDatas(LKWechatConfigStatics.getOpenidUrl, new LKDatas().put("#code", code));
		return LKJSONUtils.toDatas(LKRequestUtils.doRequest(url), false).getString("openid", null);
	}

}
