package com.lichkin.framework.springboot.daos;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lichkin.framework.bases.db.vo.LKSqlVo;

/**
 * 数据访问接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKDao {

	/**
	 * 获取EntityManager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager();


	/**
	 * 查询列表
	 * @param sqlVo 查询对象
	 * @param clazz 查询结果映射对象
	 * @return 列表
	 */
	public <T> List<T> queryListBySql(LKSqlVo sqlVo, Class<T> clazz);


	/**
	 * 获取对象
	 * @param sqlVo 查询条件对象
	 * @param clazz 查询结果映射对象
	 * @return 对象
	 */
	public <T> T queryOneBySql(LKSqlVo sqlVo, Class<T> clazz);


	/**
	 * 查询分页
	 * @param sqlVo 查询对象
	 * @param clazz 查询结果映射对象
	 * @param pageable 分页信息
	 * @return 分页
	 */
	public <T> Page<T> queryPageBySql(LKSqlVo sqlVo, Class<T> clazz, Pageable pageable);


	/**
	 * 获取字符串（必须使用select count(1) as one from t的形式）
	 * @param sqlVo 查询条件对象
	 * @return 字符串
	 */
	public String queryStringBySql(LKSqlVo sqlVo);


	/**
	 * 查询列表
	 * @param sqlVo 查询对象
	 * @param clazz 查询结果映射对象
	 * @return 列表
	 */
	public <T> List<T> findListByHql(LKSqlVo sqlVo, Class<T> clazz);


	/**
	 * 查询分页
	 * @param sqlVo 查询对象
	 * @param clazz 查询结果映射对象
	 * @param pageable 分页信息
	 * @return 分页
	 */
	public <T> Page<T> findPageByHql(LKSqlVo sqlVo, Class<T> clazz, Pageable pageable);


	/**
	 * 获取对象
	 * @param sqlVo 查询条件对象
	 * @param clazz 查询结果映射对象
	 * @return 对象
	 */
	public <T> T findOneByHql(LKSqlVo sqlVo, Class<T> clazz);


	/**
	 * 获取对象
	 * @param clazz 查询结果映射对象
	 * @param id 主键
	 * @return 对象
	 */
	public <T> T findOneById(Class<T> clazz, String id);


	/**
	 * 获取字符串
	 * @param sqlVo 查询条件对象
	 * @return 字符串
	 */
	public String findStringByHql(LKSqlVo sqlVo);


	/**
	 * 保存对象
	 * @param obj 对象
	 * @param merge true：调用merge方法；false：调用persist方法。
	 * @return 对象
	 */
	public <T> T save(Object obj, boolean merge);


	/**
	 * 保存对象（merge方法）
	 * @param obj 对象
	 * @return 对象
	 */
	public <T> T save(Object obj);


	/**
	 * 保存对象
	 * @param obj 对象
	 * @return 对象
	 */
	public <T> T merge(Object obj);


	/**
	 * 保存对象
	 * @param obj 对象
	 * @return 对象
	 */
	public <T> T persist(Object obj);


	/**
	 * 删除对象
	 * @param obj 对象
	 */
	public void remove(Object obj);


	/**
	 * 执行更新
	 * @param sqlVo 更新条件对象
	 * @return 影响的条数
	 */
	public int executeUpdate(LKSqlVo sqlVo);

}
