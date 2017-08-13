package com.lichkin.framework.android.activities;

import java.util.List;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.beans.LKBtnBean;
import com.lichkin.framework.android.beans.LKScreenBean;
import com.lichkin.framework.android.utils.LKAndroidUtils;
import com.lichkin.framework.android.utils.LKDialogUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 按钮列表页面
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBtnListActivity extends LKActivity {

	/**
	 * 初始化按钮列表
	 * @param listBtns 按钮列表
	 * @param layoutId 填充到的layoutId
	 * @param divide 每行展现的按钮数量
	 * @param aspectRatio 按钮的宽高比
	 */
	@SuppressLint("InflateParams")
	protected void init(final List<LKBtnBean> listBtns, final int layoutId, final int divide, final float aspectRatio) {
		final LinearLayout container = (LinearLayout) findViewById(layoutId);
		final LayoutInflater inflater = getLayoutInflater();

		final int screenWidth = LKAndroidUtils.getScreenDispaly().getWidth(); // 取屏幕宽度
		final float dpTopxRatio = LKAndroidUtils.getDpTopxRatio(); // 取屏幕像素比例

		final int leftRightMargin = screenWidth / 32; // 左右边距，将屏幕分成32份，留边。
		final int btnMaring = leftRightMargin / 2; // 按钮边距等于左右边距的四分之一
		final float lineWidth = (float) screenWidth - (leftRightMargin * 2); // 行宽需去掉左右边距
		final float btnWidth = (lineWidth - (btnMaring * (divide - 1))) / divide; // 行宽 = (按钮个数 * 按钮宽度) + ((按钮个数 - 1) * 按钮间距)
		final float btnHeight = btnWidth / aspectRatio; // 按钮高度等于按钮宽度除以按钮的宽高比
		int btnTitleHeight = (int) (btnHeight / 5); // 按钮标题高度
		float btnTitleTextSize = (btnTitleHeight / dpTopxRatio) - 1; // 按钮标题高度 = (按钮标题字体大小 + 1) * 屏幕像素比例
		if (btnTitleTextSize < 12) {
			btnTitleTextSize = 12;
			btnTitleHeight = (int) ((btnTitleTextSize + 1) * dpTopxRatio);
		}
		if (btnTitleTextSize > 24) {
			btnTitleTextSize = 24;
			btnTitleHeight = (int) ((btnTitleTextSize + 1) * dpTopxRatio);
		}
		final int btnImgHeight = (int) (btnHeight - btnTitleHeight); // 按钮图标高度

		// 行样式
		final LinearLayout.LayoutParams lineLayoutParams = new LinearLayout.LayoutParams((int) lineWidth, (int) btnHeight);
		lineLayoutParams.setMargins(leftRightMargin, btnMaring, 0, 0);

		// 动态添加按钮
		LinearLayout lineLayout = null;
		for (int i = 0; i < listBtns.size(); i++) {
			final LKBtnBean btn = listBtns.get(i);
			// 按钮样式
			final LinearLayout.LayoutParams btnLayoutParams = new LinearLayout.LayoutParams((int) btnWidth, (int) btnHeight);
			if ((i % divide) == 0) {// 每divide个创建一行
				lineLayout = new LinearLayout(getApplicationContext());
				lineLayout.setOrientation(LinearLayout.HORIZONTAL);
				lineLayout.setLayoutParams(lineLayoutParams);
				container.addView(lineLayout);
			} else {
				btnLayoutParams.setMargins(btnMaring, 0, 0, 0);
			}

			final FrameLayout btnListLayout = (FrameLayout) inflater.inflate(R.layout.layout_lk_btn_list, null);
			btnListLayout.setLayoutParams(btnLayoutParams);

			final ImageView btnImgView = (ImageView) btnListLayout.findViewById(R.id.lk_btn_list_btn_img);
			btnImgView.setImageResource(btn.getBtnImgId());
			final LayoutParams imgLayoutParams = btnImgView.getLayoutParams();
			imgLayoutParams.width = imgLayoutParams.height = btnImgHeight;
			btnImgView.setLayoutParams(imgLayoutParams);

			final TextView btnTitleView = (TextView) btnListLayout.findViewById(R.id.lk_btn_list_btn_title);
			btnTitleView.setText(btn.getBtnTitle());
			btnTitleView.setTextSize(btnTitleTextSize);
			final LayoutParams btnTitleLayoutParams = btnTitleView.getLayoutParams();
			btnTitleLayoutParams.height = btnTitleHeight;
			btnTitleView.setLayoutParams(btnTitleLayoutParams);

			btnListLayout.setClickable(true);
			btnListLayout.setOnClickListener(new OnClickListener() {

				@SuppressLint("ShowToast")
				@Override
				public void onClick(final View v) {
					if (btn.getToActivityClass() == null) {
						LKDialogUtils.alert(ctx, LKResourceUtils.getString(R.string.module_wait_tip));
						return;
					}
					final Intent intent = new Intent(ctx, btn.getToActivityClass());
					startActivity(intent);
				}

			});

			lineLayout.addView(btnListLayout);
		}
	}


	/**
	 * 初始化按钮列表
	 * @param listBtns 按钮列表
	 * @param layoutId 填充到的layoutId
	 * @param divide 每行展现的按钮数量
	 */
	@SuppressLint("InflateParams")
	protected void init(final List<LKBtnBean> listBtns, final int layoutId, final int divide) {
		final LKScreenBean screen = LKAndroidUtils.getScreenDispaly();
		init(listBtns, layoutId, divide, (float) screen.getHeight() / screen.getWidth());
	}

}
