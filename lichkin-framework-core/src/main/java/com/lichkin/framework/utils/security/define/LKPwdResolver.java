package com.lichkin.framework.utils.security.define;

import org.joda.time.DateTime;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.utils.security.md5.LKMD5Encrypter;

/**
 * 自定义密码解析工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPwdResolver {

	/**
	 * 解析密文
	 * @param pwd 密文
	 * @return 解析成功返回true，否则返回false。
	 */
	public static boolean resolve(final String pwd) {
		// 获取时间戳内容
		final char[] times = DateTime.now().toString(LKDatePatternEnum.TIMESTAPFULL.getNameEn()).toCharArray();

		// yyyy
		final char y1 = times[0];
		final char y2 = times[1];
		final char y3 = times[2];
		final char y4 = times[3];

		// MM
		final char M1 = times[4];
		final char M2 = times[5];

		// dd
		final char d1 = times[6];
		final char d2 = times[7];

		// HH
		final char H1 = times[8];
		final char H2 = times[9];

		// mm
		final char m1 = times[10];

		final char[] md5s = LKMD5Encrypter.encrypt("" + y1 + y2 + y3 + y4 + M1 + M2 + d1 + d2 + H1 + H2 + m1).toCharArray();

		// 创建密文
		final char[] chars = pwd.toCharArray();
		int idx = 0;
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		idx++;
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		idx++;
		if (chars[idx++] != d1) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		idx++;
		if (chars[idx++] != y2) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		idx++;
		if (chars[idx++] != y4) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != M1) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != M2) {
			return false;
		}
		idx++;
		idx++;
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != d2) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != y1) {
			return false;
		}
		if (chars[idx++] != H1) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != H2) {
			return false;
		}
		if (chars[idx++] != y3) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}
		if (chars[idx++] != m1) {
			return false;
		}
		if (chars[idx++] != md5s[32 - idx]) {
			return false;
		}

		// 校验位
		if (chars[idx++] != (char) (((y1 + y2 + y3 + y4 + M1 + M2 + d1 + d2 + H1 + H2 + m1) % 10) + 48)) {
			return false;
		}

		return true;
	}

}
