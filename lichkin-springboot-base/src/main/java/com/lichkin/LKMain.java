package com.lichkin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ClassUtils;

import com.lichkin.framework.springboot.configurations.prop.LKPropertiesConfigKeys;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 项目主类
 */
@SpringBootApplication // 自动配置
public class LKMain {

	/** 默认加载的profile */
	private static String[] PROFILES = { "db", "web", "admin", "common" };

	/** 默认加载的profile长度 */
	private static int PROFILES_LENGTH = LKMain.PROFILES.length;

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
		args = LKMain.analysizeArgs(args);

		// 配置log4j2的启动参数值
		MainMapLookup.setMainArguments(args);

		// 创建应用
		final SpringApplication app = new SpringApplication(LKMain.class);

		// 添加初始化对象
		app.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {

			@Override
			public void initialize(final ConfigurableApplicationContext applicationContext) {
				LKMain.env = applicationContext.getEnvironment();
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
		LKMain.analysizeProfiles();// 解析环境

		if (ArrayUtils.isNotEmpty(args)) {// 包含参数
			boolean hasProfilesActiveConfig = false;// 是否有profiles配置
			boolean hasProjectNameConfig = false;// 是否有项目名配置
			boolean hasLogLevelConfig = false;// 是否有日志级别配置

			for (int i = 0; i < args.length; i++) {// 遍历所有参数
				final String argI = args[i];
				if (LKStringUtils.startsWith(argI, "--spring.profiles.active=")) {// profiles配置
					hasProfilesActiveConfig = true;
					final String[] strs = argI.split("=");
					if (strs.length == 2) {
						final List<String> listProfile = new ArrayList<>();
						final String[] profiles = strs[1].split(",");

						for (final String profileJ : profiles) {// 遍历传入的profiles配置
							boolean containsProfile = false;
							for (int k = LKMain.PROFILES_LENGTH - 1; k >= 0; k--) {// 遍历默认的profiles配置
								if (StringUtils.equals(profileJ, LKMain.PROFILES[k])) {
									containsProfile = true;
								}
							}
							if (!containsProfile) {// 默认profiles配置中没有的配置依次加入配置中。
								if (StringUtils.equals(profileJ, "production")) {
									for (final String arg : args) {
										if (StringUtils.equals(LKPropertiesConfigKeys.ARGS_PRODUCTION_ON, arg)) {
											listProfile.add(profileJ);
											System.setProperty("production", "true");
										}
									}
								} else if (StringUtils.equals(profileJ, "integration")) {
									listProfile.add(profileJ);
								} else if (StringUtils.equals(profileJ, LKMain.DEFAULT_PROFILE)) {
									listProfile.add(profileJ);
									System.setProperty("webjars.compress", "false");
								} else {
									LKMain.PROFILES = ArrayUtils.add(LKMain.PROFILES, profileJ);
								}
							}
						}

						if (listProfile.isEmpty()) {
							LKMain.PROFILES = ArrayUtils.add(LKMain.PROFILES, LKMain.DEFAULT_PROFILE);
							System.setProperty("webjars.compress", "false");
							// 没有配置环境参数则增加开发环境
							System.out.println("no profile to active, framework may append development to active.");
						} else if (listProfile.size() == 1) {
							// 最后增加环境配置
							LKMain.PROFILES = ArrayUtils.add(LKMain.PROFILES, listProfile.get(0));
						} else {
							System.out.println("the active profile must be only one.");
							throw new IllegalArgumentException("the active profile must be only one.");
						}

						// 替换处理过的配置
						args[i] = LKMain.reBuildArgProfilesActive();
					} else {// 配置有误
						System.out.println("the argument profiles active config should like this [--spring.profiles.active=development]");
						throw new IllegalArgumentException("the argument profiles active config should like this [--spring.profiles.active=development]");
					}
				} else if (StringUtils.equals(argI, LKPropertiesConfigKeys.ARGS_PROJECT_NAME)) {
					hasProjectNameConfig = true;
				} else if (StringUtils.equals(argI, LKPropertiesConfigKeys.ARGS_PROJECT_LOGLEVEL)) {
					hasLogLevelConfig = true;
				}
			}

			if (!hasProfilesActiveConfig) {// 不包含profile配置
				LKMain.PROFILES = ArrayUtils.add(LKMain.PROFILES, LKMain.DEFAULT_PROFILE);
				args = ArrayUtils.add(args, LKMain.reBuildArgProfilesActive());// 增加profile配置
				System.setProperty("webjars.compress", "false");
			}

			if (!hasProjectNameConfig) {// 不包含项目名配置
				args = ArrayUtils.addAll(args, LKPropertiesConfigKeys.ARGS_PROJECT_NAME, LKMain.DEFAULT_PROJECT_NAME);// 增加项目名配置
			}

			if (!hasLogLevelConfig) {// 不包含日志级别配置
				args = ArrayUtils.addAll(args, LKPropertiesConfigKeys.ARGS_PROJECT_LOGLEVEL, LKMain.DEFAULT_PROJECT_LOGLEVEL);// 增加日志级别配置
			}
		} else {// 不包含参数，所有都设置默认值。
			args = new String[] { LKPropertiesConfigKeys.ARGS_PROJECT_NAME, LKMain.DEFAULT_PROJECT_NAME, LKPropertiesConfigKeys.ARGS_PROJECT_LOGLEVEL, LKMain.DEFAULT_PROJECT_LOGLEVEL, LKMain.reBuildArgProfilesActive() };
			System.setProperty("webjars.compress", "false");
		}

		return args;
	}


	/**
	 * 解析环境
	 */
	private static void analysizeProfiles() {
		LKMain.analysizeProfileDB();// 解析数据库环境
		LKMain.analysizeProfileWeb();// 解析WEB环境
		LKMain.analysizeProfileAdmin();// 解析ADMIN环境
		LKMain.PROFILES_LENGTH = LKMain.PROFILES.length;
	}


	/**
	 * 解析数据库环境
	 * @return 依赖数据库环境返回true，否则返回false。
	 */
	private static void analysizeProfileDB() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.db.dao.LKDao", null)) {
			LKMain.PROFILES = ArrayUtils.removeElement(LKMain.PROFILES, "db");
		}
	}


	/**
	 * 解析WEB环境
	 * @return 依赖Web环境返回true，否则返回false。
	 */
	private static void analysizeProfileWeb() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.web.LKSessionUser", null)) {
			LKMain.PROFILES = ArrayUtils.removeElement(LKMain.PROFILES, "web");
		}
	}


	/**
	 * 解析ADMIN环境
	 * @return 依赖Admin环境返回true，否则返回false。
	 */
	private static void analysizeProfileAdmin() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.admin.services.LKAdminService", null)) {
			LKMain.PROFILES = ArrayUtils.removeElement(LKMain.PROFILES, "admin");
		}
	}


	/**
	 * 重新构建profile参数
	 * @return profile参数
	 */
	private static String reBuildArgProfilesActive() {
		String str = "--spring.profiles.active=";
		for (int j = 0; j < LKMain.PROFILES.length; j++) {
			if (j == 0) {
				str += LKMain.PROFILES[j];
			} else {
				str += "," + LKMain.PROFILES[j];
			}
		}
		return str;
	}

}
