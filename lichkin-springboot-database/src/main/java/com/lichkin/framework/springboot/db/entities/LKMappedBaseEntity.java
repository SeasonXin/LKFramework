package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKBaseInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONFieldOrdinal;

import lombok.Getter;
import lombok.Setter;

/**
 * 一般业务实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedBaseEntity extends LKMappedNormalEntity implements LKBaseInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = -6818791372430403579L;

	/** 禁用注入 */
	@Transient
	private boolean disableInject = false;

	/** 新增操作系统编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_INSERT_SYSTEM_TAG)
	private String insertSystemTag;

	/** 新增操作时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TIME)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_INSERT_TIME)
	private String insertTime;

	/** 新增操作人登录ID */
	@Column(insertable = true, updatable = false, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ID)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_INSERT_LOGIN_ID)
	private String insertLoginId;

	/** 更新操作系统编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_UPDATE_SYSTEM_TAG)
	private String updateSystemTag;

	/** 更新操作时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TIME)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_UPDATE_TIME)
	private String updateTime;

	/** 更新操作人登录ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ID)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_UPDATE_LOGIN_ID)
	private String updateLoginId;

}
