package com.lichkin.framework.springboot.web.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.springboot.controllers.LKController;
import com.lichkin.framework.springboot.utils.LKModelAndViewUtils;

/**
 * 只实现一些常用页面的跳转逻辑
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
public class LKRootController extends LKController {

	/**
	 * 页面跳转
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @param subUrl 子路径
	 * @return 页面路径，附带了请求参数及请求路径的相关信息。
	 */
	@WithOutLogin
	@RequestMapping(value = "/{subUrl}.html", method = RequestMethod.GET)
	public ModelAndView toGo(final LKDatas requestDatas, @PathVariable(value = "subUrl") final String subUrl) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}


	/**
	 * 页面跳转
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @param subUrl 子路径
	 * @return 页面路径，附带了请求参数及请求路径的相关信息。
	 */
	@WithOutLogin
	@RequestMapping(value = "/{x}/{y}.html", method = RequestMethod.GET)
	public ModelAndView toGo(final LKDatas requestDatas, @PathVariable(value = "x") final String x, @PathVariable(value = "y") final String y) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}


	/**
	 * 页面跳转
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @param subUrl 子路径
	 * @return 页面路径，附带了请求参数及请求路径的相关信息。
	 */
	@WithOutLogin
	@RequestMapping(value = "/{x}/{y}/{z}.html", method = RequestMethod.GET)
	public ModelAndView toGo(final LKDatas requestDatas, @PathVariable(value = "x") final String x, @PathVariable(value = "y") final String y, @PathVariable(value = "z") final String z) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}

}
