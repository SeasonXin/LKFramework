package com.lichkin.framework.utils.lang;

import java.io.UnsupportedEncodingException;

import com.lichkin.framework.bases.LKDatas;

/**
 * 数据集合工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKDatasUtils {

	/**
	 * 去除空值的键值对
	 * @param datas 集合
	 * @return 去除空值的键值对后的集合
	 */
	public static LKDatas clearBlankValue(final LKDatas datas) {
		final LKDatas result = new LKDatas();

		if ((datas == null) || (datas.size() <= 0)) {
			return result;
		}

		return new LKDatas(LKMapUtils.clearBlankValue(datas.getMap()));
	}


	/**
	 * 创建URL参数字符串
	 * @param datas 集合
	 * @param charset 字符集
	 * @param encode 是否需要编码
	 * @param sort 是否需要排序
	 * @return URL参数字符串
	 * @throws UnsupportedEncodingException 不支持的字符集
	 */
	public static String createUrlParamsString(final LKDatas datas, final String charset, final boolean encode, final boolean sort) throws UnsupportedEncodingException {
		return LKMapUtils.createUrlParamsString(LKMapUtils.changeGenericityToStringString(datas.getMap()), charset, encode, sort);
	}


	/**
	 * 编码
	 * @param datas 集合
	 * @param charset 字符集
	 * @return 编码后的集合
	 * @throws UnsupportedEncodingException 不支持的字符集
	 */
	public static LKDatas encode(final LKDatas datas, final String charset) throws UnsupportedEncodingException {
		return new LKDatas(LKMapUtils.changeGenericityToStringObject(LKMapUtils.encode(LKMapUtils.changeGenericityToStringString(datas.getMap()), charset)));
	}

}
