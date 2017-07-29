package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 在用状态枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKUsingStatusEnum implements LKBaseEnum {

	/** 删除 */
	DEPRECATED(-1, "删除", "deprecated"),

	/** 待用 */
	STAND_BY(0, "待用", "stand by"),

	/** 在用 */
	USING(1, "在用", "using"),

	/** 停用 */
	DISABLE(2, "停用", "disable"),

	/** 锁定 */
	LOCKED(3, "锁定 ", "locked");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKUsingStatusEnum(final Integer code, final String name, final String nameEn) {
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
