package com.lichkin.framework.wechat.vo.config;

import java.util.ArrayList;
import java.util.List;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

import lombok.Getter;

/**
 * 微信菜单按钮
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class ListButton extends Button {

	/**
	 * 构造方法
	 * @param name 菜单名称
	 */
	public ListButton(final String name) {
		super("view", name);
	}


	/** 菜单按钮列表 */
	private final List<Button> sub_button = new ArrayList<>(5);


	/**
	 * 增加子按钮
	 * @param btn 子按钮
	 */
	public ListButton addSubButton(final Button btn) {
		// 二级菜单最多只有5个。
		if (sub_button.size() >= 5) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "二级菜单最多只有5个");
		}
		// 二级菜单只能是ViewButton或ClickButton。
		if (!((btn instanceof ViewButton) || (btn instanceof ClickButton))) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "二级菜单只能是ViewButton或ClickButton。");
		}
		sub_button.add(btn);
		return this;
	}


	@Override
	public void init(final int x, final int y) {
		super.init(x, y);
		for (int i = 0; i < sub_button.size(); i++) {
			final Button btn = sub_button.get(i);
			btn.init(x, i + 1);
		}
	}

}
