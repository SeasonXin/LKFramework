package com.lichkin.framework.bases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 字符串类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@NoArgsConstructor
public class LKString {

	/** 内置字符串 */
	private String str;


	/**
	 * 构造方法
	 * @param str 字符串
	 */
	public LKString(final String str) {
		super();
		this.str = str;
	}

}
