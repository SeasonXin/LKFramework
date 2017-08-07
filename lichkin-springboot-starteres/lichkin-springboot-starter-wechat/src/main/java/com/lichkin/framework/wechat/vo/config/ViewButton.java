package com.lichkin.framework.wechat.vo.config;

import com.lichkin.framework.wechat.LKWechatApiUrls;
import com.lichkin.framework.wechat.LKWechatVariables;

import lombok.Getter;

/**
 * 微信菜单按钮（跳转链接地址类型）
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class ViewButton extends Button {

	/**
	 * 构造方法
	 * @param name 菜单名称
	 */
	public ViewButton(final String name) {
		super("view", name);
	}


	/** 链接地址 */
	private String url;


	@Override
	public void init(final int x, final int y) {
		super.init(x, y);
		final String btnName = "btn" + x + y;
		url = LKWechatApiUrls.OAUTH2_TOGO.replace(LKWechatVariables.VARIABLE_BTN_NAME, btnName).replace(LKWechatVariables.VARIABLE_STATE, btnName);
	}

}
