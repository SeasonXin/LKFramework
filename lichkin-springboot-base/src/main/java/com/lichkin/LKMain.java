package com.lichkin;

import static com.lichkin.framework.springboot.configurations.prop.LKPropertiesConfigKeys.ARGS_PRODUCTION_ON;
import static com.lichkin.framework.springboot.configurations.prop.LKPropertiesConfigKeys.ARGS_PROJECT_LOGLEVEL;
import static com.lichkin.framework.springboot.configurations.prop.LKPropertiesConfigKeys.ARGS_PROJECT_NAME;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ClassUtils;

import com.lichkin.framework.utils.lang.LKArrayUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 项目主类
 */
@SpringBootApplication // 自动配置
public class LKMain {

	/** 日志对象 */
	private static final Log LOGGER = LogFactory.getLog(LKMain.class);

	/** 默认加载的profile */
	private static String[] PROFILES = { "db", "web", "admin", "common" };

	/** 默认加载的profile长度 */
	private static int PROFILES_LENGTH = PROFILES.length;

	/** context环境 */
	public static ConfigurableEnvironment env = null;

	/** 默认环境 */
	private static final String DEFAULT_PROFILE = "development";

	/** 默认项目名 */
	private static final String DEFAULT_PROJECT_NAME = "projectName";

	/** 默认日志级别 */
	private static final String DEFAULT_PROJECT_LOGLEVEL = "warn";


	/**
	 * 主函数
	 * @param args 入口参数
	 */
	public static void main(String[] args) {
		// 解析参数
		args = analysizeArgs(args);

		// 配置log4j2的启动参数值
		MainMapLookup.setMainArguments(args);

		// 创建应用
		SpringApplication app = new SpringApplication(LKMain.class);

		// 添加初始化对象
		app.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {

			@Override
			public void initialize(ConfigurableApplicationContext applicationContext) {
				env = applicationContext.getEnvironment();
			}

		});

		// 启动应用
		app.run(args);
	}


	/**
	 * 解析参数
	 * @param args 入口参数
	 * @return 解析后冲洗创建的参数
	 */
	private static String[] analysizeArgs(String[] args) {
		analysizeProfiles();// 解析环境

		if (LKArrayUtils.isNotEmpty(args)) {// 包含参数
			boolean hasProfilesActiveConfig = false;// 是否有profiles配置
			boolean hasProjectNameConfig = false;// 是否有项目名配置
			boolean hasLogLevelConfig = false;// 是否有日志级别配置

			for (int i = 0; i < args.length; i++) {// 遍历所有参数
				String argI = args[i];
				if (LKStringUtils.startsWith(argI, "--spring.profiles.active=")) {// profiles配置
					hasProfilesActiveConfig = true;
					String[] strs = argI.split("=");
					if (strs.length == 2) {
						List<String> listProfile = new ArrayList<>();
						String[] profiles = strs[1].split(",");

						for (int j = 0; j < profiles.length; j++) {// 遍历传入的profiles配置
							boolean containsProfile = false;
							String profileJ = profiles[j];
							for (int k = PROFILES_LENGTH - 1; k >= 0; k--) {// 遍历默认的profiles配置
								if (LKStringUtils.equals(profileJ, PROFILES[k])) {
									containsProfile = true;
								}
							}
							if (!containsProfile) {// 默认profiles配置中没有的配置依次加入配置中。
								if (LKStringUtils.equals(profileJ, "production")) {
									for (String arg : args) {
										if (LKStringUtils.equals(ARGS_PRODUCTION_ON, arg)) {
											listProfile.add(profileJ);
										}
									}
								} else if (LKStringUtils.equals(profileJ, "integration")) {
									listProfile.add(profileJ);
								} else if (LKStringUtils.equals(profileJ, DEFAULT_PROFILE)) {
									listProfile.add(profileJ);
									System.setProperty("webjars.compress", "false");
								} else {
									PROFILES = LKArrayUtils.add(PROFILES, profileJ);
								}
							}
						}

						if (listProfile.isEmpty()) {
							PROFILES = LKArrayUtils.add(PROFILES, DEFAULT_PROFILE);
							System.setProperty("webjars.compress", "false");
							// 没有配置环境参数则增加开发环境
							LOGGER.warn("no profile to active, framework may append development to active.");
						} else if (listProfile.size() == 1) {
							// 最后增加环境配置
							PROFILES = LKArrayUtils.add(PROFILES, listProfile.get(0));
						} else {
							LOGGER.error("the active profile must be only one.");
							throw new IllegalArgumentException("the active profile must be only one.");
						}

						// 替换处理过的配置
						args[i] = reBuildArgProfilesActive();
					} else {// 配置有误
						LOGGER.error("the argument profiles active config should like this [--spring.profiles.active=development]");
						throw new IllegalArgumentException("the argument profiles active config should like this [--spring.profiles.active=development]");
					}
				} else if (LKStringUtils.equals(argI, ARGS_PROJECT_NAME)) {
					hasProjectNameConfig = true;
				} else if (LKStringUtils.equals(argI, ARGS_PROJECT_LOGLEVEL)) {
					hasLogLevelConfig = true;
				}
			}

			if (!hasProfilesActiveConfig) {// 不包含profile配置
				PROFILES = LKArrayUtils.add(PROFILES, DEFAULT_PROFILE);
				args = LKArrayUtils.add(args, reBuildArgProfilesActive());// 增加profile配置
				System.setProperty("webjars.compress", "false");
			}

			if (!hasProjectNameConfig) {// 不包含项目名配置
				args = LKArrayUtils.addAll(args, ARGS_PROJECT_NAME, DEFAULT_PROJECT_NAME);// 增加项目名配置
			}

			if (!hasLogLevelConfig) {// 不包含日志级别配置
				args = LKArrayUtils.addAll(args, ARGS_PROJECT_LOGLEVEL, DEFAULT_PROJECT_LOGLEVEL);// 增加日志级别配置
			}
		} else {// 不包含参数，所有都设置默认值。
			args = new String[] { ARGS_PROJECT_NAME, DEFAULT_PROJECT_NAME, ARGS_PROJECT_LOGLEVEL, DEFAULT_PROJECT_LOGLEVEL, reBuildArgProfilesActive() };
			System.setProperty("webjars.compress", "false");
		}

		return args;
	}


	/**
	 * 解析环境
	 */
	private static void analysizeProfiles() {
		analysizeProfileDB();// 解析数据库环境
		analysizeProfileWeb();// 解析WEB环境
		analysizeProfileAdmin();// 解析ADMIN环境
		PROFILES_LENGTH = PROFILES.length;
	}


	/**
	 * 解析数据库环境
	 * @return 依赖数据库环境返回true，否则返回false。
	 */
	private static void analysizeProfileDB() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.db.dao.LKDao", null)) {
			PROFILES = LKArrayUtils.removeElement(PROFILES, "db");
		}
	}


	/**
	 * 解析WEB环境
	 * @return 依赖Web环境返回true，否则返回false。
	 */
	private static void analysizeProfileWeb() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.web.LKSessionUser", null)) {
			PROFILES = LKArrayUtils.removeElement(PROFILES, "web");
		}
	}


	/**
	 * 解析ADMIN环境
	 * @return 依赖Admin环境返回true，否则返回false。
	 */
	private static void analysizeProfileAdmin() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.admin.services.LKAdminService", null)) {
			PROFILES = LKArrayUtils.removeElement(PROFILES, "admin");
		}
	}


	/**
	 * 重新构建profile参数
	 * @return profile参数
	 */
	private static String reBuildArgProfilesActive() {
		String str = "--spring.profiles.active=";
		for (int j = 0; j < PROFILES.length; j++) {
			if (j == 0) {
				str += PROFILES[j];
			} else {
				str += "," + PROFILES[j];
			}
		}
		return str;
	}

}
