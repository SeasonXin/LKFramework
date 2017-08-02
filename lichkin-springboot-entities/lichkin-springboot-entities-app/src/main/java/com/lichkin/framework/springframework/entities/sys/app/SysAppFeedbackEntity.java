package com.lichkin.framework.springframework.entities.sys.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lichkin.framework.bases.enums.LKLoginChannelEnum;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端反馈表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_APP_FEEDBACK")
@Getter
@Setter
public final class SysAppFeedbackEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 7584358803840175098L;

	/** 客户端名称 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 50)
	private String appName;

	/** 客户端类型 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private LKLoginChannelEnum platform;

	/** 当前版本，V1.0.0。 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 10)
	private String currentAppVersion;

	/** 用户ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_ID)
	private String userId;

	/** 联系方式 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 200)
	private String contactWay;

	/** 反馈文件IDs */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 200)
	private String feedbackFileIds;

}
