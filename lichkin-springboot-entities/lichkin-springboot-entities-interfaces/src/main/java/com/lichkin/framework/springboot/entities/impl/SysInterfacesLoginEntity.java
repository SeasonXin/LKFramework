package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口登录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_INTERFACES_LOGIN")
@Getter
@Setter
public class SysInterfacesLoginEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668015L;

	/** 系统标识 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 1)
	private String systemTag;

	/** 接口版本 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 2)
	private String interfacesVersion;

	/** 登录名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 3)
	private String loginName;

	/** 密码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String pwd;

}
