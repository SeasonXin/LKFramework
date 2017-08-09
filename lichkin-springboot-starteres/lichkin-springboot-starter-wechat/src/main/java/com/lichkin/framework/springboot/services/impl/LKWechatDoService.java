package com.lichkin.framework.springboot.services.impl;

import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN11;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN12;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN13;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN14;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN15;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN21;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN22;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN23;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN24;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN25;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN31;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN32;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN33;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN34;
import static com.lichkin.framework.wechat.statics.LKWechatMenuStatics.BTN35;

import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springboot.services.LKWechatTodoService;
import com.lichkin.framework.wechat.bean.LKWechatBean;

/**
 * 微信执行通用服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKWechatDoService extends LKDBService {

	/**
	 * 获取执行服务类
	 * @return 执行服务类
	 */
	protected abstract LKWechatTodoService getService();


	/**
	 * 执行
	 * @param bean 微信对象
	 * @return 消息文本或跳转地址
	 */
	protected String doService(final LKWechatBean bean) {
		switch (bean.getBtnName()) {
			case BTN11:
				return getService().do11(bean);
			case BTN12:
				return getService().do12(bean);
			case BTN13:
				return getService().do13(bean);
			case BTN14:
				return getService().do14(bean);
			case BTN15:
				return getService().do15(bean);
			case BTN21:
				return getService().do21(bean);
			case BTN22:
				return getService().do22(bean);
			case BTN23:
				return getService().do23(bean);
			case BTN24:
				return getService().do24(bean);
			case BTN25:
				return getService().do25(bean);
			case BTN31:
				return getService().do31(bean);
			case BTN32:
				return getService().do32(bean);
			case BTN33:
				return getService().do33(bean);
			case BTN34:
				return getService().do34(bean);
			case BTN35:
				return getService().do35(bean);
			default:
				return getService().doOther(bean);
		}
	}

}
