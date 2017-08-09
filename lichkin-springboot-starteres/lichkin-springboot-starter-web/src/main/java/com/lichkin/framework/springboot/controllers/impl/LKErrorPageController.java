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
 * 错误页面跳转逻辑
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Controller
public class LKErrorPageController extends LKController {

	/**
	 * 跳转到错误页面
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 错误页面模型视图
	 */
	@WithOutLogin
	@RequestMapping(value = "/error.html", method = RequestMethod.GET)
	public ModelAndView toError(final LKDatas requestDatas) {
		return LKModelAndViewUtils.analyzeViewName(getModelAndView());
	}

}
