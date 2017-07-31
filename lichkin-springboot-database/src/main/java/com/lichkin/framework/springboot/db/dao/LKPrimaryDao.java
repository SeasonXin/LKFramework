package com.lichkin.framework.springboot.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 * 主数据库访问类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component("dao")
public class LKPrimaryDao extends LKBaseDao {

	/** 实体类管理类对象 */
	@PersistenceContext(unitName = "primaryPersistenceUnit")
	private EntityManager entityManager;


	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
