package com.lichkin.framework.springframework.entities.sys.oper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统操作日志表
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_OPER_LOG")
@Getter
@Setter
public class SysOperLogEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -1486441850625894289L;

	/** 请求ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String requestId;

	/** 请求时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 20)
	private String requestTime;

	/** 请求IP */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String requestIp;

	/** 请求URL */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 255)
	private String requestUrl;

	/** 请求数据 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 1000)
	private String requestDatas;

	/** 系统编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 100)
	private String systemTag;

	/** 操作类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 10)
	private String operType;

	/** 业务操作类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 50)
	private String busType;

	/** 业务操作类型名称 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 50)
	private String busTypeName;

	/** 操作人登录ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String operLoginId;

	/** 操作人姓名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 50)
	private String operUserName;

	/** 备注信息，如实际删除数据时，需将删除数据的数据记录。 */
	@Column(insertable = true, updatable = false, nullable = true, unique = false, length = 2000)
	private String remarks;

}
