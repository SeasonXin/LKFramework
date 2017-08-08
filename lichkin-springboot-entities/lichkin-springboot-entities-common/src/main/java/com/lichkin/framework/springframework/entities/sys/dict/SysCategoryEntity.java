package com.lichkin.framework.springframework.entities.sys.dict;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.bases.entities.LKCategoryInterface;
import com.lichkin.framework.springboot.entities.LKMappedCategoryEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 类目表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_CATEGORY")
@Getter
@Setter
public final class SysCategoryEntity extends LKMappedCategoryEntity implements LKCategoryInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668012L;

}
