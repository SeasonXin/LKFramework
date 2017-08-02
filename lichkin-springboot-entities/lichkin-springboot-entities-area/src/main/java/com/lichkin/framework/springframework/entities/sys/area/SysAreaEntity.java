package com.lichkin.framework.springframework.entities.sys.area;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 区域表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_AREA")
@Getter
@Setter
public class SysAreaEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1542877084971159044L;

	/** 区域名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String areaName;

	/** 区域等级 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private String areaLevel;

	/** 电话号码编码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 6)
	private String telephoneCode;

	/** 身份证号码编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 6)
	private String userCardCode;

}
