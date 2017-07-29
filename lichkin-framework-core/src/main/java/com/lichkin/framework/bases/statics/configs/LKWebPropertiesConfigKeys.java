package com.lichkin.framework.bases.statics.configs;

/**
 * Web项目配置文件默认值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWebPropertiesConfigKeys extends LKPropertiesConfigKeys {

	/** 框架前缀 */
	public static final String CONFIG_KEY_PREFIX_WEB = LKPropertiesConfigKeys.CONFIG_KEY_PREFIX + "web.";

	/** 服务器端口号 */
	public static final String CONFIG_KEY_OTHERS_SERVER_PORT = "server.port";

	/** 页面展现UI实现名 */
	public static final String CONFIG_KEY_WEB_UI = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "ui";

	/** 错误页面地址 */
	public static final String CONFIG_KEY_WEB_PAGE_ERROR_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "page.error.url";

	/** 索引页面地址 */
	public static final String CONFIG_KEY_WEB_PAGE_INDEX_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "page.index.url";

	/** 登录页面地址 */
	public static final String CONFIG_KEY_WEB_PAGE_LOGIN_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "page.login.url";

	/** 主页面地址 */
	public static final String CONFIG_KEY_WEB_PAGE_MAIN_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "page.main.url";

	/** 欢迎页面地址 */
	public static final String CONFIG_KEY_WEB_PAGE_WELCOME_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "page.welcome.url";

	/** 显示LOGO */
	public static final String CONFIG_KEY_WEB_SHOW_LOGO = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "showLogo";

	/** 用户实体类全名 */
	public static final String CONFIG_KEY_WEB_USER_ENTITY = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "userEntity";

	/** 用户登录实体类全名 */
	public static final String CONFIG_KEY_WEB_USER_LOGIN_ENTITY = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "userLoginEntity";

	/** 获取角色ID列表的SQL语句 */
	public static final String CONFIG_KEY_WEB_SQL_GET_ROLEIDS = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "sql.getRoleIds.sql";

	/** 获取角色ID列表的SQL语句中默认赋予的角色名 */
	public static final String CONFIG_KEY_WEB_SQL_GET_ROLEIDS_DEFAULT_ROLE_NAME = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "sql.getRoleIds.defaultRoleName";

	/** 默认登录密码 */
	public static final String CONFIG_KEY_WEB_DEFAULT_LOGIN_PWD = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "defaultLoginPwd";

	/** 上传文件地址 */
	public static final String CONFIG_KEY_WEB_UPLOAD_FILES_URL = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "uploadFiles.url";

	/** 上传文件存储路径 */
	public static final String CONFIG_KEY_WEB_UPLOAD_FILES_PATH = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "uploadFiles.path";

	/** 超级管理员角色ID列表，逗号分割。 */
	public static final String CONFIG_KEY_WEB_ADMIN_SUPER_ADMIN_ROLE_IDS = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "admin.superAdminRoleIds";

	/** 管理员默认密码 */
	public static final String CONFIG_KEY_WEB_ADMIN_DEFAULT_LOGIN_PWD = LKWebPropertiesConfigKeys.CONFIG_KEY_PREFIX_WEB + "admin.defaultLoginPwd";

}
