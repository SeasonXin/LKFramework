package com.lichkin.framework.springboot.configurations;

import java.util.HashMap;
import java.util.Map;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.mail.bean.LKSysMailInfoBean;
import com.lichkin.framework.springboot.entities.impl.SysConfigMailEntity;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 邮件管理类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKMailManager {

	/** 配置信息集合 */
	public static Map<String, SysConfigMailEntity> configs = new HashMap<>();


	/**
	 * 获取邮件信息
	 * @param busCode 邮件业务编码
	 * @return 邮件信息
	 */
	public static LKSysMailInfoBean getMailInfo(final String busCode) {
		final SysConfigMailEntity config = configs.get(busCode);
		if (config == null) {
			return null;
		} else {
			final LKSysMailInfoBean info = new LKSysMailInfoBean();
			info.setAuth(config.isAuth());
			info.setBusCode(config.getBusCode());
			info.setHost(config.getFromHost());
			info.setPort(config.getFromPort());
			info.setUserName(config.getFromUserName());
			info.setPassword(config.getFromPassword());
			info.setFromAddress(config.getFromAddress());
			info.setFromDisplayName(config.getFromDisplayName());
			info.setSubject(config.getSubject());
			info.setContent(config.getContent());
			return info;
		}
	}


	/**
	 * 获取邮件信息
	 * @param busCode 邮件业务编码
	 * @param replaceDatas 数据集合。用于替换标题及内容中的动态值。
	 * @return 邮件信息
	 */
	public static LKSysMailInfoBean getMailInfo(final String busCode, final LKDatas replaceDatas) {
		final LKSysMailInfoBean config = LKMailManager.getMailInfo(busCode);

		if ((config != null) && (replaceDatas != null)) {
			config.setSubject(LKStringUtils.replaceDatas(config.getSubject(), replaceDatas));
			config.setContent(LKStringUtils.replaceDatas(config.getContent(), replaceDatas));
		}

		return config;
	}

}
