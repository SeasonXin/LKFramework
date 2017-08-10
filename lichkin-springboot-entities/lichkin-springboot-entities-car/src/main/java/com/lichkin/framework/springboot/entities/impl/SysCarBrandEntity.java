package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedNormalEntity;

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
public class SysCarBrandEntity extends LKMappedNormalEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668028L;

	/** 首字母 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 1)
	@JSONField(ordinal = 1)
	private String capital;

	/** 品牌ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 2)
	private String brandId;

	/** 品牌名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 3)
	private String brandName;

	/** 品牌图片 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 4)
	private String brandImg;

}
