package com.lichkin.framework.bases.db.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * SQL语句对象类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSqlVo {

	/** SQL语句 */
	private final StringBuilder sql;

	/** 参数列表 */
	private List<Object> params;


	/**
	 * 构造方法
	 */
	public LKSqlVo() {
		this("");
	}


	/**
	 * 构造方法
	 * @param sql SQL语句
	 */
	public LKSqlVo(final String sql) {
		this.sql = new StringBuilder(sql);
	}


	/**
	 * 构造方法
	 * @param sql SQL语句
	 * @param params 参数数组
	 */
	public LKSqlVo(final String sql, final Object... params) {
		this(sql);
		if (ArrayUtils.isNotEmpty(params)) {
			for (final Object param : params) {
				addParam(param);
			}
		}
	}


	/**
	 * 获取SQL语句
	 * @return SQL语句
	 */
	public String getSql() {
		return sql.toString();
	}


	/**
	 * 获取参数数组
	 * @return 参数数组
	 */
	public Object[] getParams() {
		if (CollectionUtils.isNotEmpty(params)) {
			return params.toArray();
		}
		return null;
	}


	/**
	 * 拼接SQL语句
	 * @param subSql 子SQL语句
	 * @return SQL语句对象
	 */
	public LKSqlVo appendSql(final String subSql) {
		sql.append(" ").append(subSql);
		return this;
	}


	/**
	 * 增加参数
	 * @param param 参数对象
	 * @return SQL语句对象
	 */
	public LKSqlVo addParam(final Object param) {
		if (CollectionUtils.isEmpty(params)) {
			params = new ArrayList<>();
		}
		params.add(param);
		return this;
	}


	/**
	 * 拼接SQL语句并增加参数
	 * @param subSql 子SQL语句
	 * @param params 参数数组
	 * @return SQL语句对象
	 */
	public LKSqlVo appendSqlAndAddParam(final String subSql, final Object... params) {
		appendSql(subSql);
		if (ArrayUtils.isNotEmpty(params)) {
			for (final Object param : params) {
				addParam(param);
			}
		}
		return this;
	}

}
