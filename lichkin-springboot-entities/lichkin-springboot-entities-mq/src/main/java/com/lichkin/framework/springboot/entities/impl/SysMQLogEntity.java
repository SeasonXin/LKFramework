package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息队列记录表
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_MQ_LOG")
@Getter
@Setter
public class SysMQLogEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668026L;

	/** 读取时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_TIME)
	@JSONField(ordinal = 1)
	private String readTime;

	/** 消息ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LENGTH_VALUE)
	@JSONField(ordinal = 2)
	private String msgId;

	/** 处理ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 3)
	private String handleId;

	/** 消息详情 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 4)
	private String msgDetail;

	/** 处理结束 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 5)
	private LKYesNoEnum handleFinished;

	/** 消息text信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 6)
	private String textInfo;

	/** 消息value信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 7)
	private String valueInfo;

}
