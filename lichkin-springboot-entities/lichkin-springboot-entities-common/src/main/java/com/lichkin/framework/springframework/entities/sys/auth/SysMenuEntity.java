package com.lichkin.framework.springframework.entities.sys.auth;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedMenuEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 菜单表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_MENU")
@Getter
@Setter
public final class SysMenuEntity extends LKMappedMenuEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 5572192152127075685L;

}
