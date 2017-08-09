package com.lichkin.framework.bases.db.utils;

import static com.lichkin.framework.bases.statics.LKCharStatics.CHAR_COMMA;
import static com.lichkin.framework.bases.statics.LKCharStatics.CHAR_LEFT_BRACKET;
import static com.lichkin.framework.bases.statics.LKCharStatics.CHAR_RIGHT_BRACKET;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.bases.statics.LKCharStatics;
import com.lichkin.framework.bases.statics.LKSQLStatics;
import com.lichkin.framework.utils.lang.LKReflectUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * SQL工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSQLUtils {

	/**
	 * 获取SQL语句
	 * @param <T> 类型
	 * @param sql 原SQL语句
	 * @param clazz 映射的类
	 * @return SQL语句
	 */
	public static <T> String getSql(final String sql, final Class<T> clazz) {
		// 截取字段
		final String sqlUp = sql.toUpperCase();
		String fieldsSql = sql.substring(sqlUp.indexOf(LKSQLStatics.SELECT) + LKSQLStatics.SELECT.length(), sqlUp.indexOf(LKSQLStatics.FROM));
		boolean distinct = false;
		if (sqlUp.startsWith(LKSQLStatics.SELECTBLANKDISTINCT)) {
			fieldsSql = sql.substring(sqlUp.indexOf(LKSQLStatics.SELECTBLANKDISTINCT) + LKSQLStatics.SELECTBLANKDISTINCT.length(), sqlUp.indexOf(LKSQLStatics.FROM));
			distinct = true;
		}
		String[] arr = null;
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (final char c : fieldsSql.toCharArray()) {
			switch (c) {
				case CHAR_LEFT_BRACKET:
					cnt++;
				break;
				case CHAR_RIGHT_BRACKET:
					cnt--;
				break;
				case CHAR_COMMA:
					if (cnt == 0) {
						arr = ArrayUtils.add(arr, sb.toString().trim());
						sb = new StringBuilder();
						continue;
					}
				break;
				default:
				break;
			}
			sb.append(c);
		}
		arr = ArrayUtils.add(arr, sb.toString().trim());

		// 转换字段
		final Map<String, String> map = new HashMap<>();
		for (final String str : arr) {
			final String strUp = str.toUpperCase();
			if (strUp.contains(LKSQLStatics.BLANKASBLANK)) {
				// 包含别名，则记录别名。
				map.put(str.substring(strUp.indexOf(LKSQLStatics.BLANKASBLANK) + LKSQLStatics.BLANKASBLANK.length()), strUp.substring(0, strUp.indexOf(LKSQLStatics.BLANKASBLANK)));
			} else if (strUp.contains(".")) {
				map.put(LKStringUtils.underlineToHump(strUp.substring(strUp.indexOf(".") + 1)), strUp);
			} else {
				map.put(LKStringUtils.underlineToHump(strUp), strUp);
			}
		}
		if (distinct) {
			sb = new StringBuilder(LKSQLStatics.SELECTBLANKDISTINCT);
		} else {
			sb = new StringBuilder(LKSQLStatics.SELECT);
		}
		for (final Entry<String, String> entry : map.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			if (key.equals("*")) {
				final PropertyDescriptor[] props = LKReflectUtils.getBeanProperties(clazz);
				if (value.equals("*")) {
					for (final PropertyDescriptor prop : props) {
						final String displayName = prop.getDisplayName();
						if (map.containsKey(displayName)) {
							// 已经有指定，则不转换。
							continue;
						}
						sb.append(" ").append(LKStringUtils.humpToUnderline(displayName)).append(LKSQLStatics.BLANKASBLANK).append(displayName).append(",");
					}
				} else {
					final String tableAlias = value.substring(0, value.indexOf(".")).toUpperCase();
					for (final PropertyDescriptor prop : props) {
						final String displayName = prop.getDisplayName();
						if (map.containsKey(displayName)) {
							// 已经有指定，则不转换。
							continue;
						}
						sb.append(" ").append(tableAlias).append(".").append(LKStringUtils.humpToUnderline(displayName)).append(LKSQLStatics.BLANKASBLANK).append(displayName).append(",");
					}
				}
			} else {
				sb.append(" ").append(value).append(LKSQLStatics.BLANKASBLANK).append(key).append(",");
			}
		}
		sb.setCharAt(sb.length() - 1, LKCharStatics.CHAR_BLANK);
		sb.append(sqlUp.substring(sqlUp.indexOf(LKSQLStatics.FROM)));
		return sb.toString();
	}


	/**
	 * 拼接in所需的SQL语句
	 * @param strArr 字符串列表
	 * @param withBracket 是否包含前后的括号
	 * @param withQuotation 是否为每个项增加引号
	 * @return SQL语句
	 */
	public static String jointInSql(final String[] strArr, final boolean withBracket, final boolean withQuotation) {
		final StringBuilder sb = new StringBuilder();
		if (withBracket) {
			sb.append("{");
		}
		for (final String str : strArr) {
			if (withQuotation) {
				sb.append("'");
			}
			sb.append(str);
			if (withQuotation) {
				sb.append("'");
			}
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		if (withBracket) {
			sb.append(")");
		}
		return sb.toString();
	}

}
