package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedUserEntity;

/**
 * 管理员用户表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ADMIN")
public class SysAdminEntity extends LKMappedUserEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668020L;

}
