package com.lichkin.framework.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.lichkin.framework.springboot.db.dao.LKDao;

/**
 * 通用服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKDBService extends LKService {

	/** 数据库访问对象 */
	@Autowired
	protected LKDao dao;

}
