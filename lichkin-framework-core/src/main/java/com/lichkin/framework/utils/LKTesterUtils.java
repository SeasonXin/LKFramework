package com.lichkin.framework.utils;

import java.io.File;

import com.lichkin.framework.utils.file.LKFileUtils;

/**
 * 测试工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKTesterUtils {

	/**
	 * 获取测试目录下文件对象，需要文件在标准的maven项目环境中，且在/src/test/resources目录中。
	 * @param clazz 测试类
	 * @param fileName 文件名
	 * @return 文件对象
	 */
	public static File getTestResourceFile(final Class<?> clazz, final String fileName) {
		final String currentPath = clazz.getResource(".").getFile();
		System.out.println("currentPath: " + currentPath);
		final String projectPath = currentPath.substring(0, currentPath.indexOf("/target"));
		System.out.println("projectPath: " + projectPath);
		final String testResourcePath = projectPath + "/src/test/resources";
		System.out.println("testResourcePath: " + testResourcePath);
		final File file = new File(testResourcePath + "/" + LKFileUtils.getStandardFileName(fileName));
		System.out.println("absolutePath: " + file.getAbsolutePath());
		System.out.println("file exists: " + file.exists());
		return file;
	}

}
