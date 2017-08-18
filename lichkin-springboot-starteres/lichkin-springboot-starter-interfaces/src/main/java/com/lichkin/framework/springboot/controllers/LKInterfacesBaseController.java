package com.lichkin.framework.springboot.controllers;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.vos.LKInvokeValueVo;
import com.lichkin.framework.springboot.services.LKInterfacesBaseService;

/**
 * 接口框架控制器类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKInterfacesBaseController extends LKController {

	/**
	 * 获取业务类
	 * @return 业务类对象
	 */
	public abstract LKInterfacesBaseService getService();


	/**
	 * 验证并获取请求参数，同时记录请求日志。
	 * @param invokeValue 调用值对象
	 * @return 请求参数
	 */
	protected LKDatas validateAndSaveRequestLog(final LKInvokeValueVo invokeValue) {
		return getService().validate(invokeValue, getRootRequestMappingValue(), true);
	}


	/**
	 * 验证并获取请求参数
	 * @param invokeValue 调用值对象
	 * @return 请求参数
	 */
	protected LKDatas validate(final LKInvokeValueVo invokeValue) {
		return getService().validate(invokeValue, getRootRequestMappingValue(), false);
	}

}
