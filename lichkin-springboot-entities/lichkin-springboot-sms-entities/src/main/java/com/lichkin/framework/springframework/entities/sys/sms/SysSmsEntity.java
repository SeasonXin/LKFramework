package com.lichkin.framework.springframework.entities.sys.sms;

import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_BUS_TYPE;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_CELLPHONE;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_SYSTEM_TAG;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_TIME;
import static com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics.LENGTH_VALUE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_SMS")
@Getter
@Setter
public class SysSmsEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668002L;

	/** 系统标识 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_SYSTEM_TAG)
	private String systemTag;

	/** 业务类型 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_TYPE)
	private String busType;

	/** 手机号码 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_CELLPHONE)
	private String cellphone;

	/** 短信信息 */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_VALUE)
	private String message;

	/** 发送时间（yyyy-MM-dd HH:ss:mm） */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_TIME)
	private String sendTime;

}
