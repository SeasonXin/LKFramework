package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_SMS")
@Getter
@Setter
public class SysSmsEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668005L;

	/** 系统标识 */
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

	/** 短信信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 4)
	private String message;

	/** 发送时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_TIME)
	@JSONField(ordinal = 5)
	private String sendTime;

}
