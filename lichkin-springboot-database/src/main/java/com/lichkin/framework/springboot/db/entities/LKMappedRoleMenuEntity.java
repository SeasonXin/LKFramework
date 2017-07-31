package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.lichkin.framework.bases.entities.LKRoleMenuInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色&amp;菜单关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedRoleMenuEntity extends LKMappedBaseEntity implements LKRoleMenuInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 3616981907414016373L;

	/** 角色ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ID)
	private String roleId;

	/** 菜单ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ID)
	private String menuId;

}
