package com.lichkin.framework.springboot.web;

import com.lichkin.framework.bases.statics.configs.LKWebPropertiesConfigKeys;
import com.lichkin.framework.bases.statics.configs.LKWebPropertiesDefaultValues;
import com.lichkin.framework.springboot.utils.LKPropertiesUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 使用本包相关配置值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKWebProperties implements LKWebPropertiesConfigKeys {

	/** 服务器端口号 */
	public static final int SERVER_PORT = LKStringUtils.toInteger(LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_OTHERS_SERVER_PORT), LKWebPropertiesDefaultValues.DEFAULT_VALUE_SERVER_PORT);

	/** 页面展现UI实现名 */
	public static final String LK_WEB_UI = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_UI, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_UI);

	/** 错误页面地址 */
	public static final String LK_WEB_PAGE_ERROR_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_PAGE_ERROR_URL, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_ERROR_URL);

	/** 索引页面地址 */
	public static final String LK_WEB_PAGE_INDEX_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_PAGE_INDEX_URL, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_INDEX_URL);

	/** 登录页面地址 */
	public static final String LK_WEB_PAGE_LOGIN_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_PAGE_LOGIN_URL, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_LOGIN_URL);

	/** 主页面地址 */
	public static final String LK_WEB_PAGE_MAIN_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_PAGE_MAIN_URL, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_MAIN_URL);

	/** 欢迎页面地址 */
	public static final String LK_WEB_PAGE_WELCOME_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_PAGE_WELCOME_URL, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_PAGE_WELCOME_URL);

	/** 显示LOGO */
	public static final boolean LK_WEB_SHOW_LOGO = Boolean.parseBoolean(LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_SHOW_LOGO, String.valueOf(LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_SHOW_LOGO)));

	/** 用户实体类全名 */
	public static final String LK_WEB_USER_ENTITY = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_USER_ENTITY, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_USER_ENTITY);

	/** 用户登录实体类全名 */
	public static final String LK_WEB_USER_LOGIN_ENTITY = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_USER_LOGIN_ENTITY, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_USER_LOGIN_ENTITY);

	/** 获取角色ID列表的SQL语句 */
	public static final String LK_WEB_SQL_GET_ROLEIDS = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_SQL_GET_ROLEIDS, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_SQL_GET_ROLEIDS);

	/** 获取角色ID列表的SQL语句中默认赋予的角色名 */
	public static final String LK_WEB_SQL_GET_ROLEIDS_DEFAULT_ROLE_NAME = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_SQL_GET_ROLEIDS_DEFAULT_ROLE_NAME, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_SQL_GET_ROLEIDS_DEFAULT_ROLE_NAME);

	/** 默认登录密码 */
	public static final String LK_WEB_DEFAULT_LOGIN_PWD = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_DEFAULT_LOGIN_PWD, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_DEFAULT_LOGIN_PWD);

	/** 上传文件地址 */
	public static final String LK_WEB_UPLOAD_FILES_URL = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_UPLOAD_FILES_URL, "http://localhost" + ((LKWebProperties.SERVER_PORT == 80) ? "" : (":" + LKWebProperties.SERVER_PORT)) + "/lichkin/uploadFiles");

	/** 上传文件存储路径 */
	public static final String LK_WEB_UPLOAD_FILES_PATH = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_UPLOAD_FILES_PATH, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_UPLOAD_FILES_PATH);

	/** 超级管理员角色ID列表，逗号分割。 */
	public static final String LK_WEB_ADMIN_SUPER_ADMIN_ROLE_IDS = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_ADMIN_SUPER_ADMIN_ROLE_IDS, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_ADMIN_SUPER_ADMIN_ROLE_IDS);

	/** 管理员默认密码 */
	public static final String LK_WEB_ADMIN_DEFAULT_LOGIN_PWD = LKPropertiesUtils.getProperty(LKWebPropertiesConfigKeys.CONFIG_KEY_WEB_ADMIN_DEFAULT_LOGIN_PWD, LKWebPropertiesDefaultValues.DEFAULT_VALUE_WEB_ADMIN_DEFAULT_LOGIN_PWD);

}
