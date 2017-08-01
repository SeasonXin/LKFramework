package com.lichkin.framework.springframework.entities.sys.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
public class SysCarModelEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -6076906914609627541L;

	/** 品牌ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String brandId;

	/** 品牌名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 200)
	private String brandName;

	/** 系列ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String seriseId;

	/** 系列名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 200)
	private String seriseName;

	/** 型号ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String modelId;

	/** 型号名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 200)
	private String modelName;

	/** 销售年份 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 10)
	private String saleYear;

	/** 销售版本 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 100)
	private String saleVersion;

	/** 排量 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 10)
	private String displacement;

	/** 指导价 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 20)
	private String guidePrice;

	/** 生产方式（国产、合资、进口） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 10)
	private String productionWay;

	/** 生产状态（在产、停产） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 10)
	private String productionState;

	/** 在用状态 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	@Enumerated(EnumType.STRING)
	private LKUsingStatusEnum usingStatus;

}
