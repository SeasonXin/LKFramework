package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKPairEnum;

/**
 * 实名认证等级枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKAuthenticationEnum implements LKPairEnum {

	/** 未认证 */
	NO("未认证"),

	/** 已实名 */
	AUTHENTICATED("已实名"),

	/** 已绑卡 */
	CARD_BINDED("已绑卡"),

	/** 已传身份证照片 */
	USER_CARD_UPLOADED("已传身份证照片");

	/**
	 * 构造方法
	 * @param name 中文名称
	 */
	LKAuthenticationEnum(final String name) {
		this.name = name;
	}


	/** 中文名称 */
	private final String name;


	/**
	 * 获取中文名称
	 * @return 中文名称
	 */
	@Override
	public String getName() {
		return name;
	}

}
