package com.lichkin.framework.android.utils;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.widgets.LKAlertDialog;
import com.lichkin.framework.android.widgets.LKButton;
import com.lichkin.framework.android.widgets.LKCallback;
import com.lichkin.framework.android.widgets.LKConfirmDialog;
import com.lichkin.framework.android.widgets.LKLoadingDialog;

import android.content.Context;
import android.widget.Toast;

/**
 * 对话框
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKDialogUtils {

	/**
	 * 显示提示信息
	 * @param text 提示文本
	 * @param duration 停留时间
	 */
	public static void showToast(final CharSequence text, final int duration) {
		Toast.makeText(LKAndroidUtils.getApp(), text, duration).show();
	}


	/**
	 * 显示提示信息
	 * @param text 提示文本
	 */
	public static void showToast(final CharSequence text) {
		showToast(text, Toast.LENGTH_SHORT);
	}


	/**
	 * 弹出提示信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param btn 按钮
	 */
	public static void alert(final Context ctx, final String text, final LKButton btn) {
		new LKAlertDialog(ctx, text, btn, false).show();
	}


	/**
	 * 弹出提示信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param btn 按钮
	 */
	public static void alertWithOutCancel(final Context ctx, final String text, final LKButton btn) {
		new LKAlertDialog(ctx, text, btn, true).show();
	}


	/**
	 * 弹出提示信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param callback 回调方法
	 */
	public static void alert(final Context ctx, final String text, final LKCallback callback) {
		new LKAlertDialog(ctx, text, new LKButton(callback), false).show();
	}


	/**
	 * 弹出提示信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 */
	public static void alert(final Context ctx, final String text) {
		new LKAlertDialog(ctx, text, new LKButton(null), false).show();
	}


	/**
	 * 弹出确认信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param btnOk 确认按钮
	 * @param btnCancel 取消按钮
	 */
	public static void confirm(final Context ctx, final String text, final LKButton btnOk, final LKButton btnCancel) {
		new LKConfirmDialog(ctx, text, btnOk, btnCancel).show();
	}


	/**
	 * 弹出确认信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param btnOkCallback 确认按钮回调方法
	 * @param btnCancelCallback 取消按钮回调方法
	 */
	public static void confirm(final Context ctx, final String text, final LKCallback btnOkCallback, final LKCallback btnCancelCallback) {
		new LKConfirmDialog(ctx, text, new LKButton(LKResourceUtils.getString(R.string.btn_ok_text), btnOkCallback), new LKButton(LKResourceUtils.getString(R.string.btn_cancel_text), btnCancelCallback)).show();
	}


	/**
	 * 弹出确认信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 * @param btnOkCallback 确认按钮回调方法
	 */
	public static void confirm(final Context ctx, final String text, final LKCallback btnOkCallback) {
		new LKConfirmDialog(ctx, text, new LKButton(LKResourceUtils.getString(R.string.btn_ok_text), btnOkCallback), new LKButton(LKResourceUtils.getString(R.string.btn_cancel_text), null)).show();
	}


	/**
	 * 弹出确认信息对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 */
	public static void confirm(final Context ctx, final String text) {
		new LKConfirmDialog(ctx, text, new LKButton(LKResourceUtils.getString(R.string.btn_ok_text), null), new LKButton(LKResourceUtils.getString(R.string.btn_cancel_text), null)).show();
	}


	/**
	 * 弹出加载对话框
	 * @param ctx 安卓上下文
	 * @param text 提示文本
	 */
	public static LKLoadingDialog loading(final Context ctx, final String text) {
		final LKLoadingDialog lkLoadingDialog = new LKLoadingDialog(ctx, text);
		lkLoadingDialog.show();
		return lkLoadingDialog;
	}

}
