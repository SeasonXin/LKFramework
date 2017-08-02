package com.lichkin.framework.springboot.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.entities.LKMenuInterface;
import com.lichkin.framework.bases.entities.LKRoleInterface;
import com.lichkin.framework.bases.entities.LKUserInterface;
import com.lichkin.framework.bases.entities.LKUserLoginInterface;
import com.lichkin.framework.bases.enums.LKLoginChannelEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录信息类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public final class LKSessionUser implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -4792142807315997203L;

	/** 会话用户 */
	public static final String SESSION_USER = "sessionUser";

	/** 是否登录 */
	private boolean loginFlag = false;

	/** 角色信息 */
	private List<? extends LKRoleInterface> listRole = new ArrayList<>();

	/** 菜单信息 */
	private List<? extends LKMenuInterface> listMenu = new ArrayList<>();

	/** 业务参数 */
	private LKDatas businessParams;

	/** 登录渠道 */
	private LKLoginChannelEnum loginChannel = LKLoginChannelEnum.WEB;

	/** 用户信息 */
	private LKUserInterface user;

	/** 登录信息 */
	private LKUserLoginInterface userLogin;


	/**
	 * 获取当前登录人信息
	 * @return 当前登录人信息
	 */
	public static LKSessionUser getSessionUser() {
		final Object sessionUser = RequestContextHolder.getRequestAttributes().getAttribute(LKSessionUser.SESSION_USER, RequestAttributes.SCOPE_SESSION);

		if (sessionUser == null) {
			return null;
		}

		return (LKSessionUser) sessionUser;
	}


	/**
	 * 判断是否已经登录
	 * @return 已经登录返回true，否则返回false。
	 */
	public static boolean isLogin() {
		final LKSessionUser sessionUser = LKSessionUser.getSessionUser();

		if (sessionUser == null) {
			return false;
		}

		return sessionUser.loginFlag;
	}


	/**
	 * 获取当前登录人登录Id
	 * @return 当前登录人登录Id
	 */
	public static String getLoginId() {
		final LKSessionUser sessionUser = LKSessionUser.getSessionUser();

		if (sessionUser == null) {
			return "GUEST";
		}

		final LKUserLoginInterface userLogin = sessionUser.getUserLogin();
		if (userLogin == null) {
			return "GUEST";
		}

		return userLogin.getId();
	}


	/**
	 * 获取当前登录人姓名
	 * @return 当前登录人姓名
	 */
	public static String getUserName() {
		final LKSessionUser sessionUser = LKSessionUser.getSessionUser();

		if (sessionUser == null) {
			return "GUEST";
		}

		final LKUserInterface userInfo = sessionUser.getUser();
		if (userInfo == null) {
			return "GUEST";
		}

		return userInfo.getUserName();
	}

}
