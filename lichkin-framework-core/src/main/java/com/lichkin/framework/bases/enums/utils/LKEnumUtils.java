package com.lichkin.framework.bases.enums.utils;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.enums.LKGetTypeEnum;
import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;
import com.lichkin.framework.bases.enums.interfaces.LKEnum;
import com.lichkin.framework.bases.enums.interfaces.LKPairEnum;
import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

/**
 * 枚举工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKEnumUtils {

	/**
	 * 获取枚举（使用key）
	 * @param enums 枚举值列表
	 * @param type 获取枚举使用的类型
	 * @param key 枚举值
	 * @return 枚举对象
	 */
	public static LKBaseEnum getEnum(final LKBaseEnum[] enums, final LKGetTypeEnum type, final Object key) {
		switch (type) {
			case CODE:
				return LKEnumUtils.getEnumByCode(enums, (Integer) key);
			case NAME:
				return LKEnumUtils.getEnumByName(enums, (String) key);
			case NAME_EN:
				return LKEnumUtils.getEnumByNameEn(enums, (String) key);
			default:
				throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
		}
	}


	/**
	 * 获取枚举（使用key）
	 * @param enums 枚举值列表
	 * @param key 枚举值
	 * @return 枚举对象
	 */
	public static LKPrototypeEnum getEnumByKey(final LKPrototypeEnum[] enums, final String key) {
		for (final LKPrototypeEnum enumX : enums) {
			if (enumX.toString().equals(key)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用key）
	 * @param enums 枚举值列表
	 * @param key 枚举值
	 * @return 枚举对象
	 */
	public static LKPairEnum getEnumByKey(final LKPairEnum[] enums, final String key) {
		for (final LKPairEnum enumX : enums) {
			if (enumX.toString().equals(key)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用key）
	 * @param enums 枚举值列表
	 * @param key 枚举值
	 * @return 枚举对象
	 */
	public static LKBaseEnum getEnumByKey(final LKBaseEnum[] enums, final String key) {
		for (final LKBaseEnum enumX : enums) {
			if (enumX.toString().equals(key)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用key）
	 * @param enums 枚举值列表
	 * @param key 枚举值
	 * @return 枚举对象
	 */
	public static LKEnum getEnumByKey(final LKEnum[] enums, final String key) {
		for (final LKEnum enumX : enums) {
			if (enumX.toString().equals(key)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用code）
	 * @param enums 枚举值列表
	 * @param code 编码值
	 * @return 枚举对象
	 */
	public static LKEnum getEnumByCode(final LKEnum[] enums, final Integer code) {
		for (final LKEnum enumX : enums) {
			if (code == enumX.getCode()) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用code）
	 * @param enums 枚举值列表
	 * @param code 编码值
	 * @return 枚举对象
	 */
	public static LKBaseEnum getEnumByCode(final LKBaseEnum[] enums, final Integer code) {
		for (final LKBaseEnum enumX : enums) {
			if (code == enumX.getCode()) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用name）
	 * @param enums 枚举值列表
	 * @param name 中文名称
	 * @return 枚举对象
	 */
	public static LKPairEnum getEnumByName(final LKPairEnum[] enums, final String name) {
		for (final LKPairEnum enumX : enums) {
			if (enumX.getName().equals(name)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用name）
	 * @param enums 枚举值列表
	 * @param name 中文名称
	 * @return 枚举对象
	 */
	public static LKBaseEnum getEnumByName(final LKBaseEnum[] enums, final String name) {
		for (final LKBaseEnum enumX : enums) {
			if (enumX.getName().equals(name)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}


	/**
	 * 获取枚举（使用nameEn）
	 * @param enums 枚举值列表
	 * @param nameEn 英文名称
	 * @return 枚举对象
	 */
	public static LKBaseEnum getEnumByNameEn(final LKBaseEnum[] enums, final String nameEn) {
		for (final LKBaseEnum enumX : enums) {
			if (enumX.getNameEn().equals(nameEn)) {
				return enumX;
			}
		}
		throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION);
	}

}
