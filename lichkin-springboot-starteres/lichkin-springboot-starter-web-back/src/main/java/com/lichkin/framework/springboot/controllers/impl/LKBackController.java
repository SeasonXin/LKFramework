package com.lichkin.framework.springboot.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.springboot.controllers.LKController;
import com.lichkin.framework.springboot.utils.LKModelAndViewUtils;

/**
 * 后台常用跳转控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
public class LKBackController extends LKController {

	/**
	 * 跳转到主页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 主页面模型视图
	 */
	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
	public ModelAndView toMain(final LKDatas requestDatas) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}


	/**
	 * 跳转到欢迎页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 欢迎页面模型视图
	 */
	@RequestMapping(value = "/welcome.html", method = RequestMethod.GET)
	public ModelAndView toWelcome(final LKDatas requestDatas) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}


	/**
	 * 跳转到登录页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 登录页面模型视图
	 */
	@WithOutLogin
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView toLogin(final LKDatas requestDatas) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}

}
