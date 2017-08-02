package com.lichkin.framework.springframework.entities.sys.admin;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedUserEntity;

/**
 * 管理员用户表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_ADMIN")
public class SysAdminEntity extends LKMappedUserEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 305693792022944374L;

}
