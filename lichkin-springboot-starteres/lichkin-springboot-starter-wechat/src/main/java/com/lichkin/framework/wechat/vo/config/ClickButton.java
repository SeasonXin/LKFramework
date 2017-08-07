package com.lichkin.framework.wechat.vo.config;

import lombok.Getter;

/**
 * 微信菜单按钮
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class ClickButton extends Button {

	/**
	 * 构造方法
	 * @param name 菜单名称
	 */
	public ClickButton(final String name) {
		super("click", name);
	}


	/** 按钮标识符 */
	private String key;


	@Override
	public void init(final int x, final int y) {
		super.init(x, y);
		key = "btn" + x + y;
	}

}
