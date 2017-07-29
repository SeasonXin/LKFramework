package com.lichkin.framework.bases.statics.configs;

import com.lichkin.framework.bases.statics.LKWebStatics;

/**
 * web项目配置文件默认值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKWebPropertiesDefaultValues {

	/** 服务器端口号 */
	public static final int DEFAULT_VALUE_SERVER_PORT = 8080;

	/** 页面展现UI实现名 */
	public static final String DEFAULT_VALUE_WEB_UI = "easyui";

	/** 错误页面地址 */
	public static final String DEFAULT_VALUE_WEB_PAGE_ERROR_URL = "/error" + LKWebStatics.VIEW_REQUEST_SUFFIX;

	/** 索引页面地址 */
	public static final String DEFAULT_VALUE_WEB_PAGE_INDEX_URL = "/index" + LKWebStatics.VIEW_REQUEST_SUFFIX;

	/** 登录页面地址 */
	public static final String DEFAULT_VALUE_WEB_PAGE_LOGIN_URL = "/login" + LKWebStatics.VIEW_REQUEST_SUFFIX;

	/** 主页面地址 */
	public static final String DEFAULT_VALUE_WEB_PAGE_MAIN_URL = "/main" + LKWebStatics.VIEW_REQUEST_SUFFIX;

	/** 欢迎页面地址 */
	public static final String DEFAULT_VALUE_WEB_PAGE_WELCOME_URL = "/welcome" + LKWebStatics.VIEW_REQUEST_SUFFIX;

	/** 显示LOGO */
	public static final boolean DEFAULT_VALUE_WEB_SHOW_LOGO = true;

	/** 用户实体类全名 */
	public static final String DEFAULT_VALUE_WEB_USER_ENTITY = "com.lichkin.framework.springframework.entities.sys.user.SysUserEntity";

	/** 用户登录实体类全名 */
	public static final String DEFAULT_VALUE_WEB_USER_LOGIN_ENTITY = "com.lichkin.framework.springframework.entities.sys.user.SysUserLoginEntity";

	/** 获取角色ID列表的SQL语句 */
	public static final String DEFAULT_VALUE_WEB_SQL_GET_ROLEIDS = "select lr.roleId from com.lichkin.framework.springframework.entities.sys.user.SysUserLoginRoleEntity lr where lr.loginId = :userLoginId";

	/** 获取角色ID列表的SQL语句中默认赋予的角色名 */
	public static final String DEFAULT_VALUE_WEB_SQL_GET_ROLEIDS_DEFAULT_ROLE_NAME = "默认角色";

	/** 默认登录密码 */
	public static final String DEFAULT_VALUE_WEB_DEFAULT_LOGIN_PWD = "888888";

	/** 上传文件地址 */
	public static final String DEFAULT_VALUE_WEB_UPLOAD_FILES_URL = "http://localhost:8080/lichkin/uploadFiles";

	/** 上传文件存储路径 */
	public static final String DEFAULT_VALUE_WEB_UPLOAD_FILES_PATH = "/opt/lichkin/uploadFiles";

	/** 超级管理员角色ID列表，逗号分割。 */
	public static final String DEFAULT_VALUE_WEB_ADMIN_SUPER_ADMIN_ROLE_IDS = "A0000000000000000000000000000000";

	/** 管理员默认密码 */
	public static final String DEFAULT_VALUE_WEB_ADMIN_DEFAULT_LOGIN_PWD = "888888";

}
