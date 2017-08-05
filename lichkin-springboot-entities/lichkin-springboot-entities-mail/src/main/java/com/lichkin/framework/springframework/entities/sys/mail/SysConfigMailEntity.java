package com.lichkin.framework.springframework.entities.sys.mail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = -2327555002537329681L;

	/** 是否使用认证 */
	private boolean auth;

	/** 邮件业务编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String busCode;

	/** 发件人邮件主机 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromHost;

	/** 发件人邮件端口 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromPort;

	/** 发件人用户名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromUserName;

	/** 发件人密码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromPassword;

	/** 发件人地址 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromAddress;

	/** 发件人显示名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String fromDisplayName;

	/** 邮件主题 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_NAME)
	private String subject;

	/** 邮件内容 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String content;

}
