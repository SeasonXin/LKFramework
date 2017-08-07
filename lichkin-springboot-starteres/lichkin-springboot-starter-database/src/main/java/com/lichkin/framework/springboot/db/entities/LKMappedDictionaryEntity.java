package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

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
public class LKMappedDictionaryEntity extends LKMappedNormalEntity implements LKDictionaryInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660004L;

	/** 类目编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String categoryCode;

	/** 字典编号 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String dictCode;

	/** 字典值 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_VALUE)
	private String dictValue;

	/** 字典名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_NAME)
	private String dictName;

	/** 排序号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false)
	private Byte orderId;

}
