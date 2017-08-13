package com.lichkin.framework.android.beans;

/**
 * 屏幕对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKScreenBean {

	/** 屏幕宽 */
	private int width;

	/** 屏幕高 */
	private int height;


	/**
	 * 构造方法
	 * @param width 屏幕宽
	 * @param height 屏幕高
	 */
	public LKScreenBean(final int width, final int height) {
		super();
		this.width = width;
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(final int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(final int height) {
		this.height = height;
	}

}
