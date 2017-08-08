package com.lichkin.framework.springboot.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
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
public class LKMappedRoleMenuEntity extends LKMappedBaseEntity implements LKRoleMenuInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660009L;

	/** 角色ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 1)
	private String roleId;

	/** 菜单ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 2)
	private String menuId;

}
