package com.lichkin.framework.springboot.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKDictionaryInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 字典表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedDictionaryEntity extends LKMappedNormalEntity implements LKDictionaryInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660004L;

	/** 类目编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 1)
	private String categoryCode;

	/** 字典编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 2)
	private String dictCode;

	/** 字典值 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 3)
	private String dictValue;

	/** 字典名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 4)
	private String dictName;

	/** 排序号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false)
	@JSONField(ordinal = 5)
	private Byte orderId;

}
