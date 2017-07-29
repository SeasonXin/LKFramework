package com.lichkin.framework.bases.vos;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.statics.LKWebStatics;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 接口请求数据标准类型
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKInvokeValueVo {

	/** 用户名 */
	private String callerName;

	/** 密码 */
	private String password;

	/** 请求参数 */
	private LKDatas requestDatas;


	/**
	 * 构造方法
	 * @param requestDatas 请求参数
	 */
	public LKInvokeValueVo(final LKDatas requestDatas) {
		callerName = requestDatas.getString("callerName", null);
		if (LKStringUtils.isBlank(callerName)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PERMISSION_DENIED, "callerName is null.");
		}

		password = requestDatas.getString("password", null);
		if (LKStringUtils.isBlank(password)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PERMISSION_DENIED, "password is null.");
		}

		final LKDatas datas = requestDatas.getDatas("requestDatas");
		datas.put(LKWebStatics.REQUEST_ID, requestDatas.getString(LKWebStatics.REQUEST_ID, ""));
		datas.put(LKWebStatics.REQUEST_TIME, requestDatas.getString(LKWebStatics.REQUEST_TIME, ""));
		datas.put(LKWebStatics.REQUEST_IP, requestDatas.getString(LKWebStatics.REQUEST_IP, ""));
		datas.put(LKWebStatics.REQUEST_URL, requestDatas.getString(LKWebStatics.REQUEST_URL, ""));
		this.requestDatas = datas;
	}


	/**
	 * 获取用户名
	 * @return 用户名
	 */
	public String getCallerName() {
		return callerName;
	}


	/**
	 * 设置用户名
	 * @param callerName 用户名
	 */
	public void setCallerName(final String callerName) {
		this.callerName = callerName;
	}


	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * 设置密码
	 * @param password 密码
	 */
	public void setPassword(final String password) {
		this.password = password;
	}


	/**
	 * 获取请求数据
	 * @return 请求数据
	 */
	public LKDatas getRequestDatas() {
		return requestDatas;
	}


	/**
	 * 设置请求数据
	 * @param requestDatas 请求数据
	 */
	public void setRequestDatas(final LKDatas requestDatas) {
		this.requestDatas = requestDatas;
	}

}
