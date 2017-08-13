package com.lichkin.framework.android.widgets;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.utils.LKAndroidUtils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 提示信息对话框
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKAlertDialog extends Dialog {

	/** 安卓上下文 */
	private final Context ctx;

	/** 提示信息文本 */
	private final String text;

	/** 按钮 */
	private final LKButton btn;

	/** 禁用关闭 */
	private final boolean withOutCancel;


	/**
	 * 构造方法
	 * @param ctx 安卓上下文
	 * @param text 提示信息文本
	 * @param btn 按钮
	 * @param withOutCancel 禁用关闭
	 */
	public LKAlertDialog(final Context ctx, final String text, final LKButton btn, final boolean withOutCancel) {
		super(ctx, R.style.lk_alert_dialog_style);
		this.ctx = ctx;
		this.text = text;
		this.btn = btn;
		this.withOutCancel = withOutCancel;
	}


	@Override
	@SuppressLint("InflateParams")
	protected void onCreate(final Bundle savedInstanceState) {
		final LayoutInflater inflater = LayoutInflater.from(ctx);
		final View view = inflater.inflate(R.layout.layout_lk_alert_dialog, null);
		setContentView(view);

		final TextView tipTextView = (TextView) view.findViewById(R.id.alert_dialog_tip);
		tipTextView.setText(text);

		final TextView btnTextView = (TextView) view.findViewById(R.id.alert_dialog_btn);
		btnTextView.setText(btn.getBtnText());
		btnTextView.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				if (!withOutCancel) {
					LKAlertDialog.this.dismiss();
				}
				if (btn != null) {
					btn.onClicked();
				}
			}

		});

		final Window dialogWindow = getWindow();
		final WindowManager.LayoutParams params = dialogWindow.getAttributes();
		params.width = (int) (LKAndroidUtils.getScreenDispaly().getWidth() * 0.8);
		dialogWindow.setAttributes(params);

		setCancelable(false);
		super.onCreate(savedInstanceState);
	}

}