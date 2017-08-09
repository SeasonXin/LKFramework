package com.lichkin.framework.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.services.LKWechatTodoService;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.statics.LKWechatMenuStatics;

/**
 * 微信Token验证服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKWechatTokenService extends LKWechatDoService {

	/** 微信事件服务类 */
	@Autowired
	private LKWechatTodoService service;


	@Override
	protected LKWechatTodoService getService() {
		return service;
	}


	/**
	 * 微信Token验证，关注、取消关注、点击按钮事件等都会调用此方法。
	 * @param bean 微信对象
	 * @param event 微信事件
	 * @param eventKey 微信事件参数
	 * @return 消息文本或跳转地址
	 */
	public String verifyToken(final LKWechatBean bean, final String event, final String eventKey) {
		String msg = null;
		switch (event) {
			case "subscribe":// 关注事件
				final int index = eventKey.indexOf(LKWechatMenuStatics.BTN_NAME_URL_SUFFIX);
				if (index > 0) {// 通过动态二维码扫描关注的
					bean.setSceneId(eventKey.substring("qrscene_".length()));
					msg = service.scanSubscribe(bean);
				} else {// 正常方式关注的
					msg = service.subscribe(bean);
				}
			break;
			case "unsubscribe":// 取消关注事件
				service.unsubscribe(bean);
			break;
			case "view":// 视图菜单事件
				int idx = eventKey.indexOf(LKWechatMenuStatics.BTN_NAME_URL_SUFFIX);
				if (idx > 0) {
					idx += LKWechatMenuStatics.BTN_NAME_URL_SUFFIX_LENGTH;
					final String btnName = eventKey.substring(idx, idx + 5);
					bean.setBtnName(btnName);
					final String str = doService(bean);
					if (LKStringUtils.isNotBlank(str) && !str.startsWith("/")) {
						msg = str;
					}
				}
			break;
			case "click":// 点击菜单事件
				bean.setBtnName(eventKey);
				msg = doService(bean);
			break;
			case "scan":// 扫描二维码事件
				bean.setSceneId(eventKey);
				msg = service.scan(bean);
			break;
		}
		logger.debug("msg:" + msg);
		return msg;
	}

}
