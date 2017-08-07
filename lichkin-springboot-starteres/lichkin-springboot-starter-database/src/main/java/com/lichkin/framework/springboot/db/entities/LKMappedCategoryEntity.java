package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKCategoryInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 类目表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedCategoryEntity extends LKMappedNormalEntity implements LKCategoryInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660003L;

	/** 类目编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LENGTH_CODE)
	@JSONField(ordinal = 1)
	private String categoryCode;

	/** 类目值 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 2)
	private String categoryValue;

	/** 类目名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 3)
	private String categoryName;

	/** 父类目编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String parentCode;

}
