package com.lichkin.framework.springframework.entities.sys.interfaces;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = 3568305981885038445L;

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

	/** 请求用户名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String callerName;

	/** 请求密码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String password;

	/** 请求数据 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 1000)
	private String requestDatas;

}
