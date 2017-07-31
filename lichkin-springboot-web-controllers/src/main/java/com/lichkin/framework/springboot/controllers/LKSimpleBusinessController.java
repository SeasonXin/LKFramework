package com.lichkin.framework.springboot.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.services.LKSimpleBusinessService;
import com.lichkin.framework.springboot.web.LKWebProperties;
import com.lichkin.framework.springboot.web.controllers.LKController;

/**
 * 简单业务控制器类，实现了页面跳转及基础的增删改查操作的映射，调用指定的service中的对应方法。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKSimpleBusinessController extends LKController {

	/**
	 * 获取服务类对象
	 * @return 服务类对象
	 */
	protected abstract LKSimpleBusinessService getService();


	/**
	 * 是否为viewName增加UI前缀
	 * @return 使用返回true，否则返回false。
	 */
	protected abstract boolean viewNameWithUI();


	/**
	 * 页面跳转
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @param subUrl 子路径
	 * @return 页面路径，附带了请求参数及请求路径的相关信息。
	 */
	@RequestMapping(value = "/{subUrl}.html", method = RequestMethod.GET)
	public ModelAndView toGo(final LKDatas requestDatas, @PathVariable(value = "subUrl") final String subUrl) {
		final ModelAndView mv = getModelAndView(requestDatas);
		if (viewNameWithUI()) {
			mv.setViewName("/" + LKWebProperties.LK_WEB_UI + mv.getViewName());
		}
		return mv;
	}


	/**
	 * 新增
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public Object add(final LKDatas requestDatas) {
		return getService().add(requestDatas);
	}


	/**
	 * 删除
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/remove.do", method = RequestMethod.POST)
	public Object remove(final LKDatas requestDatas) {
		return getService().remove(requestDatas);
	}


	/**
	 * 修改
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public Object edit(final LKDatas requestDatas) {
		return getService().edit(requestDatas);
	}


	/**
	 * 查询单条数据（使用ID查询）
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getOneById.do", method = RequestMethod.POST)
	public Object getOneById(final LKDatas requestDatas) {
		return getService().getOneById(requestDatas);
	}


	/**
	 * 列表查询
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	public Object list(final LKDatas requestDatas) {
		return getService().list(requestDatas);
	}


	/**
	 * 分页查询
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return service对应的方法处理返回的数据信息
	 */
	@ResponseBody
	@RequestMapping(value = "/page.do", method = RequestMethod.POST)
	public Object page(final LKDatas requestDatas) {
		return getService().page(requestDatas);
	}

}
