package com.lichkin.framework.bases;

/**
 * 字符串类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
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


	/**
	 * 获取字符串
	 * @return 字符串
	 */
	public String getStr() {
		return str;
	}


	/**
	 * 设置字符串
	 * @param str 字符串
	 */
	public void setStr(final String str) {
		this.str = str;
	}

}
