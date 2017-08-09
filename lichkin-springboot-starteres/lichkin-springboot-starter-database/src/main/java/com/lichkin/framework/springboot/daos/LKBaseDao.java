package com.lichkin.framework.springboot.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.lichkin.framework.bases.db.utils.LKSQLUtils;
import com.lichkin.framework.bases.db.vo.LKOneVo;
import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.statics.LKSQLStatics;
import com.lichkin.framework.springboot.utils.LKEntityInitializer;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 基本数据库访问类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKBaseDao implements LKDao {

	/** 日志记录对象 */
	private final Log logger = LogFactory.getLog(getClass());


	@Override
	public <T> List<T> queryListBySql(final LKSqlVo sqlVo, final Class<T> clazz) {
		try {
			String sql = sqlVo.getSql();
			logger.debug("Original SQL: " + sql);

			// 创建查询
			sql = LKSQLUtils.getSql(sql, clazz);
			logger.info("Converted SQL: " + sql);
			final Query query = getEntityManager().createNativeQuery(sql);
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(clazz));

			// 设置参数
			final Object[] params = setParams(sqlVo, query);

			// 执行查询
			return executeQuery(sql, query, params);
		} catch (final Throwable e) {
			throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, e);
		}
	}


	@Override
	public <T> Page<T> queryPageBySql(final LKSqlVo sqlVo, final Class<T> clazz, final Pageable pageable) {
		try {
			String sql = sqlVo.getSql();
			logger.debug("Original SQL: " + sql);

			sql = LKSQLUtils.getSql(sql, clazz);
			logger.info("Converted SQL: " + sql);

			// 创建查询
			final String cntSql = "select count(1) as one from (" + sql + ") LK";
			final Query cntQuery = getEntityManager().createNativeQuery(cntSql);
			cntQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(LKOneVo.class));
			// 设置参数
			setParams(sqlVo, cntQuery);
			// 执行查询
			final Object result = cntQuery.getSingleResult();
			long total = 0L;
			if (result != null) {
				final Object one = ((LKOneVo) result).getOne();
				if (one != null) {
					total = LKStringUtils.toLong(one.toString(), 0L);
				}
			}

			if (total == 0L) {
				return new PageImpl<>(new ArrayList<T>(), pageable, total);
			}

			// 拼接排序
			if (pageable != null) {
				final Sort sort = pageable.getSort();
				if (sort != null) {
					final StringBuilder sb = new StringBuilder(" ORDER BY");
					for (final Order order : sort) {
						if (order != null) {
							final String property = order.getProperty();
							final String direction = order.getDirection().toString();
							sb.append(" ").append(property).append(" ").append(direction).append(",");
						}
					}
					sql += sb.deleteCharAt(sb.length() - 1);
				}
			}

			// 创建查询
			final Query query = getEntityManager().createNativeQuery(sql);
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(clazz));
			final int pageNumber = pageable.getPageNumber();
			final int pageSize = pageable.getPageSize();
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			logger.debug("Original SQL: " + sql + " ===>pageable:" + pageable.toString());
			// 设置参数
			final Object[] params = setParams(sqlVo, query);
			// 执行查询
			final List<T> list = executeQuery(sql, query, params);

			return new PageImpl<>(list, pageable, total);
		} catch (final Throwable e) {
			throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, e);
		}
	}


	@Override
	public <T> T queryOneBySql(final LKSqlVo sqlVo, final Class<T> clazz) {
		return returnOne(queryListBySql(sqlVo, clazz));
	}


	@Override
	public String queryStringBySql(final LKSqlVo sqlVo) {
		final LKOneVo oneVo = queryOneBySql(sqlVo, LKOneVo.class);
		if (oneVo == null) {
			return null;
		}
		final Object one = oneVo.getOne();
		if (one == null) {
			return null;
		}
		return one.toString();
	}


	@Override
	public <T> List<T> findListByHql(final LKSqlVo sqlVo, final Class<T> clazz) {
		try {
			final String sql = sqlVo.getSql();
			logger.debug("Original SQL: " + sql);

			// 创建查询
			final Query query = getEntityManager().createQuery(sql, clazz);

			// 设置参数
			final Object[] params = setParams(sqlVo, query);

			// 执行查询
			return executeQuery(sql, query, params);
		} catch (final Throwable e) {
			throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, e);
		}
	}


	@Override
	public <T> Page<T> findPageByHql(final LKSqlVo sqlVo, final Class<T> clazz, final Pageable pageable) {
		try {
			String sql = sqlVo.getSql();

			// 创建查询
			final String entityName = clazz.getName();
			final String upperCase = sql.toUpperCase();
			String subSql = "";
			if (upperCase.contains(LKSQLStatics.WHERE)) {
				subSql = sql.substring(sql.toUpperCase().indexOf(LKSQLStatics.WHERE) + LKSQLStatics.WHERE.length());
			} else {
				subSql = "1 = 1";
			}
			final String cntSql = "select count(LK) from " + entityName + " AS LK" + LKSQLStatics.BLANKWHEREBLANK + subSql;
			final Query cntQuery = getEntityManager().createQuery(cntSql);
			// 设置参数
			setParams(sqlVo, cntQuery);
			// 执行查询
			final Object result = cntQuery.getSingleResult();
			long total = 0;
			if (result != null) {
				total = LKStringUtils.toLong(result.toString(), 0L);
			}

			if (total == 0L) {
				return new PageImpl<>(new ArrayList<T>(), pageable, total);
			}

			// 拼接排序
			if (pageable != null) {
				final Sort sort = pageable.getSort();
				if (sort != null) {
					final StringBuilder sb = new StringBuilder(" ORDER BY");
					for (final Order order : sort) {
						if (order != null) {
							final String property = order.getProperty();
							final String direction = order.getDirection().toString();
							sb.append(" ").append(property).append(" ").append(direction).append(",");
						}
					}
					sql += sb.deleteCharAt(sb.length() - 1);
				}
			}

			// 创建查询
			final Query query = getEntityManager().createQuery(sql, clazz);
			final int pageNumber = pageable.getPageNumber();
			final int pageSize = pageable.getPageSize();
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			logger.debug("Original SQL: " + sql + " ===>pageable:" + pageable.toString());
			// 设置参数
			final Object[] params = setParams(sqlVo, query);
			// 执行查询
			final List<T> list = executeQuery(sql, query, params);

			return new PageImpl<>(list, pageable, total);
		} catch (final Throwable e) {
			throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, e);
		}
	}


	@Override
	public <T> T findOneByHql(final LKSqlVo sqlVo, final Class<T> clazz) {
		return returnOne(findListByHql(sqlVo, clazz));
	}


	@Override
	public <T> T findOneById(final Class<T> clazz, final String id) {
		final LKSqlVo sqlVo = new LKSqlVo();
		sqlVo.appendSql("from ");
		sqlVo.appendSql(clazz.getName());
		sqlVo.appendSql(" where id = ?");
		sqlVo.addParam(id);
		return findOneByHql(sqlVo, clazz);
	}


	@Override
	public String findStringByHql(final LKSqlVo sqlVo) {
		final Object one = findOneByHql(sqlVo, Object[].class);
		if (one == null) {
			return null;
		}
		return one.toString();
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> T save(final Object t, final boolean merge) {
		if (merge) {
			if (t instanceof List<?>) {
				final List<?> list = (List<?>) t;
				final List<T> ls = new ArrayList<>(list.size());
				for (final Object e : list) {
					final T s = (T) getEntityManager().merge(LKEntityInitializer.initBean(e));
					ls.add(s);
				}
				return (T) ls;
			} else if (t instanceof Object[]) {
				final Object[] list = (Object[]) t;
				final T[] ls = null;
				for (final Object e : list) {
					final T s = (T) getEntityManager().merge(LKEntityInitializer.initBean(e));
					ArrayUtils.add(ls, s);
				}
				return (T) ls;
			} else {
				return (T) getEntityManager().merge(LKEntityInitializer.initBean(t));
			}
		} else {
			if (t instanceof List<?>) {
				final List<?> list = (List<?>) t;
				for (final Object e : list) {
					getEntityManager().persist(LKEntityInitializer.initBean(e));
				}
			} else if (t instanceof Object[]) {
				final Object[] list = (Object[]) t;
				for (final Object e : list) {
					getEntityManager().persist(LKEntityInitializer.initBean(e));
				}
			} else {
				getEntityManager().persist(LKEntityInitializer.initBean(t));
			}
			return null;
		}
	}


	@Override
	public <T> T save(final Object t) {
		return save(t, true);
	}


	@Override
	public <T> T merge(final Object t) {
		return save(t, true);
	}


	@Override
	public <T> T persist(final Object t) {
		return save(t, false);
	}


	@Override
	public void remove(final Object t) {
		if (t instanceof List<?>) {
			final List<?> list = (List<?>) t;
			for (final Object e : list) {
				getEntityManager().remove(e);
			}
		} else if (t instanceof Object[]) {
			final Object[] list = (Object[]) t;
			for (final Object e : list) {
				getEntityManager().remove(e);
			}
		} else {
			getEntityManager().remove(t);
		}
	}


	@Override
	public int executeUpdate(final LKSqlVo sqlVo) {
		try {
			final String sql = sqlVo.getSql();
			logger.debug("Original SQL: " + sql);

			// 创建更新
			final Query query = getEntityManager().createNativeQuery(sql);

			// 设置参数
			final Object[] params = setParams(sqlVo, query);

			// 执行更新
			final long startTime = System.currentTimeMillis();
			final int result = query.executeUpdate();
			final long endTime = System.currentTimeMillis();
			logSql(sql, params, startTime, endTime);
			return result;
		} catch (final Throwable e) {
			throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, e);
		}
	}


	/**
	 * 返回对象
	 * @param list 列表
	 * @return 对象
	 */
	private <T> T returnOne(final List<T> list) {
		if ((list != null) && !list.isEmpty()) {
			if (list.size() != 1) {
				throw new LKRuntimeException(LKErrorCodeEnum.SQL_EXCEPTION, "you have " + String.valueOf(list.size()) + " results.");
			}
			return list.get(0);
		}
		return null;
	}


	/**
	 * 设置参数
	 * @param sqlVo 查询条件对象
	 * @param query 查询对象
	 * @return 参数
	 */
	private Object[] setParams(final LKSqlVo sqlVo, final Query query) {
		final Object[] params = sqlVo.getParams();
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		return params;
	}


	/**
	 * 执行查询
	 * @param sql SQL语句
	 * @param query 查询对象
	 * @param params 参数
	 * @return 列表
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> executeQuery(final String sql, final Query query, final Object[] params) {
		final long startTime = System.currentTimeMillis();
		final List<T> resultList = query.getResultList();
		final long endTime = System.currentTimeMillis();
		logSql(sql, params, startTime, endTime);
		return resultList;
	}


	/**
	 * 记录日志
	 * @param sql SQL语句
	 * @param params 参数列表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 */
	private void logSql(String sql, final Object[] params, final long startTime, final long endTime) {
		if (!ArrayUtils.isEmpty(params)) {
			final StringBuilder fullSql = new StringBuilder("SQL: ");
			fullSql.append(sql);
			fullSql.append(" [params: ");
			for (int i = 0; i < params.length; i++) {
				fullSql.append(String.valueOf(params[i]));
				if (i != (params.length - 1)) {
					fullSql.append(", ");
				}
			}
			fullSql.append("]");
			sql = fullSql.toString();
		}
		logger.info("execution time is " + String.valueOf(endTime - startTime) + "ms, from " + formatTime(startTime) + " to " + formatTime(endTime) + ".【" + sql + "】");
	}


	/**
	 * 转换成时间格式
	 * @param millisencond 毫秒数
	 * @return 时间字符串
	 */
	private String formatTime(final long millisencond) {
		return new DateTime(millisencond).toString(LKDatePatternEnum.TIME_ONLY_FULL.getNameEn());
	}

}
