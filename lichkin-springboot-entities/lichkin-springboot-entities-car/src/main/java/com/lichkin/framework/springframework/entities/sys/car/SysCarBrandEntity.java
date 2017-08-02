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
 * 车品牌表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CAR_BRAND")
@Getter
@Setter
public class SysCarBrandEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -5945584116264683653L;

	/** 首字母 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 1)
	private String capital;

	/** 品牌ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 1000)
	private String brandId;

	/** 品牌名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 50)
	private String brandName;

	/** 品牌图片 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 100)
	private String brandImg;

	/** 在用状态 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	@Enumerated(EnumType.STRING)
	private LKUsingStatusEnum usingStatus;

}
