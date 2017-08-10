package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedLoginRoleEntity;

/**
 * 管理员用户登录&amp;角色关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ADMIN_LOGIN_ROLE")
public final class SysAdminLoginRoleEntity extends LKMappedLoginRoleEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668022L;

}
