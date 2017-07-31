package com.lichkin.framework.springboot.services;

import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.LKDatas;

/**
 * 简单业务服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKSimpleBusinessService extends LKDBService {

	/**
	 * 新增
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	@Transactional
	public abstract Object add(final LKDatas requestDatas);


	/**
	 * 删除
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	@Transactional
	public abstract Object remove(final LKDatas requestDatas);


	/**
	 * 修改
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	@Transactional
	public abstract Object edit(final LKDatas requestDatas);


	/**
	 * 查询单条数据（使用ID查询）
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	public abstract Object getOneById(final LKDatas requestDatas);


	/**
	 * 列表查询
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	public abstract Object list(final LKDatas requestDatas);


	/**
	 * 分页查询
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 数据信息
	 */
	public abstract Object page(final LKDatas requestDatas);

}
