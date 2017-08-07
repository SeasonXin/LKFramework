package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

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
public class LKMappedUserEntity extends LKMappedBaseEntity implements LKUserInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666660005L;

	/** 业务ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_BUS_ID)
	private String busId;

	/** 姓名 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_NAME)
	private String userName;

	/** 身份证号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ENCRYPT)
	private String userCard;

	/** 性别 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	@Enumerated(EnumType.STRING)
	private LKGenderEnum gender;

	/** 生日（yyyy-MM-dd）。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_DATE)
	private String birthday;

	/** 出生地，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String birthplace;

	/** 学历，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String degree;

	/** 学位，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String education;

	/** 婚姻状态，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String maritalStatus;

	/** 民族，字典。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String nation;

	/** 照片，base64。 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String photo;

	/** 手机号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CELLPHONE)
	private String cellphone;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TELEPHONE)
	private String telephone1;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TELEPHONE)
	private String telephone2;

	/** 电话号码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_TELEPHONE)
	private String telephone3;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_URL)
	private String email;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_URL)
	private String email1;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_URL)
	private String email2;

	/** 邮箱 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_URL)
	private String email3;

	/** 备用字段1 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_VALUE)
	private String field1;

	/** 备用字段2 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_VALUE)
	private String field2;

	/** 备用字段3 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_VALUE)
	private String field3;

	/** 校验码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private String checkCode;

	/** 实名认证等级（枚举） */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_CODE)
	private LKAuthenticationEnum authentication;


	/**
	 * 更新校验码
	 */
	public void updateCheckCode() {
		setCheckCode(LKMD5Encrypter.encrypt(LKStringUtils.trimToEmpty(getUserName()) + LKStringUtils.trimToEmpty(getCellphone()) + LKStringUtils.trimToEmpty(getEmail()) + LKStringUtils.trimToEmpty(getUserCard()), LKStringStatics.STR_CHARSET_UTF_8, LKStringUtils.trimToEmpty(getBusId())));
	}

}
