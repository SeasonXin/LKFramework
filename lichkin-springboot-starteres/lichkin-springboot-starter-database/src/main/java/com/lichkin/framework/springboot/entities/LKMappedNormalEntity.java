package com.lichkin.framework.springboot.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.bases.entities.LKNormalInterface;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.utils.lang.LKStringUtils;

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
	private static final long serialVersionUID = -8888886666660001L;

	/** 在用状态 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_STATUS)
	@Enumerated(EnumType.STRING)
	@JSONField(ordinal = ORDINAL_USING_STATUS)
	private LKUsingStatusEnum usingStatus = LKUsingStatusEnum.STAND_BY;

	/** 备注信息 */
	@JSONField(ordinal = ORDINAL_REMARKS)
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = LENGTH_REMARKS)
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
