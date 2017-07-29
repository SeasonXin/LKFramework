package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 错误编码枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKErrorCodeEnum implements LKBaseEnum {

	/** 请求成功 */
	SUCCESS(0, "请求成功", "success"),

	/** 服务器代码未捕获异常时抛出的错误编码 */
	ERROR(1, "服务器代码未捕获异常时抛出的错误编码", "error"),

	/** 客户端请求参数在服务器端验证失败 */
	PARAMS_EXCEPTION(2, "客户端请求参数在服务器端验证失败", "params exception"),

	/** 没有请求权限 */
	PERMISSION_DENIED(3, "没有请求权限", "permission denied"),

	/** 没有登录 */
	NO_LOGIN(4, "没有登录", "no login"),

	/** 没有业务操作权限 */
	AUTH_NOT_ALLOWED(5, "没有业务操作权限", "auth not allowed"),

	/** SQL执行异常 */
	SQL_EXCEPTION(6, "SQL执行异常", "sql exception"),

	/** 数据已存在 */
	EXIST(7, "数据已存在", "exist"),

	/** 数据不存在 */
	INEXISTENCE(8, "数据不存在", "inexistence"),

	/** 用户名或密码错误 */
	INCORRECT_LOGIN_NAME_OR_PASSWORD(9, "用户名或密码错误", "incorrect loginName or password"),

	/** 配置错误 */
	CONFIG_ERROR(10, "配置文件错误", "config error"),

	/** 连接失败 */
	CONNECTION_FAILED(11, "连接失败", "connection failed"),

	/** 文件创建失败 */
	CREAET_FILE_FAILED(12, "文件创建失败", "create file failed"),

	/** 文件上传失败 */
	FILE_UPLOAD_FAILED(13, "文件上传失败，请稍后重试。", "file upload failed, please try again later."),

	/** 图片上传失败 */
	IMG_UPLOAD_FAILED(14, "图片上传失败，请稍后重试。", "image upload failed, please try again later."),

	/** 接口暂停使用（临时停用，不久后恢复） */
	INTERFACE_PAUSED(9998, "接口暂停使用（临时停用，不久后恢复）", "interface paused."),

	/** 接口已停用（该功能不会再开启） */
	INTERFACE_DEACTIVATED(9999, "接口已停用（该功能不会再开启）", "interface deactivated");

	/**
	 * 构造方法
	 * @param code 编码
	 * @param name 中文名称
	 * @param nameEn 英文名称
	 */
	LKErrorCodeEnum(final Integer code, final String name, final String nameEn) {
		this.code = code;
		this.name = name;
		this.nameEn = nameEn;
	}


	/** 编码 */
	private final Integer code;

	/** 中文名称 */
	private final String name;

	/** 英文名称 */
	private final String nameEn;


	/**
	 * 获取编码
	 * @return 编码
	 */
	@Override
	public Integer getCode() {
		return code;
	}


	/**
	 * 获取中文名称
	 * @return 中文名称
	 */
	@Override
	public String getName() {
		return name;
	}


	/**
	 * 获取英文名称
	 * @return 英文名称
	 */
	@Override
	public String getNameEn() {
		return nameEn;
	}

}
