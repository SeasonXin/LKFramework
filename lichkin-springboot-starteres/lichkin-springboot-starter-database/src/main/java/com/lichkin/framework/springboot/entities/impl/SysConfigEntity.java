package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.entities.LKMappedNormalEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统配置表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CONFIG")
@Getter
@Setter
public final class SysConfigEntity extends LKMappedNormalEntity implements LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668000L;

	/** 系统编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 1)
	private String systemTag;

	/** 配置键 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 2)
	private String configKey;

	/** 配置值 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 3)
	private String configValue;

}
