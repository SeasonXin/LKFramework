package com.lichkin.framework.mail.bean;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.statics.LKFrameworkStatics;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.file.LKFileReader;
import com.lichkin.framework.utils.file.LKFileUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 邮件信息
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKSysMailInfoBean implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -1413062954613090462L;

	/** 邮件主键 */
	private String busCode;

	/** 主机 */
	private String host;

	/** 端口 */
	private String port;

	/** 是否使用认证 */
	private boolean auth;

	/** 用户名 */
	private String userName;

	/** 密码 */
	private String password;

	/** 发件人地址 */
	private String fromAddress;

	/** 发件人显示名 */
	private String fromDisplayName;

	/** 收件人 */
	private String to;

	/** 抄送人 */
	private String cc;

	/** 暗送人 */
	private String bcc;

	/** 附件 */
	private String attachment;

	/** 主题 */
	private String subject;

	/** 内容 */
	private String content;

	/** 内容临时变量 */
	private String contentTmp;

	/** 内容路径 */
	private String contentPath;

	/** 发件人 */
	private InternetAddress from;

	/** 收件人 */
	private InternetAddress[] tos = new InternetAddress[0];

	/** 抄送人 */
	private InternetAddress[] ccs = new InternetAddress[0];

	/** 暗送人 */
	private InternetAddress[] bccs = new InternetAddress[0];

	/** 附件 */
	private File[] attachments = new File[0];


	public String getBusCode() {
		return busCode;
	}


	public void setBusCode(final String busCode) {
		this.busCode = busCode;
	}


	public String getHost() {
		return host;
	}


	public void setHost(final String host) {
		this.host = host;
	}


	public String getPort() {
		return port;
	}


	public void setPort(final String port) {
		this.port = port;
	}


	public boolean isAuth() {
		return auth;
	}


	public void setAuth(final boolean auth) {
		this.auth = auth;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(final String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(final String password) {
		this.password = password;
	}


	public String getFromAddress() {
		return fromAddress;
	}


	public void setFromAddress(final String fromAddress) {
		this.fromAddress = fromAddress;
		initFrom();
	}


	public String getFromDisplayName() {
		return fromDisplayName;
	}


	public void setFromDisplayName(final String fromDisplayName) {
		this.fromDisplayName = fromDisplayName;
		initFrom();
	}


	public String getTo() {
		if (LKStringUtils.isBlank(to)) {
			if (ArrayUtils.isNotEmpty(tos)) {
				final StringBuilder sb = new StringBuilder();
				for (final InternetAddress obj : tos) {
					sb.append(obj.getAddress()).append(LKStringStatics.STR_COMMA);
				}
				return sb.toString();
			}
			return LKStringStatics.STR_EMPTY;
		}
		return to.replaceAll(LKFrameworkStatics.ARR_SPLITOR, LKStringStatics.STR_COMMA);
	}


	public void setTo(final String to) {
		this.to = to;
		if (LKStringUtils.isNotBlank(to)) {
			final String[] toArr = to.split(LKFrameworkStatics.ARR_SPLITOR);
			if (ArrayUtils.isNotEmpty(toArr)) {
				for (final String str : toArr) {
					addTo(str, str);
				}
			}
		}
	}


	public String getCc() {
		if (LKStringUtils.isBlank(cc)) {
			if (ArrayUtils.isNotEmpty(ccs)) {
				final StringBuilder sb = new StringBuilder();
				for (final InternetAddress obj : ccs) {
					sb.append(obj.getAddress()).append(LKStringStatics.STR_COMMA);
				}
				return sb.toString();
			}
			return LKStringStatics.STR_EMPTY;
		}
		return cc.replaceAll(LKFrameworkStatics.ARR_SPLITOR, LKStringStatics.STR_COMMA);
	}


	public void setCc(final String cc) {
		this.cc = cc;
		if (LKStringUtils.isNotBlank(cc)) {
			final String[] ccArr = cc.split(LKFrameworkStatics.ARR_SPLITOR);
			if (ArrayUtils.isNotEmpty(ccArr)) {
				for (final String str : ccArr) {
					addCc(str, str);
				}
			}
		}
	}


	public String getBcc() {
		if (LKStringUtils.isBlank(bcc)) {
			if (ArrayUtils.isNotEmpty(bccs)) {
				final StringBuilder sb = new StringBuilder();
				for (final InternetAddress obj : bccs) {
					sb.append(obj.getAddress()).append(LKStringStatics.STR_COMMA);
				}
				return sb.toString();
			}
			return LKStringStatics.STR_EMPTY;
		}
		return bcc.replaceAll(LKFrameworkStatics.ARR_SPLITOR, LKStringStatics.STR_COMMA);
	}


	public void setBcc(final String bcc) {
		this.bcc = bcc;
		if (LKStringUtils.isNotBlank(bcc)) {
			final String[] bccArr = bcc.split(LKFrameworkStatics.ARR_SPLITOR);
			if (ArrayUtils.isNotEmpty(bccArr)) {
				for (final String str : bccArr) {
					addBcc(str, str);
				}
			}
		}
	}


	public String getAttachment() {
		if (LKStringUtils.isBlank(attachment)) {
			if (ArrayUtils.isNotEmpty(attachments)) {
				final StringBuilder sb = new StringBuilder();
				for (final File obj : attachments) {
					sb.append(obj.getAbsolutePath()).append(LKStringStatics.STR_COMMA);
				}
				return sb.toString();
			}
			return LKStringStatics.STR_EMPTY;
		}
		return attachment.replaceAll(LKFrameworkStatics.ARR_SPLITOR, LKStringStatics.STR_COMMA);
	}


	public void setAttachment(final String attachment) {
		this.attachment = attachment;
		if (LKStringUtils.isNotBlank(attachment)) {
			final String[] attachmentArr = attachment.split(LKFrameworkStatics.ARR_SPLITOR);
			if (ArrayUtils.isNotEmpty(attachmentArr)) {
				for (final String str : attachmentArr) {
					final File file = LKFileUtils.getFile(str);
					if (file != null) {
						addAttachment(file);
					}
				}
			}
		}
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		if (LKStringUtils.isBlank(subject)) {
			subject = "NO SUBJECT";
		}
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		if (LKStringUtils.isBlank(contentPath)) {
			if (LKStringUtils.isBlank(content)) {
				content = LKStringStatics.STR_EMPTY;
			}
			this.content = content;
		} else {
			this.content = content + contentTmp;
		}
	}


	public String getContentPath() {
		return contentPath;
	}


	public void setContentPath(final String contentPath) {
		this.contentPath = contentPath;
		if (LKStringUtils.isNotBlank(contentPath)) {
			final String[] contentArr = LKFileReader.read(contentPath);
			if (ArrayUtils.isNotEmpty(contentArr)) {
				if (LKStringUtils.isBlank(content)) {
					content = LKStringStatics.STR_EMPTY;
				}
				for (final String str : contentArr) {
					content += str;
				}
				contentTmp = content;
			}
		}
	}


	public InternetAddress getFrom() {
		return from;
	}


	public InternetAddress[] getTos() {
		return tos;
	}


	public InternetAddress[] getCcs() {
		return ccs;
	}


	public InternetAddress[] getBccs() {
		return bccs;
	}


	public File[] getAttachments() {
		return attachments;
	}


	/**
	 * 初始化发件人
	 */
	private void initFrom() {
		if (LKStringUtils.isNotBlank(fromAddress) && LKStringUtils.isNotBlank(fromDisplayName)) {
			try {
				from = new InternetAddress(fromAddress, fromDisplayName);
			} catch (final UnsupportedEncodingException e) {
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "from address is unsupported encoding.");
			}
		}
	}


	/**
	 * 初始化发件人
	 * @param fromAddress 发件人地址
	 * @param fromDisplayName 发件人显示名
	 */
	public void initFrom(final String fromAddress, final String fromDisplayName) {
		this.fromAddress = fromAddress;
		this.fromDisplayName = fromDisplayName;
		initFrom();
	}


	/**
	 * 重新设置内容
	 * @param content 内容
	 */
	public void resetContent(final String content) {
		this.content = content;
	}


	/**
	 * 增加收件人
	 * @param toAddress 收件人地址
	 * @param toDisplayName 收件人显示名
	 */
	public void addTo(final String toAddress, final String toDisplayName) {
		try {
			final InternetAddress to = new InternetAddress(toAddress, toDisplayName);
			tos = (ArrayUtils.add(tos, to));
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "to address is unsupported encoding.");
		}
	}


	/**
	 * 增加抄送人
	 * @param ccAddress 抄送人地址
	 * @param ccDisplayName 抄送人显示名
	 */
	public void addCc(final String ccAddress, final String ccDisplayName) {
		try {
			final InternetAddress cc = new InternetAddress(ccAddress, ccDisplayName);
			ccs = (ArrayUtils.add(ccs, cc));
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "cc address is unsupported encoding.");
		}
	}


	/**
	 * 增加暗送人
	 * @param bccAddress 暗送人地址
	 * @param bccDisplayName 暗送人显示名
	 */
	public void addBcc(final String bccAddress, final String bccDisplayName) {
		try {
			final InternetAddress bcc = new InternetAddress(bccAddress, bccDisplayName);
			bccs = (ArrayUtils.add(bccs, bcc));
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "bcc address is unsupported encoding.");
		}
	}


	/**
	 * 增加附件
	 * @param filePath 附件
	 */
	public void addAttachment(final File filePath) {
		attachments = (ArrayUtils.add(attachments, filePath));
	}

}
