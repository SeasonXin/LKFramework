package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

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
public class LKMappedMenuEntity extends LKMappedBaseEntity implements LKMenuInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660010L;

	/** 菜单编号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = true, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String menuCode;

	/** 菜单名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_NAME)
	private String menuName;

	/** 链接地址 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_URL)
	private String url;

	/** 父菜单编号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String parentCode;

	/** 排序号 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false)
	private Byte orderId;

	/** 图标 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String icon;

	/** 系统编码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_SYSTEM_TAG)
	private String systemTag;

	/** 是否可分配 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	@Enumerated(EnumType.STRING)
	private LKYesNoEnum assignable;

}
