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
 * 邮件记录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_MAIL_LOG")
@Getter
@Setter
public class SysMailLogEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668003L;

	/** 发件人地址 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 1)
	private String fromAddress;

	/** 邮件主题 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	@JSONField(ordinal = 2)
	private String subject;

	/** 邮件内容 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 3)
	private String content;

	/** 收件人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 4)
	private String tos;

	/** 抄送人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 5)
	private String ccs;

	/** 暗送人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 6)
	private String bccs;

	/** 附件 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	@JSONField(ordinal = 7)
	private String attachments;

	/** 发送时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TIME)
	@JSONField(ordinal = 8)
	private String sendTime;

	/** 校验码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	@JSONField(ordinal = 9)
	private String checkCode;

}
