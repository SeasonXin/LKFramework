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
 * 确认信息对话框
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKConfirmDialog extends Dialog {

	/** 安卓上下文 */
	private final Context ctx;

	/** 提示信息文本 */
	private final String text;

	/** 确认按钮 */
	private final LKButton btnOk;

	/** 取消按钮 */
	private final LKButton btnCancel;


	/**
	 * 构造方法
	 * @param ctx 安卓上下文
	 * @param text 提示信息文本
	 * @param btnOk 确认按钮
	 * @param btnCancel 取消按钮
	 */
	public LKConfirmDialog(final Context ctx, final String text, final LKButton btnOk, final LKButton btnCancel) {
		super(ctx, R.style.lk_alert_dialog_style);
		this.ctx = ctx;
		this.text = text;
		this.btnOk = btnOk;
		this.btnCancel = btnCancel;
	}


	@Override
	@SuppressLint("InflateParams")
	protected void onCreate(final Bundle savedInstanceState) {
		final LayoutInflater inflater = LayoutInflater.from(ctx);
		final View view = inflater.inflate(R.layout.layout_lk_confirm_dialog, null);
		setContentView(view);

		final TextView tipTextView = (TextView) view.findViewById(R.id.confirm_dialog_tip);
		tipTextView.setText(text);

		final TextView btnOkTextView = (TextView) view.findViewById(R.id.confirm_dialog_btn_ok);
		btnOkTextView.setText(btnOk.getBtnText());
		btnOkTextView.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				LKConfirmDialog.this.dismiss();
				if (btnOk != null) {
					btnOk.onClicked();
				}
			}

		});

		final TextView btnCancelTextView = (TextView) view.findViewById(R.id.confirm_dialog_btn_cancel);
		btnCancelTextView.setText(btnCancel.getBtnText());
		btnCancelTextView.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				LKConfirmDialog.this.dismiss();
				if (btnCancel != null) {
					btnCancel.onClicked();
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