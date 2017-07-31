package com.lichkin.framework.springboot.db.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.lichkin.framework.bases.LKDatas;

import net.sf.json.JSONObject;

/**
 * 分页工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPageUtils {

	/**
	 * 获取分页信息
	 * @param datas 数据
	 * @return 分页信息
	 */
	@SuppressWarnings("unchecked")
	public static Pageable getPageable(LKDatas datas) {
		if (datas.containsKey(null)) {
			datas = new LKDatas(JSONObject.fromObject(datas.getMap().get(null)));
		}
		final PageRequest pageRequest = new PageRequest(LKPageUtils.getPageNumber(datas), LKPageUtils.getPageSize(datas));
		return pageRequest;
	}


	/**
	 * 获取分页信息
	 * @param datas 数据
	 * @param sort 排序
	 * @return 分页信息
	 */
	public static Pageable getPageable(final LKDatas datas, final Sort sort) {
		return new PageRequest(LKPageUtils.getPageNumber(datas), LKPageUtils.getPageSize(datas), sort);
	}


	/**
	 * 获取分页信息
	 * @param datas 数据
	 * @param limit 每页数据量
	 * @return 分页信息
	 */
	public static Pageable getPageable(final LKDatas datas, final int limit) {
		return new PageRequest(LKPageUtils.getPageable(datas).getPageNumber(), limit);
	}


	/**
	 * 获取分页页码
	 * @param datas 数据
	 * @return 分页页码
	 */
	public static int getPageNumber(final LKDatas datas) {
		Integer page = datas.getInteger("page", null);
		if ((page == null) || (page < 1)) {
			page = 1;
		}
		return page;
	}


	/**
	 * 获取分页大小
	 * @param datas 数据
	 * @return 分页大小
	 */
	public static int getPageSize(final LKDatas datas) {
		Integer limit = datas.getInteger("limit", null);
		if (limit == null) {
			limit = datas.getInteger("rows", null);
		}
		if ((limit == null) || (limit <= 0)) {
			limit = 25;
		}
		return limit;
	}

}
