package com.lichkin.framework.wechat.vo.config;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.wechat.statics.LKWechatConfigStatics;

import lombok.Getter;

/**
 * 微信菜单按钮（跳转链接地址类型）
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class ViewButton extends Button {

	/**
	 * 构造方法
	 * @param name 菜单名称
	 */
	public ViewButton(final String name) {
		super("view", name);
	}


	/** 链接地址 */
	private String url;


	@Override
	public void init(final int x, final int y) {
		super.init(x, y);
		final String btnName = "btn" + x + y;
		final LKDatas datas = new LKDatas();
		datas.put("#appid", LKWechatConfigStatics.appid);
		datas.put("#projectUrl", LKWechatConfigStatics.projectUrl);
		datas.put("#btnName", btnName);
		datas.put("#state", btnName);
		url = LKStringUtils.replaceDatas(url, datas);
	}

}
