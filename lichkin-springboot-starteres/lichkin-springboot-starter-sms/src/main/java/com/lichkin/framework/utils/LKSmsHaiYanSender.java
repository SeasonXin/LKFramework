package com.lichkin.framework.utils;

import static com.lichkin.framework.statics.LKSmsApiUrls.SMS_HAIYAN_SEND_URL;
import static com.lichkin.framework.statics.LKSmsProperties.SMS_HAIYAN_ENCODING;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 海岩短信发送工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSmsHaiYanSender {

	/** 单例 */
	private static LKSmsHaiYanSender instance;


	/**
	 * 构造方法
	 */
	private LKSmsHaiYanSender() {
	}


	/**
	 * 获取单例
	 * @return 单例
	 */
	public static synchronized LKSmsHaiYanSender getInstance() {
		if (instance == null) {
			instance = new LKSmsHaiYanSender();
		}
		return instance;
	}


	/**
	 * 发送短信
	 * @param cellphone 手机号码
	 * @param content 短信内容
	 * @return 发送结果
	 * @throws Exception 建立链接或输出流时可能抛出异常
	 */
	public String doSendSms(final String cellphone, final String content) throws Exception {
		final StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			final StringBuilder sendUrl = new StringBuilder();
			sendUrl.append(SMS_HAIYAN_SEND_URL);
			sendUrl.append("&mobile=").append(cellphone);
			sendUrl.append("&content=").append(URLEncoder.encode(content, SMS_HAIYAN_ENCODING));

			final URL url = new URL(sendUrl.toString());
			final HttpURLConnection URLConn = (HttpURLConnection) url.openConnection();

			URLConn.setDoInput(true);
			URLConn.setDoOutput(true);
			URLConn.connect();
			URLConn.getOutputStream().flush();
			in = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), SMS_HAIYAN_ENCODING));

			for (String line = in.readLine(); line != null;) {
				result.append(line).append("\r\n");
				line = in.readLine();
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
				in = null;

			}
		}

		return result.toString();
	}

}
