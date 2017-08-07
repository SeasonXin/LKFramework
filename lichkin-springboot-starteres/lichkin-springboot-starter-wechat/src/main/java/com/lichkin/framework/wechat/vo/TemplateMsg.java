package com.lichkin.framework.wechat.vo;

import com.lichkin.framework.bases.LKDatas;

import lombok.Getter;
import lombok.Setter;

/**
 * 模板消息
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
public class TemplateMsg {

	/** 接收人 */
	private String touser;

	/** 模板ID */
	private String template_id;

	/** 地址 */
	private String url;

	/** 数据 */
	private LKDatas data;

}
