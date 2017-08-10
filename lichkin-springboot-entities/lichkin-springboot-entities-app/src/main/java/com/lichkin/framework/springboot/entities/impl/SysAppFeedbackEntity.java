package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.enums.LKLoginChannelEnum;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端反馈表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_APP_FEEDBACK")
@Getter
@Setter
public final class SysAppFeedbackEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668018L;

	/** 客户端名称 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 1)
	private String appName;

	/** 客户端类型 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 2)
	private LKLoginChannelEnum platform;

	/** 当前版本，V1.0.0。 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 3)
	private String currentAppVersion;

	/** 用户ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 4)
	private String userId;

	/** 联系方式 */
	@Column(insertable = true, updatable = false, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 5)
	private String contactWay;

	/** 反馈文件IDs */
	@Column(insertable = true, updatable = false, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 6)
	private String feedbackFileIds;

}
