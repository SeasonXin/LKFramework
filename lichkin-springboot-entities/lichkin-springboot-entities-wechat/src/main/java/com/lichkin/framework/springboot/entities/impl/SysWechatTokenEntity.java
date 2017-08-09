package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

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
	private static final long serialVersionUID = 8888886666668025L;

	/** 微信全局唯一票据 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LENGTH_REMARKS)
	@JSONField(ordinal = 1)
	private String accessToken;

	/** 凭证有效时间，单位：秒 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	@JSONField(ordinal = 2)
	private Integer expiresIn;

	/** 获取凭证时间 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_TIME)
	@JSONField(ordinal = 3)
	private String requestTime;

	/** 凭证类型。0：accessToken，1：jsapi_ticket。 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	@JSONField(ordinal = 4)
	private Byte tokenType;

}
