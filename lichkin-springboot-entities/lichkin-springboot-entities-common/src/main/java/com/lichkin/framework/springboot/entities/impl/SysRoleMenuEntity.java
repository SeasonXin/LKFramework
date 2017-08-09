package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedRoleMenuEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色&amp;菜单关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ROLE_MENU")
@Getter
@Setter
public final class SysRoleMenuEntity extends LKMappedRoleMenuEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668010L;

}
