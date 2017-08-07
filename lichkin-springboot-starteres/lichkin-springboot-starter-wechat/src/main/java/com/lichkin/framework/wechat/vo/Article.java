package com.lichkin.framework.wechat.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class Article {

	/** 标题 */
	private String title;

	/** 描述 */
	private String description;

	/** 图片地址 */
	private String picUrl;

	/** 地址 */
	private String url;

}
