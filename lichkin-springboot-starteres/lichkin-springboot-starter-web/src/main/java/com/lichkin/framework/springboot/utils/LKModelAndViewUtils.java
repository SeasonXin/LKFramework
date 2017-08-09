package com.lichkin.framework.springboot.utils;

import org.springframework.web.servlet.ModelAndView;

/**
 * 视图模型工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKModelAndViewUtils {

	/**
	 * 分析视图名称
	 * @param mv 视图模型
	 * @return 视图模型
	 */
	public static ModelAndView analyzeViewName(final ModelAndView mv) {
		mv.setViewName("/" + LKPropertiesUtils.getProperty("lichkin.framework.web.ui", "") + mv.getViewName());
		if (LKPropertiesUtils.getProperty("lichkin.framework.web.isAdmin", false)) {
			mv.setViewName("/admin" + mv.getViewName());
		}
		return mv;
	}

}
