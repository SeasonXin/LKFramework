package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

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
public class LKMappedRoleEntity extends LKMappedBaseEntity implements LKRoleInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 1932979295151403129L;

	/** 角色名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_NAME)
	private String roleName;

	/** 描述 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_VALUE)
	private String description;

	/** 系统编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_SYSTEM_TAG)
	private String systemTag;

}
