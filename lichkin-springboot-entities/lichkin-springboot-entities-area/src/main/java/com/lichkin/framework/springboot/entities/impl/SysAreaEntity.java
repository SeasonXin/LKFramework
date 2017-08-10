package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 区域表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_AREA")
@Getter
@Setter
public class SysAreaEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668019L;

	/** 区域名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 1)
	private String areaName;

	/** 区域等级 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 2)
	private String areaLevel;

	/** 电话号码编码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 3)
	private String telephoneCode;

	/** 身份证号码编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String userCardCode;

}
