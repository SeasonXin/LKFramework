package com.lichkin.framework.wechat.vo.config;

import java.util.ArrayList;
import java.util.List;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

import lombok.Getter;

/**
 * 微信菜单
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class Menu {

	/** 菜单按钮列表 */
	private final List<Button> button = new ArrayList<>(3);


	/**
	 * 增加按钮
	 * @param btn 按钮
	 */
	public void addButton(final Button btn) {
		// 一级菜单最多只有3个。
		if (button.size() >= 3) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "一级菜单最多只有3个");
		}

		// 初始化按钮
		btn.init(button.size() + 1, 1);

		// 将按钮加到菜单中
		button.add(btn);
	}


	/**
	 * 转换为二维数组
	 * @return 二维数组
	 */
	public Button[][] toTDArray() {
		final Button[][] tdArray = new Button[3][6];
		for (int x = 0; x < button.size(); x++) {
			final Button btnX = button.get(x);
			tdArray[x][0] = btnX;
			if (btnX instanceof ListButton) {
				// 列表菜单则遍历二级菜单。
				final List<Button> listSubButton = ((ListButton) btnX).getSub_button();
				for (int y = 0; y < listSubButton.size(); y++) {
					final Button btnY = listSubButton.get(y);
					tdArray[x][y + 1] = btnY;
				}
			}
		}
		return tdArray;
	}

}
