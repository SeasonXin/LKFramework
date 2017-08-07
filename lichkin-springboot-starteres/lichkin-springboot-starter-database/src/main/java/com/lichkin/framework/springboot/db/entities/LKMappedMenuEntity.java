package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKMenuInterface;
import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;

import lombok.Getter;
import lombok.Setter;

/**
 * 菜单表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedMenuEntity extends LKMappedBaseEntity implements LKMenuInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660010L;

	/** 菜单编号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = true, length = LENGTH_CODE)
	@JSONField(ordinal = 1)
	private String menuCode;

	/** 菜单名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 2)
	private String menuName;

	/** 链接地址 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 3)
	private String url;

	/** 父菜单编号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String parentCode;

	/** 排序号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false)
	@JSONField(ordinal = 5)
	private Byte orderId;

	/** 图标 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 6)
	private String icon;

	/** 系统编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 7)
	private String systemTag;

	/** 是否可分配 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@Enumerated(EnumType.STRING)
	@JSONField(ordinal = 8)
	private LKYesNoEnum assignable;

}
