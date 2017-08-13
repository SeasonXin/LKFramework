package com.lichkin.framework.android.activities;

import android.app.Activity;
import android.os.Bundle;

/**
 * 基本页面
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKActivity extends Activity {

	/** 页面上下文 */
	protected Activity ctx;


	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
	}

}
