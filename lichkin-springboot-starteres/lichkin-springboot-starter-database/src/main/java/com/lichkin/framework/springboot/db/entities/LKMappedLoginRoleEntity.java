package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKLoginRoleInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录&amp;角色关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedLoginRoleEntity extends LKMappedBaseEntity implements LKLoginRoleInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660007L;

	/** 登录ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 1)
	private String loginId;

	/** 角色ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 2)
	private String roleId;

}
