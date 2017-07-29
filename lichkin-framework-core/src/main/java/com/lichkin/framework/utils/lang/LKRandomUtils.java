package com.lichkin.framework.utils.lang;

import java.util.Random;

import com.lichkin.framework.bases.enums.LKRangeTypeEnum;

/**
 * 随机数工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKRandomUtils {

	/**
	 * 生成随机字符串（数字（常用）和字母（常用））
	 * @param length 字符串长度
	 * @return 随机字符串
	 */
	public static String create(final int length) {
		return LKRandomUtils.create(length, LKRangeTypeEnum.NUMBER_NORMAL_AND_LETTER_NORMAL);
	}


	/**
	 * 生成随机数字符串
	 * @param length 字符串长度
	 * @return 随机字符串
	 */
	public static String createNumber(final int length) {
		return LKRandomUtils.create(length, LKRangeTypeEnum.NUMBER_WITHOUT_ZERO);
	}


	/**
	 * 生成随机字符串
	 * @param length 字符串长度
	 * @param rangeTypeEnum 取值范围枚举
	 * @return 随机字符串
	 */
	public static String create(final int length, final LKRangeTypeEnum rangeTypeEnum) {
		final Random random = new Random();
		final String rangeStr = rangeTypeEnum.getNameEn();

		final char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			result[i] = rangeStr.charAt(random.nextInt(rangeStr.length()));
		}
		return new String(result);
	}

}
