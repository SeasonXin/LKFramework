package com.lichkin.framework.springframework.entities.sys.wechat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = 8841956773270967039L;

	/** 按钮位于菜单的横坐标 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	private Byte x;

	/** 按钮位于菜单的纵坐标 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	private Byte y;

	/** 按钮名称 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 10)
	private String btnName;

	/** 按钮类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 5)
	private String btnType;

}
