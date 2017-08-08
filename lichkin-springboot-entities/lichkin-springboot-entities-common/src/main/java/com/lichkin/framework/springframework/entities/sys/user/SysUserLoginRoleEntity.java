package com.lichkin.framework.springframework.entities.sys.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedLoginRoleEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录&amp;角色关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER_LOGIN_ROLE")
@Getter
@Setter
public final class SysUserLoginRoleEntity extends LKMappedLoginRoleEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668008L;

}
