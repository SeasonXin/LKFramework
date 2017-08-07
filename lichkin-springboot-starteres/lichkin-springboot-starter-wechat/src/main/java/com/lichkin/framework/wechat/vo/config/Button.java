package com.lichkin.framework.wechat.vo.config;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

import lombok.Getter;

/**
 * 微信菜单按钮
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class Button {

	/**
	 * 构造方法
	 * @param type 菜单类型
	 * @param name 菜单名称
	 */
	protected Button(final String type, final String name) {
		super();
		this.type = type;
		this.name = name;
	}


	/** 菜单类型 */
	private final String type;

	/** 菜单名称 */
	private final String name;


	/**
	 * 初始化按钮
	 * @param x 一级菜单索引值，1-3。
	 * @param y 二级菜单索引值，1-5。
	 */
	public void init(final int x, final int y) {
		if ((x < 1) || (x > 3)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "一级菜单1-3个");
		}
		if ((y < 1) || (y > 5)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "二级菜单1-5个");
		}
	}

}
