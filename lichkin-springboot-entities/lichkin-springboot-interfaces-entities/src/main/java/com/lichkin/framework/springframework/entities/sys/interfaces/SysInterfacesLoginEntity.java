package com.lichkin.framework.springframework.entities.sys.interfaces;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口登录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_INTERFACES_LOGIN")
@Getter
@Setter
public class SysInterfacesLoginEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 9213681874744565493L;

	/** 登录名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = 32)
	private String loginName;

	/** 密码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private String pwd;

	/** 系统标识 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 50)
	private String systemTag;

	/** 接口版本 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String interfacesVersion;

}
