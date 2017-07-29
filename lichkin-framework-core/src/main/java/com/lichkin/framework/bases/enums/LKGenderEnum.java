package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 性别枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKGenderEnum implements LKBaseEnum {

	/** 男 */
	MALE(1, "男", "male"),

	/** 女 */
	FEMALE(0, "女", "female"),

	/** 外星人 */
	ALIEN(333, "外星人", "alien");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKGenderEnum(final Integer code, final String name, final String nameEn) {
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
