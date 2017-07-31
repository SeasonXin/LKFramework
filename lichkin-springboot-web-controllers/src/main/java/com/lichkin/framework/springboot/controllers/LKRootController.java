package com.lichkin.framework.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.bases.entities.LKMenuInterface;
import com.lichkin.framework.bases.statics.configs.LKWebPropertiesDefaultValues;
import com.lichkin.framework.springboot.services.LKRootService;
import com.lichkin.framework.springboot.web.LKSessionUser;
import com.lichkin.framework.springboot.web.LKWebProperties;
import com.lichkin.framework.springboot.web.controllers.LKController;

@Controller
public class LKRootController extends LKController {

	@Autowired
	private LKRootService service;


	/**
	 * 跳转到索引页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 索引页面模型视图
	 */
	@WithOutLogin
	@RequestMapping(value = LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_INDEX_URL, method = RequestMethod.GET)
	public ModelAndView toIndex(final LKDatas requestDatas) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (!(LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_INDEX_URL).equals(LKWebProperties.LK_WEB_PAGE_INDEX_URL)) {
			mv.setViewName("redirect:" + LKWebProperties.LK_WEB_PAGE_INDEX_URL);
		}
		return mv;
	}


	/**
	 * 跳转到登录页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 登录页面模型视图
	 */
	@WithOutLogin
	@RequestMapping(value = LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_LOGIN_URL, method = RequestMethod.GET)
	public ModelAndView toLogin(final LKDatas requestDatas) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (!(LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_LOGIN_URL).equals(LKWebProperties.LK_WEB_PAGE_LOGIN_URL)) {
			mv.setViewName("redirect:" + LKWebProperties.LK_WEB_PAGE_LOGIN_URL);
		}
		return mv;
	}


	/**
	 * 跳转到主页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 主页面模型视图
	 */
	@RequestMapping(value = LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_MAIN_URL, method = RequestMethod.GET)
	public ModelAndView toMain(final LKDatas requestDatas) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (!(LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_MAIN_URL).equals(LKWebProperties.LK_WEB_PAGE_MAIN_URL)) {
			mv.setViewName("redirect:" + LKWebProperties.LK_WEB_PAGE_MAIN_URL);
		}
		return mv;
	}


	/**
	 * 跳转到欢迎页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 欢迎页面模型视图
	 */
	@RequestMapping(value = LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_WELCOME_URL, method = RequestMethod.GET)
	public ModelAndView toWelcome(final LKDatas requestDatas) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (!(LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_WELCOME_URL).equals(LKWebProperties.LK_WEB_PAGE_WELCOME_URL)) {
			mv.setViewName("redirect:" + LKWebProperties.LK_WEB_PAGE_WELCOME_URL);
		}
		return mv;
	}


	/**
	 * 登录
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 成功返回SUCCESS，否则返回ERROR。
	 */
	@WithOutLogin
	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String doLogin(final LKDatas requestDatas) {
		session.setAttribute(LKSessionUser.SESSION_USER, service.doLogin(requestDatas));
		return LKController.SUCCESS;
	}


	/**
	 * 登出
	 * @return 成功返回SUCCESS，否则返回ERROR。
	 */
	@ResponseBody
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String toLogout() {
		session.removeAttribute(LKSessionUser.SESSION_USER);
		return LKController.SUCCESS;
	}


	/**
	 * 获取菜单列表
	 * @return 菜单列表
	 */
	@ResponseBody
	@RequestMapping(value = "getMenu.do", method = RequestMethod.POST)
	public List<? extends LKMenuInterface> getMenu() {
		return ((LKSessionUser) session.getAttribute(LKSessionUser.SESSION_USER)).getListMenu();
	}

}
