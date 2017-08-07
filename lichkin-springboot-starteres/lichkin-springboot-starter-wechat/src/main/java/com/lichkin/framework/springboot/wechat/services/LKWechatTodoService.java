package com.lichkin.framework.springboot.wechat.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lichkin.framework.utils.lang.json.LKJSONUtils;
import com.lichkin.framework.wechat.bean.LKWechatBean;
import com.lichkin.framework.wechat.utils.LKWechatXMLCreater;

/**
 * 微信事件服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKWechatTodoService {

	/** 日志记录对象 */
	public final Log LOGGER = LogFactory.getLog(getClass());


	/**
	 * 点击菜单后调用方法（第1个主菜单的第1个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do11(final LKWechatBean bean) {
		LOGGER.debug("do11.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第1个主菜单的第2个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do12(final LKWechatBean bean) {
		LOGGER.debug("do12.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第1个主菜单的第3个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do13(final LKWechatBean bean) {
		LOGGER.debug("do13.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第1个主菜单的第4个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do14(final LKWechatBean bean) {
		LOGGER.debug("do14.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第1个主菜单的第5个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do15(final LKWechatBean bean) {
		LOGGER.debug("do15.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第2个主菜单的第1个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do21(final LKWechatBean bean) {
		LOGGER.debug("do21.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第2个主菜单的第2个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do22(final LKWechatBean bean) {
		LOGGER.debug("do22.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第2个主菜单的第3个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do23(final LKWechatBean bean) {
		LOGGER.debug("do23.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第2个主菜单的第4个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do24(final LKWechatBean bean) {
		LOGGER.debug("do24.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第2个主菜单的第5个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do25(final LKWechatBean bean) {
		LOGGER.debug("do25.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第3个主菜单的第1个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do31(final LKWechatBean bean) {
		LOGGER.debug("do31.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第3个主菜单的第2个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do32(final LKWechatBean bean) {
		LOGGER.debug("do32.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第3个主菜单的第3个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do33(final LKWechatBean bean) {
		LOGGER.debug("do33.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第3个主菜单的第4个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do34(final LKWechatBean bean) {
		LOGGER.debug("do34.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（第3个主菜单的第5个子菜单）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String do35(final LKWechatBean bean) {
		LOGGER.debug("do35.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 点击菜单后调用方法（不属于3*5菜单中的调用方法）
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容或页面跳转地址
	 */
	public String doOther(final LKWechatBean bean) {
		LOGGER.debug("doOther.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 关注事件调用方法
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容
	 */
	public String subscribe(final LKWechatBean bean) {
		LOGGER.debug("subscribe.bean:" + LKJSONUtils.toJson(bean, true, false));
		return LKWechatXMLCreater.createNewsWelcom(bean);
	}


	/**
	 * 取消关注事件调用方法
	 * @param bean 微信调用对象
	 */
	public void unsubscribe(final LKWechatBean bean) {
		LOGGER.debug("unsubscribe.bean:" + LKJSONUtils.toJson(bean, true, false));
	}


	/**
	 * 扫描二维码事件调用方法
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容
	 */
	public String scan(final LKWechatBean bean) {
		LOGGER.debug("scan.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}


	/**
	 * 扫描二维码关注事件调用方法
	 * @param bean 微信调用对象
	 * @return 微信定义的信息内容
	 */
	public String scanSubscribe(final LKWechatBean bean) {
		LOGGER.debug("scanSubscribe.bean:" + LKJSONUtils.toJson(bean, true, false));
		return null;
	}

}
