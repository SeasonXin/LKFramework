package com.lichkin.framework.springboot.wechat.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.framework.http.request.LKRequestUtils;
import com.lichkin.framework.springboot.wechat.services.LKWechatTodoService;
import com.lichkin.framework.utils.lang.json.LKJSONUtils;
import com.lichkin.framework.wechat.LKWechatApiUrls;
import com.lichkin.framework.wechat.LKWechatVariables;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.statics.LKWechatStatics;

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
		return LKJSONUtils.toDatas(LKRequestUtils.doRequest(LKWechatApiUrls.GET_OAUTH2_ACCESS_TOKEN.replace(LKWechatVariables.VARIABLE_CODE, code))).getString(LKWechatStatics.OPENID, null);
	}

}
