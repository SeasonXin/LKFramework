package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 邮件配置表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CONFIG_MAIL")
@Getter
@Setter
public class SysConfigMailEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668002L;

	/** 是否使用认证 */
	private boolean auth;

	/** 邮件业务编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 1)
	private String busCode;

	/** 发件人邮件主机 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 2)
	private String fromHost;

	/** 发件人邮件端口 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 3)
	private String fromPort;

	/** 发件人用户名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 4)
	private String fromUserName;

	/** 发件人密码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 5)
	private String fromPassword;

	/** 发件人地址 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 6)
	private String fromAddress;

	/** 发件人显示名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 7)
	private String fromDisplayName;

	/** 邮件主题 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 8)
	private String subject;

	/** 邮件内容 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 9)
	private String content;

}
