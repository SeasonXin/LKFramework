package com.lichkin.framework.springframework.entities.sys.admin;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedUserLoginEntity;

/**
 * 管理员用户登录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ADMIN_LOGIN")
public class SysAdminLoginEntity extends LKMappedUserLoginEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1255969692877688672L;

}
