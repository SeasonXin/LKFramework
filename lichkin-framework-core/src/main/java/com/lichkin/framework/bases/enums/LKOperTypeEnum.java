package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 操作类型枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKOperTypeEnum implements LKBaseEnum {

	/** 增加 */
	ADD(1, "增加", "add"),

	/** 删除 */
	REMOVE(2, "删除", "remove"),

	/** 修改 */
	EDIT(3, "修改", "edit"),

	/** 查询 */
	SEARCH(4, "查询", "search"),

	/** 其它 */
	OTHER(5, "其它", "other");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKOperTypeEnum(final Integer code, final String name, final String nameEn) {
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
