package com.lichkin.framework.springframework.entities.sys.auth;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedRoleMenuEntity;

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
	private static final long serialVersionUID = -5645045335113902536L;

}
