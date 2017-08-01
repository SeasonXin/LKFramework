package com.lichkin.framework.springframework.entities.sys.sc;

import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_BUS_TYPE;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_CELLPHONE;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_CODE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信验证码表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_SECURITY_CODE")
@Getter
@Setter
public class SysSecurityCodeEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668001L;

	/** 业务类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_TYPE)
	private String busType;

	/** 手机号码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CELLPHONE)
	private String cellphone;

	/** 验证码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CODE)
	private String securityCode;

}
