package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.entities.LKDictionaryInterface;
import com.lichkin.framework.springboot.entities.LKMappedDictionaryEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 字典表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_DICTIONARY")
@Getter
@Setter
public final class SysDictionaryEntity extends LKMappedDictionaryEntity implements LKDictionaryInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668013L;

}
