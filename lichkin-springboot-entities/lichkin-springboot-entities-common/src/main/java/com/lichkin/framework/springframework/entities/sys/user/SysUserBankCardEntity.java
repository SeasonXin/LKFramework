package com.lichkin.framework.springframework.entities.sys.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.security.md5.LKMD5Encrypter;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户银行卡表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER_BANK_CARD")
@Getter
@Setter
public final class SysUserBankCardEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -3449406169653760707L;

	/** 用户ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String userId;

	/** 登录ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String loginId;

	/** 银行卡绑定Id */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String bankcardId;

	/** 会员ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String memberId;

	/** 银行编号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String bankCode;

	/** 银行名称 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 100)
	private String bankName;

	/** 支行名称 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 100)
	private String bankBranch;

	/** 银行卡号掩码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String bankAccountNumMask;

	/** 户名 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 50)
	private String realName;

	/** 省份 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String province;

	/** 城市 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String city;

	/** 卡类型 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String cardType;

	/** 卡属性 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String cardAttribute;

	/** 是否认证 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String isVerified;

	/** 别名 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 50)
	private String alias;

	/** 银行卡皮肤 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String cardSkin;

	/** 是否签约（Y是 N否） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String isSigning;

	/** 状态 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String status;

	/** 扩展信息 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 200)
	private String extention;

	/** 支付属性 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String payAttribute;

	/** 证件类型IC：身份证 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String certType;

	/** 证件号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 18)
	private String certNum;

	/** 手机号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 11)
	private String mobileNum;

	/** 激活时间 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 19)
	private String activateDate;

	/** 渠道编码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String channelCode;

	/** 联行号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String branchNo;

	/** 卡验证时间 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String cardValidDate;

	/** 更新时间 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 19)
	private String updateTime;

	/** 金融卡 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 50)
	private String financialCard;

	/** 校验码 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 32)
	private String checkCode;

	/**
	 * 更新校验码
	 */
	public void updateCheckCode() {
		setCheckCode(LKMD5Encrypter.encrypt(LKStringUtils.trimToEmpty(getBankCode()) + LKStringUtils.trimToEmpty(getCertNum()) + LKStringUtils.trimToEmpty(getMobileNum()), LKStringStatics.STR_CHARSET_UTF_8, LKStringUtils.trimToEmpty(getUserId())));
	}

}
