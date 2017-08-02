package com.lichkin.framework.springframework.entities.sys.mq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = -737413901136739657L;

	/** 读取时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 19)
	private String readTime;

	/** 消息ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = 100)
	private String msgId;

	/** 处理ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = 32)
	private String handleId;

	/** 消息详情 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 2000)
	private String msgDetail;

	/** 处理结束 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private LKYesNoEnum handleFinished;

	/** 消息text信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 2000)
	private String textInfo;

	/** 消息value信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 2000)
	private String valueInfo;

}
