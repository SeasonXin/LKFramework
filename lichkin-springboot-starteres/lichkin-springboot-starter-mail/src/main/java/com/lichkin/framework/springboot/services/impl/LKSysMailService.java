package com.lichkin.framework.springboot.services.impl;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.mail.bean.LKSysMailInfoBean;
import com.lichkin.framework.mail.utils.LKMailSender;
import com.lichkin.framework.springboot.entities.impl.SysMailLogEntity;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.utils.security.md5.LKMD5Encrypter;

/**
 * 邮件服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKSysMailService extends LKDBService {

	/**
	 * 发送邮件
	 * @param mailInfo 邮件信息
	 * @param threaded true：主线程内运行；false：多线程运行。
	 */
	@Transactional
	public void sendMail(final LKSysMailInfoBean mailInfo, final boolean threaded) {
		// 保存邮件
		final SysMailLogEntity mail = new SysMailLogEntity();
		mail.setFromAddress(mailInfo.getFromAddress());
		mail.setSubject(mailInfo.getSubject());
		mail.setContent(mailInfo.getContent());
		mail.setTos(mailInfo.getTo());
		mail.setCcs(mailInfo.getCc());
		mail.setBccs(mailInfo.getBcc());
		mail.setAttachments(mailInfo.getAttachment());
		mail.setSendTime(DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn()));
		mail.setCheckCode(LKMD5Encrypter.encrypt(mail.getFromAddress() + mail.getTos() + mail.getCcs() + mail.getBccs() + mail.getSubject() + mail.getContent() + mail.getAttachments()));
		dao.save(mail);

		if (threaded) {
			try {
				// 发送邮件
				final boolean result = LKMailSender.getInstance().doSendMail(mailInfo);
				if (result) {
					logger.info("mail send success.");
				} else {
					throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "mail send failed.");
				}
			} catch (final Exception e) {
				logger.error(e);
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
			}
		} else {
			final Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						// 发送邮件
						final boolean result = LKMailSender.getInstance().doSendMail(mailInfo);
						if (result) {
							logger.info("mail send success.");
						} else {
							throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "mail send failed.");
						}
					} catch (final Exception e) {
						logger.error(e);
					}
				}

			});
			t.start();
		}
	}

}
