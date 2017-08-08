package com.lichkin.framework.springframework.entities.sys.auth;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.entities.LKMappedRoleEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ROLE")
@Getter
@Setter
public final class SysRoleEntity extends LKMappedRoleEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668009L;

}
