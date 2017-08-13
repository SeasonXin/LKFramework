package com.lichkin.framework.android.beans;

/**
 * 按钮对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKBtnBean {

	/** 按钮图片ID */
	private int btnImgId;

	/** 按钮标题 */
	private String btnTitle;

	/** 按钮点击后打开的Activity类型 */
	private Class<?> toActivityClass;


	/**
	 * 构造方法
	 * @param btnImgId 按钮图片ID
	 * @param btnTitle 按钮标题
	 * @param toActivityClass 按钮点击后打开的Activity类型
	 */
	public LKBtnBean(final int btnImgId, final String btnTitle, final Class<?> toActivityClass) {
		super();
		this.btnImgId = btnImgId;
		this.btnTitle = btnTitle;
		this.toActivityClass = toActivityClass;
	}


	public int getBtnImgId() {
		return btnImgId;
	}


	public void setBtnImgId(final int btnImgId) {
		this.btnImgId = btnImgId;
	}


	public String getBtnTitle() {
		return btnTitle;
	}


	public void setBtnTitle(final String btnTitle) {
		this.btnTitle = btnTitle;
	}


	public Class<?> getToActivityClass() {
		return toActivityClass;
	}


	public void setToActivityClass(final Class<?> toActivityClass) {
		this.toActivityClass = toActivityClass;
	}

}
