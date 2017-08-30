package com.lichkin.framework.android.activities;

import com.lichkin.framework.android.R;
import com.lichkin.framework.android.utils.LKAndroidUtils;
import com.lichkin.framework.android.utils.LKResourceUtils;
import com.lichkin.framework.android.widgets.webview.LKWVJBWebViewClient;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;

/**
 * webview基本页面
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@SuppressLint("SetJavaScriptEnabled")
public abstract class LKWebViewActivity extends LKActivity {

	private WebView webView;

	private LKWVJBWebViewClient webViewClient;


	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutViewId());

		webView = (WebView) findViewById(getWebViewId());

		// 计算webview高度
		final LayoutParams layoutParams = (LayoutParams) webView.getLayoutParams();
		final int topMargin = LKResourceUtils.getDimensionDpSize(R.dimen.lk_title_textSize);
		layoutParams.height = LKAndroidUtils.getScreenDispaly().getHeight() - topMargin;
		layoutParams.setMargins(0, topMargin, 0, 0);
		webView.setLayoutParams(layoutParams);

		// 设置webview相关属性
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebChromeClient(new WebChromeClient());
		webView.loadUrl(getUrl());
		webViewClient = new LKWVJBWebViewClient(webView, null);
		webView.setWebViewClient(webViewClient);
	}


	protected abstract int getLayoutViewId();


	protected abstract int getWebViewId();


	protected abstract String getUrl();

}
