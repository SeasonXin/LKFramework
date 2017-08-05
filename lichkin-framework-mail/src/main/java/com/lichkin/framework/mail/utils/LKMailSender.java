package com.lichkin.framework.mail.utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.mail.bean.LKSysMailAuthBean;
import com.lichkin.framework.mail.bean.LKSysMailInfoBean;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 邮件发送工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKMailSender {

	/** 单例 */
	private static LKMailSender instance;


	/**
	 * 构造方法
	 */
	private LKMailSender() {
	}


	/**
	 * 获取单例
	 * @return 单例
	 */
	public static synchronized LKMailSender getInstance() {
		if (LKMailSender.instance == null) {
			LKMailSender.instance = new LKMailSender();
		}
		return LKMailSender.instance;
	}


	/**
	 * 发送邮件
	 * @param mailInfo 邮件信息
	 * @return 发送成功返回true，否则返回false。
	 */
	public boolean doSendMail(final LKSysMailInfoBean mailInfo) {
		Transport transport = null;
		try {
			LKSysMailAuthBean authenticator = null;
			if (mailInfo.isAuth()) {
				authenticator = new LKSysMailAuthBean(mailInfo.getUserName(), mailInfo.getPassword());
			}

			final Properties properties = new Properties();
			properties.put("mail.smtp.host", mailInfo.getHost());
			properties.put("mail.smtp.port", mailInfo.getPort());
			properties.put("mail.smtp.auth", mailInfo.isAuth());

			final Session session = Session.getDefaultInstance(properties, authenticator);
			transport = session.getTransport("smtp");
			transport.connect(mailInfo.getHost(), mailInfo.getUserName(), mailInfo.getPassword());
			final Message message = new MimeMessage(session);

			final Address from = mailInfo.getFrom();
			message.setFrom(from);

			final InternetAddress[] tos = mailInfo.getTos();
			message.setRecipients(Message.RecipientType.TO, tos);

			final InternetAddress[] ccs = mailInfo.getCcs();
			message.setRecipients(Message.RecipientType.CC, ccs);

			final InternetAddress[] bccs = mailInfo.getBccs();
			message.setRecipients(Message.RecipientType.BCC, bccs);

			message.setSubject(mailInfo.getSubject());

			message.setSentDate(new Date());

			final Multipart part = new MimeMultipart("related");
			final BodyPart bodyContent = new MimeBodyPart();
			final String content = mailInfo.getContent();
			if (LKStringUtils.isBlank(content)) {
				bodyContent.setContent("", "text/html;charset=UTF-8");
			} else {
				bodyContent.setContent(content, "text/html;charset=UTF-8");
			}
			part.addBodyPart(bodyContent);

			for (final File attachment : mailInfo.getAttachments()) {
				final BodyPart bodyAttachment = new MimeBodyPart();
				final FileDataSource fds = new FileDataSource(attachment);
				bodyAttachment.setDataHandler(new DataHandler(fds));
				bodyAttachment.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
				part.addBodyPart(bodyAttachment);
			}

			message.setContent(part);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (final Exception e) {
			e.printStackTrace();
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "mail not send.");
		} finally {
			if ((transport != null) && transport.isConnected()) {
				try {
					transport.close();
				} catch (final MessagingException e) {
				}
			}
			transport = null;
		}
		return true;
	}

}
