package com.lichkin.framework.springframework.entities.sys.quartz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 定时任务表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_QUARTZ")
@Getter
@Setter
public final class SysQuartzEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -353107006539544053L;

	/** 任务名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String jobName;

	/** 方法名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String methodName;

	/** 组名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String groupName;

	/** 类名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String className;

	/** 表达式 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String cronExpression;

}
