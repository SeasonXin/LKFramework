package com.lichkin.framework.springboot.demo.entity.impl;

import javax.persistence.Entity;

import com.lichkin.framework.springboot.entities.LKMappedIDEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DemoSecondaryEntity extends LKMappedIDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -1L;

	private String fieldStr;

}
