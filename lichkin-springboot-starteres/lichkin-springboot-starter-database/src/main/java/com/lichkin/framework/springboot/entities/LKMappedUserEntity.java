package com.lichkin.framework.springboot.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKUserInterface;
import com.lichkin.framework.bases.enums.LKAuthenticationEnum;
import com.lichkin.framework.bases.enums.LKGenderEnum;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.security.md5.LKMD5Encrypter;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedUserEntity extends LKMappedBaseEntity implements LKUserInterface, LKEntityFieldLengthStatics {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660005L;

	/** 业务ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 1)
	private String busId;

	/** 姓名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 2)
	private String userName;

	/** 身份证号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_ENCRYPT)
	@JSONField(ordinal = 3)
	private String userCard;

	/** 性别 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@Enumerated(EnumType.STRING)
	@JSONField(ordinal = 4)
	private LKGenderEnum gender;

	/** 生日（yyyy-MM-dd）。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_DATE)
	@JSONField(ordinal = 5)
	private String birthday;

	/** 出生地，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 6)
	private String birthplace;

	/** 学历，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 7)
	private String degree;

	/** 学位，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 8)
	private String education;

	/** 婚姻状态，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 9)
	private String maritalStatus;

	/** 民族，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 10)
	private String nation;

	/** 照片，base64。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 11)
	private String photo;

	/** 手机号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CELLPHONE)
	@JSONField(ordinal = 12)
	private String cellphone;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_TELEPHONE)
	@JSONField(ordinal = 13)
	private String telephone1;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_TELEPHONE)
	@JSONField(ordinal = 14)
	private String telephone2;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_TELEPHONE)
	@JSONField(ordinal = 15)
	private String telephone3;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 16)
	private String email;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 17)
	private String email1;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 18)
	private String email2;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 19)
	private String email3;

	/** 备用字段1 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 20)
	private String field1;

	/** 备用字段2 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 21)
	private String field2;

	/** 备用字段3 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 22)
	private String field3;

	/** 校验码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 23)
	private String checkCode;

	/** 实名认证等级（枚举） */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 24)
	private LKAuthenticationEnum authentication;


	/**
	 * 更新校验码
	 */
	public void updateCheckCode() {
		setCheckCode(LKMD5Encrypter.encrypt(LKStringUtils.trimToEmpty(getUserName()) + LKStringUtils.trimToEmpty(getCellphone()) + LKStringUtils.trimToEmpty(getEmail()) + LKStringUtils.trimToEmpty(getUserCard()), LKStringStatics.STR_CHARSET_UTF_8, LKStringUtils.trimToEmpty(getBusId())));
	}

}
