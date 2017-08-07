package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKUserLoginInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.security.md5.LKMD5Encrypter;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedUserLoginEntity extends LKMappedBaseEntity implements LKUserLoginInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660006L;

	/** 业务ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 1)
	private String busId;

	/** 用户ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_ID)
	@JSONField(ordinal = 2)
	private String userId;

	/** 身份证号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = true, length = LENGTH_ENCRYPT)
	@JSONField(ordinal = 3)
	private String userCard;

	/** 登录名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = true, length = LENGTH_CODE)
	@JSONField(ordinal = 4)
	private String loginName;

	/** 手机号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = true, length = LENGTH_CELLPHONE)
	@JSONField(ordinal = 5)
	private String cellphone;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = true, length = LENGTH_URL)
	@JSONField(ordinal = 6)
	private String email;

	/** 密码 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 7)
	private String pwd;

	/** 验证码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 8)
	private String securityCode;

	/** 密码错误次数 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false)
	@JSONField(ordinal = 9)
	private Byte errorTimes;

	/** 系统编码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	@JSONField(ordinal = 10)
	private String systemTag;

	/** 登录token */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_ENCRYPT)
	@JSONField(ordinal = 11)
	private String token;

	/** 备用字段1 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 12)
	private String field1;

	/** 备用字段2 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 13)
	private String field2;

	/** 备用字段3 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 14)
	private String field3;

	/** 校验码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 15)
	private String checkCode;


	/**
	 * 更新校验码
	 */
	public void updateCheckCode() {
		setCheckCode(LKMD5Encrypter.encrypt(LKStringUtils.trimToEmpty(getLoginName()) + LKStringUtils.trimToEmpty(getCellphone()) + LKStringUtils.trimToEmpty(getEmail()) + LKStringUtils.trimToEmpty(getUserCard()), LKStringStatics.STR_CHARSET_UTF_8, LKStringUtils.trimToEmpty(getBusId())));
	}

}
