package com.lichkin.framework.springboot.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 * 从数据库访问类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component("dao2")
public class LKSecondaryDao extends LKBaseDao {

	/** 实体类管理类对象 */
	@PersistenceContext(unitName = "secondaryPersistenceUnit")
	private EntityManager entityManager;


	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
