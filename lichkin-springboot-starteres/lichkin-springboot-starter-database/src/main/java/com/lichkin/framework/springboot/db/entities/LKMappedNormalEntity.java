package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKNormalInterface;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONFieldOrdinal;

import lombok.Getter;
import lombok.Setter;

/**
 * 一般业务实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Getter
@Setter
public class LKMappedNormalEntity extends LKMappedIDEntity implements LKNormalInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = -6245232913948511823L;

	/** 在用状态 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LKEntityFieldLengthStatics.LENGTH_STATUS)
	@Enumerated(EnumType.STRING)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_USING_STATUS)
	private LKUsingStatusEnum usingStatus = LKUsingStatusEnum.STAND_BY;

	/** 备注信息 */
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_REMARKS)
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LKEntityFieldLengthStatics.LENGTH_REMARKS)
	private String remarks;


	/**
	 * 增加备注信息
	 * @param remarks 备注信息
	 */
	public void appendRemarks(final String remarks) {
		if (LKStringUtils.isBlank(this.remarks)) {
			this.remarks = remarks;
		} else {
			this.remarks = this.remarks + "---" + remarks;
		}
	}

}
