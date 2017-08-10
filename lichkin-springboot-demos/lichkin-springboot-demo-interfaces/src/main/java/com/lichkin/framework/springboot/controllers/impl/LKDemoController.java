package com.lichkin.framework.springboot.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.annotations.WithOutLogin;
import com.lichkin.framework.bases.vos.LKInvokeValueVo;
import com.lichkin.framework.springboot.controllers.LKInterfacesBaseController;
import com.lichkin.framework.springboot.services.LKInterfacesBaseService;
import com.lichkin.framework.springboot.services.impl.LKDemoService;

/**
 * 演示接口使用方式
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@RestController
@RequestMapping("/demo")
// 继承框架的接口
public class LKDemoController extends LKInterfacesBaseController {

	/** Spring注入服务类对象 */
	@Autowired
	private LKDemoService service;


	@Override
	// 实现方法并返回相应服务类
	public LKInterfacesBaseService getService() {
		return service;
	}


	@WithOutLogin
	@RequestMapping("/demo.do")
	// 使用LKInvokeValueVo参数，框架将做基本的非空验证并注入对应的请求参数。
	public Object doDemo(final LKInvokeValueVo invokeValue) {
		// 验证请求格式及参数，框架中实现了表数据验证，将读取T_SYS_INTERFACES_LOGIN表中的配置进行验证。
		final LKDatas requestDatas = validateAndSaveRequestLog(invokeValue);

		// 验证请求参数，进行基本的非空验证。
		validateParams(requestDatas, "a");

		return service.doDemo(requestDatas);
	}

}
