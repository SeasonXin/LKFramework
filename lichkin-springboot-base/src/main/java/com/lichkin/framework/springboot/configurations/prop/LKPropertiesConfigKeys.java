package com.lichkin.framework.springboot.configurations.prop;

/**
 * 使用本包相关配置项
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKPropertiesConfigKeys {

	/** 项目名。Main Arguments key: with the value that follows this key in the argument list. */
	public static final String ARGS_PROJECT_NAME = "lichkin_project_name";

	/** 日志级别。Main Arguments key: with the value that follows this key in the argument list. */
	public static final String ARGS_PROJECT_LOGLEVEL = "lichkin_project_loglevel";

	/** 开启生产环境配置。Main Arguments key: without value. */
	public static final String ARGS_PRODUCTION_ON = "lichkin_production_on";

}
