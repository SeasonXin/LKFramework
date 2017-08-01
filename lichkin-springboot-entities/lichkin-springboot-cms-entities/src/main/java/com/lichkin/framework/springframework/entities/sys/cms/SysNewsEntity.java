package com.lichkin.framework.springframework.entities.sys.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;

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
	private static final long serialVersionUID = -2100802126480873643L;

	/** 类型（枚举） */
	@Column(length = 20)
	private String newsType;

	/** 分类(对应字典表ID) */
	@Column(length = 32)
	private String categoryCode;

	/** 标题 */
	@Column(length = 50)
	private String newsTitle;

	/** 简介 */
	@Column(length = 200)
	private String brief;

	/** banner轮播图 （对应文件表id） */
	@Column(length = 32)
	private String bannerFileId;

	/** 缩略图（对应文件表id） */
	@Column(length = 32)
	private String thumbnailFileId;

	/** 内容 */
	@Column(length = 5000)
	private String content;

	/** 作者 */
	@Column(length = 100)
	private String author;

	/** 外链地址 */
	@Column(length = 200)
	private String linkUrl;

	/** banner轮播图显示顺序 */
	@Column(length = 2)
	private Integer sortNum;

}
