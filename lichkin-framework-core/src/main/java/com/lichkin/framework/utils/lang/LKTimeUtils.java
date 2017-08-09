package com.lichkin.framework.utils.lang;

import java.util.Calendar;

import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;

/**
 * 时间工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKTimeUtils {

	/**
	 * 获取表示当前时间的字符串(yyyy-MM-dd HH:mm:ss)
	 * @return 时间
	 */
	public static String getNow() {
		return DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn());
	}


	/**
	 * 获取表示当前时间的字符串
	 * @param datePatternEnum 日期模式枚举
	 * @return 时间
	 */
	public static String getNow(final LKDatePatternEnum datePatternEnum) {
		return DateTime.now().toString(datePatternEnum.getNameEn());
	}


	/**
	 * 将日期字符串转换为日期对象
	 * @param str 日期字符串
	 * @return 日期对象
	 */
	public static DateTime parse(final String str) {
		return DateTime.parse(str);
	}


	/**
	 * 计算时间差
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param datePattern 差值类型， 只支持DAY，HOUR，MINUTE，SECOND，MILLISECOND。
	 * @return 差值
	 */
	public static final long calcDiff(final String startTime, final String endTime, final LKDatePatternEnum datePattern) {
		return calcDiff(DateTime.parse(startTime), DateTime.parse(endTime), datePattern);
	}


	/**
	 * 计算时间差
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param datePattern 差值类型， 只支持DAY，HOUR，MINUTE，SECOND，MILLISECOND。
	 * @return 差值
	 */
	public static final long calcDiff(final DateTime startTime, final DateTime endTime, final LKDatePatternEnum datePattern) {
		return (endTime.getMillis() - startTime.getMillis()) / datePattern.getCode();
	}


	/**
	 * 获取间隔日期列表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param containsStart 是否包含开始日期
	 * @param containsEnd 是否包含结束日期
	 * @return 间隔日期
	 */
	public static String[] getGapDaysArray(final String startTime, final String endTime, final boolean containsStart, final boolean containsEnd) {
		return getGapDaysArray(DateTime.parse(startTime), DateTime.parse(endTime), containsStart, containsEnd);
	}


	/**
	 * 获取间隔日期列表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param containsStart 是否包含开始日期
	 * @param containsEnd 是否包含结束日期
	 * @return 间隔日期
	 */
	public static String[] getGapDaysArray(final DateTime startTime, final DateTime endTime, final boolean containsStart, final boolean containsEnd) {
		if (startTime.isBefore(endTime)) {
			String[] days = {};
			int start = 1;
			if (containsStart) {
				start--;
			}
			long diff = calcDiff(startTime, endTime, LKDatePatternEnum.DAY);
			if (containsEnd) {
				diff++;
			}
			for (int i = start; i < diff; i++) {
				final DateTime day = startTime.plusDays(i);
				days = ArrayUtils.add(days, day.toString(LKDatePatternEnum.DATE_ONLY.getNameEn()));
			}
			return days;
		}
		return null;
	}


	/**
	 * 获取UTC时间
	 * @return UTC时间
	 */
	public static DateTime getUTCTime() {
		final Calendar cal = Calendar.getInstance();
		final int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		final int dstOffset = cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return new DateTime(cal);
	}

}
