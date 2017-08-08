package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 定时任务表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CONFIG_QUARTZ")
@Getter
@Setter
public final class SysConfigQuartzEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668001L;

	/** 组名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 1)
	private String groupName;

	/** 任务名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 2)
	private String jobName;

	/** 类名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 3)
	private String className;

	/** 方法名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 4)
	private String methodName;

	/** 表达式 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 5)
	private String cronExpression;

}
