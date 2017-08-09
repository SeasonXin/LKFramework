package com.lichkin.framework.bases.db.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 单返回值对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKOneVo implements Serializable {

	/** serialVersionUID */
	static final long serialVersionUID = 2070287865141290911L;

	/** 单返回值 */
	private Object one;

}
