package com.lichkin.framework.bases.db.vo;

import java.io.Serializable;

/**
 * 单返回值对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKOneVo implements Serializable {

	/** serialVersionUID */
	static final long serialVersionUID = 2070287865141290911L;

	/** 单返回值 */
	private Object one;


	/**
	 * 获取值
	 * @return 值
	 */
	public Object getOne() {
		return one;
	}


	/**
	 * 设置值
	 * @param one 值
	 */
	public void setOne(final Object one) {
		this.one = one;
	}

}
