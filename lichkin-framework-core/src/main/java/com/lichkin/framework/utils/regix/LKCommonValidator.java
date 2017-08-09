package com.lichkin.framework.utils.regix;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.lang.LKMatcherUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 通用验证工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKCommonValidator {

	/**
	 * 验证手机号码
	 * @param cellphone 手机号码
	 * @return 验证通过返回true，否则返回false。
	 */
	public static boolean isCellphone(final String cellphone) {
		return LKMatcherUtils.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", cellphone);
	}


	/**
	 * 验证手机号码
	 * @param cellphone 手机号码
	 */
	public static void validateCellphone(final String cellphone) {
		if (LKStringUtils.isBlank(cellphone)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "cellphone is null.");
		}
		if (!isCellphone(cellphone)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "cellphone incorrect.");
		}
	}

}
