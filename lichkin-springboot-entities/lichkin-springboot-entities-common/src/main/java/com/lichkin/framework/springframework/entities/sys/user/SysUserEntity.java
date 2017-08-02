package com.lichkin.framework.springframework.entities.sys.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lichkin.framework.bases.enums.LKAuthenticationEnum;
import com.lichkin.framework.springboot.db.entities.LKMappedUserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER")
@Getter
@Setter
public final class SysUserEntity extends LKMappedUserEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -4875725064370776937L;

	/** 实名认证等级（枚举） */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private LKAuthenticationEnum authentication;

}
