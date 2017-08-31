package com.lichkin.framework.springboot.web.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * 选项对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class LKOptionsBean {

	/** 传输值 */
	private String value;

	/** 显示文本 */
	private String text;


	/**
	 * 构造方法
	 * @param value 选项值与显示值
	 */
	public LKOptionsBean(final String value) {
		super();
		this.value = text = value;
	}


	/**
	 * 构造方法
	 * @param value 选项值
	 * @param text 显示值
	 */
	public LKOptionsBean(final String value, final String text) {
		super();
		this.value = value;
		this.text = text;
	}

}
