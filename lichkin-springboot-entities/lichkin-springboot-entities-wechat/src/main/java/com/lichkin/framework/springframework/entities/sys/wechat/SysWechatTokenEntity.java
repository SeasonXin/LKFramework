package com.lichkin.framework.springframework.entities.sys.wechat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信access_token实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_WECHAT_TOKEN")
@Getter
@Setter
public final class SysWechatTokenEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -4042341392558604226L;

	/** 微信全局唯一票据 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = 512)
	private String accessToken;

	/** 凭证有效时间，单位：秒 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	private Integer expiresIn;

	/** 获取凭证时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 19)
	private String requestTime;

	/** 凭证类型。0：accessToken，1：jsapi_ticket。 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	private Byte tokenType;

}
