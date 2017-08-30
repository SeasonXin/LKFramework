package com.lichkin.framework.android.widgets.webview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lichkin.framework.android.utils.LKLogUtils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint({ "SetJavaScriptEnabled", "NewApi" })
public class LKWVJBWebViewClient extends WebViewClient {

	private static final String kInterface = "WVJBInterface";

	protected WebView webView;

	private ArrayList<LKWVJBMessage> startupMessageQueue = null;

	private Map<String, LKWVJBResponseCallback> responseCallbacks = null;

	private Map<String, LKWVJBHandler> messageHandlers = null;

	private long uniqueId = 0;

	private final LKWVJBHandler messageHandler;

	private final LKWVJBJSCallbackCollection jsCallbacks = new LKWVJBJSCallbackCollection();


	public LKWVJBWebViewClient(final WebView webView, final LKWVJBHandler messageHandler) {
		this.webView = webView;
		this.webView.getSettings().setJavaScriptEnabled(true);
		this.webView.addJavascriptInterface(jsCallbacks, kInterface);
		responseCallbacks = new HashMap<>();
		messageHandlers = new HashMap<>();
		startupMessageQueue = new ArrayList<>();
		this.messageHandler = messageHandler;

		registerHandler("log", new LKWVJBHandler() {

			@Override
			public void request(final Object data, final LKWVJBResponseCallback callback) {
				try {
					LKLogUtils.d(((JSONObject) data).getString("data"));
				} catch (final JSONException e) {
					e.printStackTrace();
				}
				try {
					if (callback != null) {
						callback.callback(((JSONObject) data).get("data"));
					}
				} catch (final JSONException e) {
					e.printStackTrace();
				}
			}

		});
	}


	public void callHandler(final String handlerName, final Object data, final LKWVJBResponseCallback responseCallback) {
		if ((data == null) && ((handlerName == null) || (handlerName.length() == 0))) {
			return;
		}
		final LKWVJBMessage message = new LKWVJBMessage();
		if (data != null) {
			message.data = data;
		}
		if (responseCallback != null) {
			final String callbackId = "objc_cb_" + (++uniqueId);
			responseCallbacks.put(callbackId, responseCallback);
			message.callbackId = callbackId;
		}
		if (handlerName != null) {
			message.handlerName = handlerName;
		}
		queueMessage(message);
	}


	public void registerHandler(final String handlerName, final LKWVJBHandler handler) {
		if ((handlerName == null) || (handlerName.length() == 0) || (handler == null)) {
			return;
		}
		messageHandlers.put(handlerName, handler);
	}


	private void queueMessage(final LKWVJBMessage message) {
		if (startupMessageQueue != null) {
			startupMessageQueue.add(message);
		} else {
			dispatchMessage(message);
		}
	}


	private void dispatchMessage(final LKWVJBMessage message) {
		final String messageJSON = message.toJSON();
		LKLogUtils.i("WVJB_SEND: " + messageJSON);
		executeJavascript("WebViewJavascriptBridge._handleMessageFromObjC('" + messageJSON + "');", null);
	}


	private void flushMessageQueue() {
		final String script = "WebViewJavascriptBridge._fetchQueue()";
		executeJavascript(script, new LKWVJBJSCallback() {

			@Override
			public void onReceiveValue(final String messageQueueString) {
				if ((messageQueueString == null) || (messageQueueString.length() == 0)) {
					return;
				}
				processQueueMessage(messageQueueString);
			}

		});
	}


	private void processQueueMessage(final String messageQueueString) {
		try {
			final JSONArray messages = new JSONArray(messageQueueString);
			for (int i = 0; i < messages.length(); i++) {
				final JSONObject jo = messages.getJSONObject(i);
				LKLogUtils.i("WVJB_RECEIVED: " + jo.toString());
				final LKWVJBMessage message = new LKWVJBMessage(jo);
				if (message.responseId != null) {
					final LKWVJBResponseCallback responseCallback = responseCallbacks.remove(message.responseId);
					if (responseCallback != null) {
						responseCallback.callback(message.responseData);
					}
				} else {
					LKWVJBResponseCallback responseCallback = null;
					if (message.callbackId != null) {
						final String callbackId = message.callbackId;
						responseCallback = new LKWVJBResponseCallback() {

							@Override
							public void callback(final Object data) {
								final LKWVJBMessage msg = new LKWVJBMessage();
								msg.responseId = callbackId;
								msg.responseData = data;
								queueMessage(msg);
							}

						};
					}

					LKWVJBHandler handler;
					if (message.handlerName != null) {
						handler = messageHandlers.get(message.handlerName);
					} else {
						handler = messageHandler;
					}
					if (handler != null) {
						handler.request(message.data, responseCallback);
					}
				}
			}
		} catch (final JSONException e) {
			e.printStackTrace();
		}
	}


	public void executeJavascript(final String script, final LKWVJBJSCallback callback) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			webView.evaluateJavascript(script, new ValueCallback<String>() {

				@Override
				public void onReceiveValue(String value) {
					if (callback != null) {
						if ((value != null) && value.startsWith("\"") && value.endsWith("\"")) {
							value = value.substring(1, value.length() - 1).replaceAll("\\\\", "");
						}
						callback.onReceiveValue(value);
					}
				}

			});
		} else {
			if (callback != null) {
				jsCallbacks.addCallback(++uniqueId + "", callback);
				webView.loadUrl("javascript:window." + kInterface + ".onResultForScript(" + uniqueId + "," + script + ")");
			} else {
				webView.loadUrl("javascript:" + script);
			}
		}
	}


	/** 脚本内容 */
	private static final String JS = "(function(){if(window.WebViewJavascriptBridge){return}var b;var i=[];var p=[];var g={};var d=\"wvjbscheme\";var a=\"__WVJB_QUEUE_MESSAGE__\";var c={};var k=1;function r(t){b=t.createElement(\"iframe\");b.style.display=\"none\";t.documentElement.appendChild(b)}function o(v){if(WebViewJavascriptBridge._messageHandler){throw new Error(\"WebViewJavascriptBridge.init called twice\")}WebViewJavascriptBridge._messageHandler=v;var t=p;p=null;for(var u=0;u<t.length;u++){q(t[u])}}function h(u,t){if(typeof u==\"string\"){u={data:u}}m({data:u},t)}function f(t,u){g[t]=u}function e(t,v,u){m({handlerName:t,data:v},u)}function m(u,t){if(t){var v=\"cb_\"+(k++)+\"_\"+new Date().getTime();c[v]=t;u[\"callbackId\"]=v}i.push(u);b.src=d+\"://\"+a}function j(){var t=JSON.stringify(i);i=[];return t}function q(t){setTimeout(function u(){var z=JSON.parse(t);var y;if(z.responseId){var x=c[z.responseId];if(!x){return}x(z.responseData);delete c[z.responseId]}else{var x;if(z.callbackId){var A=z.callbackId;x=function(B){m({responseId:A,responseData:B})}}var w=WebViewJavascriptBridge._messageHandler;if(z.handlerName){w=g[z.handlerName]}try{w(z.data,x)}catch(v){}}})}function n(t){if(p){p.push(t)}else{q(t)}}window.WebViewJavascriptBridge={init:o,send:h,registerHandler:f,callHandler:e,_fetchQueue:j,_handleMessageFromObjC:n};var s=document;r(s);var l=s.createEvent(\"Events\");l.initEvent(\"WebViewJavascriptBridgeReady\");l.bridge=WebViewJavascriptBridge;s.dispatchEvent(l)})();";


	@Override
	public void onPageFinished(final WebView view, final String url) {
		// TODO 读取文件的方式在jar包中是搜索不到的，有待解决方案，改用直接定义。
		// try {
		// final InputStream is = webView.getContext().getAssets().open("WebViewJavascriptBridge.js.txt");
		// final int size = is.available();
		// final byte[] buffer = new byte[size];
		// is.read(buffer);
		// is.close();
		// final String js = new String(buffer);
		// executeJavascript(js);
		// } catch (final IOException e) {
		// e.printStackTrace();
		// }

		// 替换代码
		executeJavascript(JS, null);

		if (startupMessageQueue != null) {
			for (int i = 0; i < startupMessageQueue.size(); i++) {
				dispatchMessage(startupMessageQueue.get(i));
			}
			startupMessageQueue = null;
		}
		super.onPageFinished(view, url);
	}


	@Override
	public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
		if (url.startsWith("wvjbscheme")) {
			if (url.indexOf("__WVJB_QUEUE_MESSAGE__") > 0) {
				flushMessageQueue();
			}
			return true;
		}
		return super.shouldOverrideUrlLoading(view, url);
	}

}
