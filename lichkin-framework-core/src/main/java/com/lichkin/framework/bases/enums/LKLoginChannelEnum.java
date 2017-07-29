package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 登录渠道类型枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKLoginChannelEnum implements LKBaseEnum {

	/** WEB */
	WEB(1, "WEB", "网页"),

	/** WEB_SERVICE */
	WEB_SERVICE(2, "WEB_SERVICE", "接口"),

	/** ANDROID */
	ANDROID(3, "ANDROID", "安卓"),

	/** IOS */
	IOS(4, "IOS", "苹果"),

	/** WINDOW_PHONE */
	WINDOW_PHONE(5, "WINDOW_PHONE", "微软"),

	/** OTHER */
	OTHER(6, "OTHER", "其它");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKLoginChannelEnum(final Integer code, final String name, final String nameEn) {
		this.code = code;
		this.name = name;
		this.nameEn = nameEn;
	}


	/** 编码 */
	private final Integer code;

	/** 中文名称 */
	private final String name;

	/** 英文名称 */
	private final String nameEn;


	/**
	 * 获取编码
	 * @return 编码
	 */
	@Override
	public Integer getCode() {
		return code;
	}


	/**
	 * 获取中文名称
	 * @return 中文名称
	 */
	@Override
	public String getName() {
		return name;
	}


	/**
	 * 获取英文名称
	 * @return 英文名称
	 */
	@Override
	public String getNameEn() {
		return nameEn;
	}

}
