package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.enums.LKLoginChannelEnum;
import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端版本表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_APP_VERSION")
@Getter
@Setter
public final class SysAppVersionEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668017L;

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

	/** 是否强制更新，表示当前版本是否需要被强制更新，可以精确定位到哪个版本是必须要被强制更新的，而不影响其他的版本。（0：否；1：是） */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@Enumerated(EnumType.STRING)
	@JSONField(ordinal = 4)
	private LKYesNoEnum forceUpdate;

	/** 新版本简介（用于在客户端的显示） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 5)
	private String brief;

	/** 安卓客户端下载地址 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 6)
	private String url;

}
