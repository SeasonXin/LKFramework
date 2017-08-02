package com.lichkin.framework.springboot.db.utils;

import java.lang.reflect.Method;

import org.joda.time.DateTime;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;
import com.lichkin.framework.springboot.db.entities.LKMappedUserEntity;
import com.lichkin.framework.springboot.db.entities.LKMappedUserLoginEntity;
import com.lichkin.framework.springframework.LKProperties;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 实体类初始化工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKEntityInitializer {

	/**
	 * 初始化参数
	 * @param e 实体类对象
	 * @return 实体类对象
	 */
	public static Object initBean(final Object e) {
		if (e instanceof LKMappedBaseEntity) {
			final String currentTime = DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn());
			final String systemTag = LKProperties.LK_SYSTEM_TAG;
			final String loginId = LKEntityInitializer.getLoginId();

			if (!((LKMappedBaseEntity) e).isDisableInject()) {// 没有禁用注入，则自动注入值。
				// 新增/修改数据
				((LKMappedBaseEntity) e).setUpdateTime(currentTime);
				((LKMappedBaseEntity) e).setUpdateSystemTag(systemTag);
				((LKMappedBaseEntity) e).setUpdateLoginId(loginId);

				if (LKStringUtils.isBlank(((LKMappedBaseEntity) e).getId())) {// 新增数据
					((LKMappedBaseEntity) e).setInsertTime(currentTime);
					((LKMappedBaseEntity) e).setInsertSystemTag(systemTag);
					((LKMappedBaseEntity) e).setInsertLoginId(loginId);
				}
			}
		}
		if (e instanceof LKMappedUserEntity) {
			((LKMappedUserEntity) e).updateCheckCode();
		}
		if (e instanceof LKMappedUserLoginEntity) {
			((LKMappedUserLoginEntity) e).updateCheckCode();
		}
		return e;
	}


	/**
	 * 获取登录人登录ID
	 * @return 登录人登录ID
	 */
	public static String getLoginId() {
		String loginId = null;
		try {// web项目从session中取当前登录人ID
			final Class<?> clazz = Class.forName("com.lichkin.framework.springboot.web.LKSessionUser");
			final Method method = clazz.getMethod("getLoginId");
			loginId = (String) method.invoke(clazz);
		} catch (final Exception exception) {// TODO 非web项目取当前任务ID
		}
		return loginId;
	}

}
