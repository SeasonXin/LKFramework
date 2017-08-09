package com.lichkin.framework.springboot.services.impl;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.beans.LKHexMessage;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.http.request.LKRequestUtils;
import com.lichkin.framework.springboot.entities.impl.SysWechatTokenEntity;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.lang.json.LKJSONUtils;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;
import com.lichkin.framework.wechat.vo.Signature;

/**
 * 获得微信jsapi_ticket服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKWechatJsTicketService extends LKDBService {

	/** 获得微信access_token服务类 */
	@Autowired
	private LKWechatAccessTokenServie lkWechatAccessTokenServie;

	/** 微信JS全局唯一票据 */
	private static String ticket;

	/** 凭证有效时间，单位：秒 */
	private static int expiresIn;

	/** 获取凭证时间 */
	private static DateTime insertTime;


	/**
	 * 获取微信jsapi_ticket
	 */
	@Transactional
	public String getJsTicket() {
		if (LKWechatConfigStatics.debug) {
			return "wechat_local_jsapi_ticket";
		}
		if ((LKWechatJsTicketService.ticket == null) || (DateTime.now().plusMinutes(3).isAfter(LKWechatJsTicketService.insertTime.plusSeconds(LKWechatJsTicketService.expiresIn)))) {
			try {
				final String jsonStr = LKRequestUtils.doRequest(LKStringUtils.replaceDatas(LKWechatConfigStatics.getJsTicketUrl, new LKDatas().put("#access_token", lkWechatAccessTokenServie.getAccessToken())));
				logger.info(jsonStr);

				final LKDatas datas = LKJSONUtils.toDatas(jsonStr);
				if ("0".equals(datas.getString("errcode", null))) {
					LKWechatJsTicketService.ticket = datas.getString("ticket", null);
					LKWechatJsTicketService.expiresIn = datas.getInteger("expires_in", null);
					LKWechatJsTicketService.insertTime = DateTime.now();
					final Thread thread = new Thread(new Runnable() {

						@Override
						public void run() {
							final SysWechatTokenEntity token = new SysWechatTokenEntity();
							token.setAccessToken(LKWechatJsTicketService.ticket);
							token.setExpiresIn(LKWechatJsTicketService.expiresIn);
							token.setRequestTime(LKWechatJsTicketService.insertTime.toString(LKDatePatternEnum.STANDARD.getNameEn()));
							token.setTokenType((byte) 1);
							dao.save(token);
						}

					});
					thread.run();
				}
			} catch (final Exception e) {
				logger.error(e);
			}
		}
		return LKWechatJsTicketService.ticket;
	}


	/**
	 * 获取签名
	 * @param url 请求路径
	 * @return 签名
	 */
	@Transactional
	public Signature getSignature(final String url) {
		final String jsapiTicket = getJsTicket();
		final String nonceStr = UUID.randomUUID().toString();
		final String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		final String signature = new LKHexMessage(DigestUtils.sha1("jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url)).getMessage();

		final Signature sign = new Signature();
		sign.setAppid(LKWechatConfigStatics.appid);
		sign.setJsapiTicket(jsapiTicket);
		sign.setNonceStr(nonceStr);
		sign.setSignature(signature);
		sign.setTimestamp(timestamp);
		sign.setUrl(url);

		return sign;
	}

}
