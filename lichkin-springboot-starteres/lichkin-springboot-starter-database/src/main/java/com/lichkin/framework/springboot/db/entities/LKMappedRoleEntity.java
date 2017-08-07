package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKRoleInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedRoleEntity extends LKMappedBaseEntity implements LKRoleInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660008L;

	/** 角色名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 1)
	private String roleName;

	/** 描述 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 2)
	private String description;

	/** 系统编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 3)
	private String systemTag;

}
