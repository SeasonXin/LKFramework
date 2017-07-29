package com.lichkin.framework.bases.entities;

import java.io.Serializable;

/**
 * ID接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKIDInterface extends Serializable {

	/**
	 * 获取主键
	 * @return 主键
	 */
	public String getId();


	/**
	 * 设置主键
	 * @param id 主键
	 */
	public void setId(String id);

}
