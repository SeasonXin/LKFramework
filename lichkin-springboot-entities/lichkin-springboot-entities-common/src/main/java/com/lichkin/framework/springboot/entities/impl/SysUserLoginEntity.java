package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedUserLoginEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER_LOGIN")
@Getter
@Setter
public final class SysUserLoginEntity extends LKMappedUserLoginEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668007L;

}
