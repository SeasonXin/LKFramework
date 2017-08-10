package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 新闻信息表
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_NEWS")
@Getter
@Setter
public class SysNewsEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668030L;

	/** 类型（枚举） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 1)
	private String newsType;

	/** 分类(对应字典表ID) */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_CODE)
	@JSONField(ordinal = 2)
	private String categoryCode;

	/** 标题 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 3)
	private String newsTitle;

	/** 简介 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 4)
	private String brief;

	/** banner轮播图 （对应文件表id） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 5)
	private String bannerFileId;

	/** 缩略图（对应文件表id） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_BUS_ID)
	@JSONField(ordinal = 6)
	private String thumbnailFileId;

	/** 内容 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_REMARKS)
	@JSONField(ordinal = 7)
	private String content;

	/** 作者 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_VALUE)
	@JSONField(ordinal = 8)
	private String author;

	/** 外链地址 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = LENGTH_URL)
	@JSONField(ordinal = 9)
	private String linkUrl;

	/** banner轮播图显示顺序 */
	@Column(insertable = true, updatable = true, nullable = false, unique = false)
	@JSONField(ordinal = 10)
	private Integer sortNum;

}
