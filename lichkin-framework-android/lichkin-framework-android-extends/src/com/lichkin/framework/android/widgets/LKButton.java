package com.lichkin.framework.android.widgets;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.utils.LKResourceUtils;

/**
 * 按钮
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKButton {

	/** 按钮文本 */
	private final String btnText;

	/** 按钮点击回调方法 */
	private final LKCallback onClicked;


	/**
	 * 构造方法
	 * @param btnText 按钮文本
	 * @param onClicked 按钮点击回调方法
	 */
	public LKButton(final String btnText, final LKCallback onClicked) {
		this.btnText = btnText;
		this.onClicked = onClicked;
	}


	/**
	 * 构造方法
	 * @param onClicked 按钮点击回调方法
	 */
	public LKButton(final LKCallback onClicked) {
		this(LKResourceUtils.getString(R.string.btn_ok_text), onClicked);
	}


	/**
	 * 获取按钮文本
	 * @return 按钮文本
	 */
	public String getBtnText() {
		return btnText;
	}


	/**
	 * 获取按钮点击回调方法
	 * @return 按钮点击回调方法
	 */
	public LKCallback getButtonClickedCallback() {
		return onClicked;
	}


	/**
	 * 按钮点击事件
	 */
	public void onClicked() {
		if (onClicked != null) {
			onClicked.callback();
		}
	}

}
