package com.lichkin.framework.bases.entities;

import com.lichkin.framework.bases.enums.LKUsingStatusEnum;

/**
 * 一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKNormalInterface extends LKIDInterface {

	/**
	 * 获取在用状态
	 * @return 在用状态
	 */
	public LKUsingStatusEnum getUsingStatus();


	/**
	 * 设置在用状态
	 * @param usingStatus 在用状态
	 */
	public void setUsingStatus(final LKUsingStatusEnum usingStatus);


	/**
	 * 获取备注信息
	 * @return 备注信息
	 */
	public String getRemarks();


	/**
	 * 设置备注信息
	 * @param remarks 备注信息
	 */
	public void setRemarks(final String remarks);

}
