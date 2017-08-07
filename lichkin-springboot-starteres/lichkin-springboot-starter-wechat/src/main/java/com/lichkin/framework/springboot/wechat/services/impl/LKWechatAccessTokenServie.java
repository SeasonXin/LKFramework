package com.lichkin.framework.springboot.wechat.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.http.request.LKRequestUtils;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springboot.wechat.LKWechatProperties;
import com.lichkin.framework.springframework.entities.sys.wechat.SysWechatTokenEntity;
import com.lichkin.framework.utils.lang.json.LKJSONUtils;
import com.lichkin.framework.wechat.LKWechatApiUrls;

/**
 * 获得微信access_token服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKWechatAccessTokenServie extends LKDBService {

	/** 日志记录对象 */
	protected final Log LOGGER = LogFactory.getLog(getClass());

	/** 微信全局唯一票据 */
	private static String accessToken;

	/** 凭证有效时间，单位：秒 */
	private static int expiresIn;

	/** 获取凭证时间 */
	private static DateTime insertTime;


	/**
	 * 获取微信access_token
	 */
	@Transactional
	public String getAccessToken() {
		if (LKWechatProperties.WECHAT_DEBUG) {
			return "wechat_local_access_token";
		}
		if ((LKWechatAccessTokenServie.accessToken == null) || (DateTime.now().plusMinutes(3).isAfter(LKWechatAccessTokenServie.insertTime.plusSeconds(LKWechatAccessTokenServie.expiresIn)))) {
			try {
				final String jsonStr = LKRequestUtils.doRequest(LKWechatApiUrls.GET_ACCESS_TOKEN);
				LOGGER.info(jsonStr);

				final LKDatas datas = LKJSONUtils.toDatas(jsonStr);
				LKWechatAccessTokenServie.accessToken = datas.getString("access_token", null);
				LKWechatAccessTokenServie.expiresIn = datas.getInteger("expires_in", null);
				LKWechatAccessTokenServie.insertTime = DateTime.now();
				final Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						final SysWechatTokenEntity token = new SysWechatTokenEntity();
						token.setAccessToken(LKWechatAccessTokenServie.accessToken);
						token.setExpiresIn(LKWechatAccessTokenServie.expiresIn);
						token.setRequestTime(LKWechatAccessTokenServie.insertTime.toString(LKDatePatternEnum.STANDARD.getNameEn()));
						token.setTokenType((byte) 0);
						dao.save(token);
					}

				});
				thread.run();
			} catch (final Exception e) {
				LOGGER.error(e);
			}
		}
		return LKWechatAccessTokenServie.accessToken;
	}

}
