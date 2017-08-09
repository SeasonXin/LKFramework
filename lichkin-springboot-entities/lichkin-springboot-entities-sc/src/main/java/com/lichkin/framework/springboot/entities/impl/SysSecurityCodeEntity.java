package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信验证码表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_SECURITY_CODE")
@Getter
@Setter
public class SysSecurityCodeEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668004L;

	/** 系统编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 1)
	private String systemTag;

	/** 业务类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_TYPE)
	@JSONField(ordinal = 2)
	private String busType;

	/** 手机号码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CELLPHONE)
	@JSONField(ordinal = 3)
	private String cellphone;

	/** 验证码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String securityCode;

}
