package com.lichkin.framework.springboot.web.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.bases.statics.configs.LKWebPropertiesDefaultValues;
import com.lichkin.framework.springboot.web.LKWebProperties;
import com.lichkin.framework.springboot.web.controllers.LKController;

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
	@RequestMapping(value = LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_ERROR_URL, method = RequestMethod.GET)
	public ModelAndView toError(final LKDatas requestDatas) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (!(mv.getViewName() + LKWebStatics.VIEW_REQUEST_SUFFIX).equals(LKWebProperties.LK_WEB_PAGE_ERROR_URL)) {
			mv.setViewName("redirect:" + LKWebProperties.LK_WEB_PAGE_ERROR_URL);
		}
		return mv;
	}

}
