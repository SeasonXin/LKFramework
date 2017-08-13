package com.lichkin.framework.android.widgets;

import com.lichkin.framework.android.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * 加载对话框
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKLoadingDialog extends ProgressDialog {

	/** 消息 */
	private final String message;

	/** 启用返回关闭 */
	private boolean allowBackCancel = false;


	/**
	 * 构造方法
	 * @param context 环境上下文
	 */
	public LKLoadingDialog(final Context context) {
		super(context);
		message = "";
	}


	/**
	 * 构造方法
	 * @param context 环境上下文
	 * @param message 消息
	 */
	public LKLoadingDialog(final Context context, final String message) {
		super(context);
		this.message = message;
	}


	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_lk_loading_dialog);
		final TextView mTvMessage = (TextView) findViewById(R.id.layout_lk_loading_dialog_message);
		mTvMessage.setText(message);
		setCancelable(false);
	}


	@Override
	public boolean onKeyDown(final int keyCode, final KeyEvent event) {
		if (allowBackCancel) {
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				cancel();
			}
		}
		return super.onKeyDown(keyCode, event);
	}


	/**
	 * 设置启用返回关闭
	 */
	public LKLoadingDialog setAllowBackCancelOn() {
		allowBackCancel = true;
		return this;
	}


	/**
	 * 设置禁用用返回关闭
	 */
	public LKLoadingDialog setAllowBackCancelOff() {
		allowBackCancel = false;
		return this;
	}

}
