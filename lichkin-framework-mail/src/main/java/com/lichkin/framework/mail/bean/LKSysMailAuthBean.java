package com.lichkin.framework.mail.bean;

import java.io.Serializable;

import javax.mail.Authenticator;

/**
 * 邮件认证器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKSysMailAuthBean extends Authenticator implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -189824962651926398L;

	/** 用户名 */
	private final String userName;

	/** 密码 */
	private final String password;


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	/**
	 * 构造方法
	 * @param userName 用户名
	 * @param password 密码
	 */
	public LKSysMailAuthBean(final String userName, final String password) {
		this.userName = userName;
		this.password = password;
	}

}