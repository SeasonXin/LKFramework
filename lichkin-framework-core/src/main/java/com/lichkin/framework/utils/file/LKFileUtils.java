package com.lichkin.framework.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

import com.lichkin.framework.bases.statics.LKFileExtNameStatics;
import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 文件工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFileUtils {

	/**
	 * 获取标准路径，即以/开头，不以/结尾。
	 * @param path 准路径
	 * @return 标准路径
	 */
	public static String getStandardPath(String path) {
		path = LKStringUtils.trimToEmpty(path);
		if (LKStringUtils.isBlank(path)) {
			return LKStringStatics.STR_SEPARATOR;
		}
		if (!path.startsWith(LKStringStatics.STR_SEPARATOR)) {
			path = LKStringStatics.STR_SEPARATOR + path;
		}
		if (path.endsWith(LKStringStatics.STR_SEPARATOR)) {
			return path.substring(0, path.lastIndexOf(LKStringStatics.STR_SEPARATOR));
		}
		return path;
	}


	/**
	 * 获取标准文件名，即不以/开头，以后缀名结尾。
	 * @param fileName 文件名
	 * @return 文件名
	 */
	public static String getStandardFileName(String fileName) {
		fileName = LKStringUtils.trimToEmpty(fileName);
		if (LKStringUtils.isBlank(fileName)) {
			return LKFileExtNameStatics.TXT;
		}
		if (fileName.startsWith(LKStringStatics.STR_SEPARATOR)) {
			fileName = fileName.substring(LKStringStatics.STR_SEPARATOR.length(), fileName.length());
		}
		return fileName;
	}


	/**
	 * 获取标准扩展名，即以.开头，且全大写。
	 * @param extName 扩展名
	 * @return 扩展名
	 */
	public static String getStandardExtName(String extName) {
		extName = LKStringUtils.trimToEmpty(extName);
		if (LKStringUtils.isBlank(extName)) {
			return LKFileExtNameStatics.TXT;
		}
		if (!extName.startsWith(LKStringStatics.STR_DOT)) {
			extName = LKStringStatics.STR_DOT + extName;
		}
		return extName.toUpperCase();
	}


	/**
	 * 获取文件对象
	 * @param fileName 文件名（绝对路径或者相对路径）
	 * @return 如果存在返回文件，否则返回null。
	 */
	public static File getFile(final String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			return file;
		} else {
			file = new File(LKFileUtils.getAbsolutePath(fileName));
			if ((file != null) && file.exists()) {
				return file;
			}
		}
		return null;
	}


	/**
	 * 创建文件对象
	 * @param fileName 文件名（绝对路径）
	 * @return 如果存在返回文件，否则创建文件并返回。
	 * @throws IOException 创建文件可能抛出异常
	 */
	public static File createFile(final String fileName) throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			return file;
		}
		final File parent = file.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (file.createNewFile()) {
			return file;
		}
		return null;
	}


	/**
	 * 删除文件对象
	 * @param fileName 文件名（绝对路径）
	 * @return 删除成功返回true，否则返回false。
	 */
	public static boolean deleteFile(final String fileName) {
		final File file = new File(fileName);
		if (file.exists()) {
			return file.delete();
		}
		return true;
	}


	/**
	 * 转换成绝对路径
	 * @param relativePath 相对路径
	 * @return 绝对路径
	 */
	public static String getAbsolutePath(final String relativePath) {
		return LKFileUtils.getRunningPath() + relativePath;
	}


	/**
	 * 获取运行路径
	 * @return 运行路径
	 */
	public static String getRunningPath() {
		// return Loader.getResource(STR_EMPTY).getPath();
		return ClassLoader.getSystemResource(LKStringStatics.STR_EMPTY).getPath();
	}


	/**
	 * 获取文件的MD5值
	 * @param is 输入流
	 * @return MD5值
	 */
	public static String getMD5(InputStream is) {
		try {
			final MessageDigest m = MessageDigest.getInstance("MD5");
			final byte[] buf = new byte[65536];

			int num;
			while ((num = is.read(buf)) != -1) {
				m.update(buf, 0, num);
			}

			String result = new BigInteger(1, m.digest()).toString(16);

			final int length = result.length();
			if (length < 32) {// 位数不足补0
				final int size = 32 - length;
				final StringBuilder sb = new StringBuilder();
				for (int i = 0; i < size; i++) {
					sb.append("0");
				}
				result = sb + result;
			}

			return result;
		} catch (final Exception e) {
			e.printStackTrace();
			return LKRandomUtils.create(32);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
				is = null;
			}
		}
	}


	/**
	 * 获取文件的MD5值
	 * @param file 文件对象
	 * @return MD5值
	 */
	public static String getMD5(final File file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			return LKFileUtils.getMD5(is);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
			return LKRandomUtils.create(32);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (final IOException e) {
				is = null;
			}
		}
	}

}
