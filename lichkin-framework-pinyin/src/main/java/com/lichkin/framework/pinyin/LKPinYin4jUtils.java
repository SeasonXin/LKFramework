package com.lichkin.framework.pinyin;

import org.apache.commons.lang3.ArrayUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPinYin4jUtils {

	/**
	 * 获取汉字串第一个中文的首字母
	 * @param chinese 汉字串
	 * @param toUpperCase true：转换为大写；false：转换为小写。
	 * @return 第一个中文的首字母
	 */
	public static String getFirstPinYinCapital(final String chinese, final boolean toUpperCase) {
		return LKPinYin4jUtils.getPinYinCapital(chinese.charAt(0), toUpperCase);
	}


	/**
	 * 获取汉字串拼音首字母
	 * @param chinese 汉字串
	 * @param toUpperCase true：转换为大写；false：转换为小写。
	 * @return 汉语拼音首字母
	 */
	public static String getPinYinCapital(final String chinese, final boolean toUpperCase) {
		final char[] arr = chinese.toCharArray();
		final StringBuffer sb = new StringBuffer();
		final HanyuPinyinOutputFormat format = LKPinYin4jUtils.getOutputFormat(toUpperCase);
		for (final char element : arr) {
			sb.append(LKPinYin4jUtils.getPinYinCapital(element, format));
		}
		return sb.toString();
	}


	/**
	 * 转换为汉语拼音
	 * @param chinese 汉字串
	 * @param toUpperCase true：转换为大写；false：转换为小写。
	 * @param connector 连接字符串
	 * @return 汉语拼音
	 */
	public static String toPinYin(final String chinese, final boolean toUpperCase, final String connector) {
		final char[] arr = chinese.toCharArray();
		final StringBuffer sb = new StringBuffer();
		final HanyuPinyinOutputFormat format = LKPinYin4jUtils.getOutputFormat(toUpperCase);
		for (final char element : arr) {
			sb.append(LKPinYin4jUtils.toPinYin(element, format));
			sb.append(connector);
		}
		return sb.substring(0, sb.length() - connector.length());
	}


	/**
	 * 转换为汉语拼音
	 * @param chinese 汉字
	 * @param format 输出格式
	 * @return 汉语拼音
	 */
	public static String toPinYin(final char chinese, final HanyuPinyinOutputFormat format) {
		try {
			final String[] temp = PinyinHelper.toHanyuPinyinStringArray(chinese, format);
			if (ArrayUtils.isNotEmpty(temp)) {
				return String.valueOf(temp[0]);
			}
		} catch (final BadHanyuPinyinOutputFormatCombination e) {
		}

		return "";
	}


	/**
	 * 获取汉字拼音首字母
	 * @param chinese 汉字
	 * @param toUpperCase true：转换为大写；false：转换为小写。
	 * @return 汉字拼音首字母
	 */
	public static String getPinYinCapital(final char chinese, final boolean toUpperCase) {
		return LKPinYin4jUtils.getPinYinCapital(chinese, LKPinYin4jUtils.getOutputFormat(toUpperCase));
	}


	/**
	 * 获取汉字拼音首字母
	 * @param chinese 汉字
	 * @param format 输出格式
	 * @return 汉字拼音首字母
	 */
	public static String getPinYinCapital(final char chinese, final HanyuPinyinOutputFormat format) {
		try {
			final String[] temp = PinyinHelper.toHanyuPinyinStringArray(chinese, format);
			if (ArrayUtils.isNotEmpty(temp)) {
				return String.valueOf(temp[0].charAt(0));
			}
		} catch (final BadHanyuPinyinOutputFormatCombination e) {
		}

		return "";
	}


	/**
	 * 获取输出格式
	 * @param toUpperCase true：转换为大写；false：转换为小写。
	 * @return 输出格式
	 */
	private static HanyuPinyinOutputFormat getOutputFormat(final boolean toUpperCase) {
		final HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(toUpperCase ? HanyuPinyinCaseType.UPPERCASE : HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		return format;
	}

}
