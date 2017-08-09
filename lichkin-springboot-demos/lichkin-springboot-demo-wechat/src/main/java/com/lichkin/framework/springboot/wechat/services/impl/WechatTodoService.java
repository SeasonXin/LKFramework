package com.lichkin.framework.springboot.wechat.services.impl;

import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.services.LKWechatTodoService;
import com.lichkin.framework.wechat.bean.LKWechatBean;

/**
 * wechat项目需要实现自定义的服务类，因使用了abstract class而不是interface定义，所以如无自定义实现可不做任何实现。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class WechatTodoService extends LKWechatTodoService {

	@Override
	public String do11(final LKWechatBean bean) {
		// TODO 实现第1个主菜单的第1个子菜单的业务
		return super.do11(bean);
	}


	@Override
	public String do12(final LKWechatBean bean) {
		// TODO 实现第1个主菜单的第2个子菜单的业务
		return super.do12(bean);
	}


	@Override
	public String doOther(final LKWechatBean bean) {
		// TODO 实现不属于3*5菜单中的请求的业务
		return super.doOther(bean);
	}


	@Override
	public String subscribe(final LKWechatBean bean) {
		// TODO 实现关注事件调用方法
		return super.subscribe(bean);
	}


	@Override
	public void unsubscribe(final LKWechatBean bean) {
		// TODO 取消关注事件调用方法
		super.unsubscribe(bean);
	}


	@Override
	public String scan(final LKWechatBean bean) {
		// TODO 扫描二维码事件调用方法
		return super.scan(bean);
	}


	@Override
	public String scanSubscribe(final LKWechatBean bean) {
		// TODO 扫描二维码关注事件调用方法
		return super.scanSubscribe(bean);
	}

}
