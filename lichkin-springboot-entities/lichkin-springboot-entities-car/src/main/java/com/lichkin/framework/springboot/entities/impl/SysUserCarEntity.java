package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户车辆信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER_CAR")
@Getter
@Setter
public class SysUserCarEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668027L;

	/** 用户ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 1)
	private String userId;

	/** 品牌ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 2)
	private String brandId;

	/** 系列ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 3)
	private String seriseId;

	/** 型号ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 4)
	private String modelId;

	/** 车牌号（省份码） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 5)
	private String licensePlateHeader;

	/** 车牌号（号码） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 6)
	private String licensePlateNumber;

	/** 发动机号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 7)
	private String engineNumber;

	/** 车架号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 8)
	private String frameNumber;

	/** 默认车辆 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 9)
	private LKYesNoEnum defaultCar;

}
