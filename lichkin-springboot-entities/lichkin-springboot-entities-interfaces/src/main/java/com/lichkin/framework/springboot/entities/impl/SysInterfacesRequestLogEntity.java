package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求参数日志表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_INTERFACES_REQUEST_LOG")
@Getter
@Setter
public class SysInterfacesRequestLogEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668016L;

	/** 请求ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 1)
	private String requestId;

	/** 请求时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_TIME_ALL)
	@JSONField(ordinal = 2)
	private String requestTime;

	/** 请求IP */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 3)
	private String requestIp;

	/** 请求URL */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 4)
	private String requestUrl;

	/** 请求用户名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 5)
	private String callerName;

	/** 请求密码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 6)
	private String password;

	/** 请求数据 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 7)
	private String requestDatas;

}
