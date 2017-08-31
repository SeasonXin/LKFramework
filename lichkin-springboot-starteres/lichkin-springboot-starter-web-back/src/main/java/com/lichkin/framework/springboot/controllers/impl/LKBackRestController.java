package com.lichkin.framework.springboot.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.bases.entities.LKMenuInterface;
import com.lichkin.framework.springboot.controllers.LKController;
import com.lichkin.framework.springboot.services.LKLoginService;
import com.lichkin.framework.springboot.web.LKSessionUser;

/**
 * 后台基本业务逻辑控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@RestController
public class LKBackRestController extends LKController {

	@Autowired
	private LKLoginService service;


	/**
	 * 登录
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 成功返回SUCCESS，否则返回ERROR。
	 */
	@WithOutLogin
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String doLogin(final LKDatas requestDatas) {
		session.setAttribute(LKSessionUser.SESSION_USER, service.doLogin(requestDatas));
		return SUCCESS;
	}


	/**
	 * 登出
	 * @return 成功返回SUCCESS，否则返回ERROR。
	 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String toLogout() {
		session.removeAttribute(LKSessionUser.SESSION_USER);
		return SUCCESS;
	}


	/**
	 * 获取菜单列表
	 * @return 菜单列表
	 */
	@RequestMapping(value = "getMenu.do", method = RequestMethod.POST)
	public List<? extends LKMenuInterface> getMenu() {
		return ((LKSessionUser) session.getAttribute(LKSessionUser.SESSION_USER)).getListMenu();
	}

}
