package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedUserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER")
@Getter
@Setter
public final class SysUserEntity extends LKMappedUserEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668006L;

}
