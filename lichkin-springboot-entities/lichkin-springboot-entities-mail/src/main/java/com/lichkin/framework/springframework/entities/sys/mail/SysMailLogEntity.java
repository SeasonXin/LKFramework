package com.lichkin.framework.springframework.entities.sys.mail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = -6287627962494484328L;

	/** 发件人地址 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromAddress;

	/** 邮件主题 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String subject;

	/** 邮件内容 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String content;

	/** 收件人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String tos;

	/** 抄送人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String ccs;

	/** 暗送人 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String bccs;

	/** 附件 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String attachments;

	/** 发送时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TIME)
	private String sendTime;

	/** 校验码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String checkCode;

}
