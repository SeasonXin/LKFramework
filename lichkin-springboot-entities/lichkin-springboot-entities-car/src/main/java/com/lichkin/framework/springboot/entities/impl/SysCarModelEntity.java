package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedNormalEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 车型表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CAR_MODEL")
@Getter
@Setter
public class SysCarModelEntity extends LKMappedNormalEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668029L;

	/** 品牌ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 1)
	private String brandId;

	/** 品牌名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 2)
	private String brandName;

	/** 系列ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 3)
	private String seriseId;

	/** 系列名 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 4)
	private String seriseName;

	/** 型号ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 5)
	private String modelId;

	/** 型号名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 6)
	private String modelName;

	/** 销售年份 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_DATE)
	@JSONField(ordinal = 7)
	private String saleYear;

	/** 销售版本 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 8)
	private String saleVersion;

	/** 排量 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 9)
	private String displacement;

	/** 指导价 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 10)
	private String guidePrice;

	/** 生产方式（国产、合资、进口） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 11)
	private String productionWay;

	/** 生产状态（在产、停产） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 12)
	private String productionState;

}
