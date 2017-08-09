package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信菜单表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_WECHAT_MENU")
@Getter
@Setter
public final class SysWechatMenuEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668024L;

	/** 按钮位于菜单的横坐标 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	@JSONField(ordinal = 1)
	private Byte x;

	/** 按钮位于菜单的纵坐标 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	@JSONField(ordinal = 2)
	private Byte y;

	/** 按钮名称 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 3)
	private String btnName;

	/** 按钮类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_TYPE)
	@JSONField(ordinal = 4)
	private String btnType;

}
