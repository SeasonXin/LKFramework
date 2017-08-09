package com.lichkin;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ClassUtils;

import com.lichkin.framework.bases.statics.configs.LKSysConfig;
import com.lichkin.framework.bases.statics.configs.LKSysConfigKeys;
import com.lichkin.framework.bases.statics.configs.LKSysConfigs;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 项目主类
 */
@SpringBootApplication // 自动配置
public class LKMain implements LKSysConfigKeys {

	/** 默认加载的profile */
	private static String[] PROFILES = { "db", "web", "admin", "common" };

	/** 默认加载的profile长度 */
	private static int PROFILES_LENGTH = PROFILES.length;

	/** context环境 */
	public static ConfigurableEnvironment env = null;

	/** 默认环境 */
	private static final String DEFAULT_PROFILE = "development";


	/**
	 * 主函数
	 * @param args 入口参数
	 */
	public static void main(String[] args) {
		// 解析参数
		args = analysizeArgs(args);

		System.out.println("analysized args:" + LKJSONUtils.toJson(args, false, true));

		// 配置log4j2的启动参数值
		MainMapLookup.setMainArguments(new String[] { CONFIG_LK_SYSTEM_TAG, LKSysConfigs.get(CONFIG_LK_SYSTEM_TAG), CONFIG_LK_SYSTEM_LOGLEVEL, LKSysConfigs.get(CONFIG_LK_SYSTEM_LOGLEVEL) });

		// 创建应用
		final SpringApplication app = new SpringApplication(LKMain.class);

		// 添加初始化对象
		app.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {

			@Override
			public void initialize(final ConfigurableApplicationContext applicationContext) {
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

		if (ArrayUtils.isNotEmpty(args)) {// 包含参数
			boolean hasProfilesActiveConfig = false;// 是否有profiles配置
			for (int i = 0; i < args.length; i++) {// 遍历所有参数
				final String argI = args[i];
				if (StringUtils.startsWith(argI, "--spring.profiles.active=")) {// profiles配置
					hasProfilesActiveConfig = true;
					final String[] strs = argI.split("=");
					if (strs.length == 2) {
						final String[] profiles = strs[1].split(",");

						for (final String profileJ : profiles) {// 遍历传入的profiles配置
							boolean containsProfile = false;
							for (int k = PROFILES_LENGTH - 1; k >= 0; k--) {// 遍历默认的profiles配置
								if (StringUtils.equals(profileJ, PROFILES[k])) {
									containsProfile = true;
								}
							}
							if (!containsProfile) {// 默认profiles配置中没有的配置依次加入配置中。
								if (StringUtils.equals(profileJ, "production")) {
									for (final String arg : args) {
										if (CONFIG_LK_SYSTEM_PRODUCTION.equals(arg)) {
											PROFILES = ArrayUtils.add(PROFILES, profileJ);
											LKSysConfigs.put(new LKSysConfig(CONFIG_LK_SYSTEM_PRODUCTION, true));
										}
									}
								} else {
									PROFILES = ArrayUtils.add(PROFILES, profileJ);
								}
							}
						}

						// 替换处理过的配置
						args[i] = reBuildArgProfilesActive();
					} else {// 配置有误
						throw new IllegalArgumentException("the argument profiles active config should like this [--spring.profiles.active=development]");
					}
				}

				if (CONFIG_LK_SYSTEM_TAG.equals(argI)) {
					LKSysConfigs.put(new LKSysConfig(CONFIG_LK_SYSTEM_TAG, args[i + 1]));
				}

				if (CONFIG_LK_SYSTEM_NAME.equals(argI)) {
					LKSysConfigs.put(new LKSysConfig(CONFIG_LK_SYSTEM_NAME, args[i + 1]));
				}

				if (CONFIG_LK_SYSTEM_LOGLEVEL.equals(argI)) {
					LKSysConfigs.put(new LKSysConfig(CONFIG_LK_SYSTEM_LOGLEVEL, args[i + 1]));
				}
			}

			if (!hasProfilesActiveConfig) {// 不包含profile配置
				PROFILES = ArrayUtils.add(PROFILES, DEFAULT_PROFILE);
				args = ArrayUtils.add(args, reBuildArgProfilesActive());// 增加profile配置
			}
		} else {// 不包含参数，所有都设置默认值。
			PROFILES = ArrayUtils.add(PROFILES, DEFAULT_PROFILE);
			args = new String[] { reBuildArgProfilesActive() };
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
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.daos.LKDao", null)) {
			PROFILES = ArrayUtils.removeElement(PROFILES, "db");
		}
	}


	/**
	 * 解析WEB环境
	 * @return 依赖Web环境返回true，否则返回false。
	 */
	private static void analysizeProfileWeb() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.web.LKSessionUser", null)) {
			PROFILES = ArrayUtils.removeElement(PROFILES, "web");
		}
	}


	/**
	 * 解析ADMIN环境
	 * @return 依赖Admin环境返回true，否则返回false。
	 */
	private static void analysizeProfileAdmin() {
		if (!ClassUtils.isPresent("com.lichkin.framework.springboot.admin.services.LKAdminService", null)) {
			PROFILES = ArrayUtils.removeElement(PROFILES, "admin");
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
