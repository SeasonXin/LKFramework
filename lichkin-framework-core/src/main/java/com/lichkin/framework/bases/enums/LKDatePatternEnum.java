package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;
import com.lichkin.framework.bases.statics.LKStringStatics;

/**
 * 日期模式枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKDatePatternEnum implements LKBaseEnum {

	/** 全部 */
	ALL(1000, "yyyy年MM月dd日HH时mm分ss秒SSS毫秒", "yyyy-MM-dd HH:mm:ss:SSS"),

	/** 标准 */
	STANDARD(1001, "yyyy年MM月dd日HH时mm分ss秒", "yyyy-MM-dd HH:mm:ss"),

	/** 日期 */
	DATE_ONLY(1002, "yyyy年MM月dd日", "yyyy-MM-dd"),

	/** 日期，不带符号。 */
	DATE_ONLY8(1003, "yyyyMMdd", "yyyyMMdd"),

	/** 时间 */
	TIME_ONLY(1003, "HH时mm分ss秒", "HH:mm:ss"),

	/** 年份 */
	YEAR(365, "yyyy年", LKStringStatics.STR_YEAR),

	/** 月份 */
	MONTH(30, "MM月", LKStringStatics.STR_MONTH),

	/** 日 */
	DAY(86400000, "dd日", LKStringStatics.STR_DAY),

	/** 小时 */
	HOUR(3600000, "HH时", LKStringStatics.STR_HOUR),

	/** 分钟 */
	MINUTE(60000, "mm分", LKStringStatics.STR_MINUTE),

	/** 秒 */
	SECOND(1000, "ss秒", LKStringStatics.STR_SECOND),

	/** 毫秒 */
	TIME_ONLY_FULL(0, "HH时mm分ss秒SSS毫秒", "HH:mm:ss:SSS"),

	/** 毫秒 */
	MILLISECOND(1, "SSS毫秒", LKStringStatics.STR_MILLISECOND),

	/** 时间戳 */
	TIMESTAP(2, "yyyyMMddHHmmss", "yyyyMMddHHmmss"),

	/** 全时间戳 */
	TIMESTAPFULL(3, "yyyyMMddHHmmssSSS", "yyyyMMddHHmmssSSS"),

	/** 全时间戳，年份短写 */
	TIMESTAPFULL15(4, "yyMMddHHmmssSSS", "yyMMddHHmmssSSS");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKDatePatternEnum(final Integer code, final String name, final String nameEn) {
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
