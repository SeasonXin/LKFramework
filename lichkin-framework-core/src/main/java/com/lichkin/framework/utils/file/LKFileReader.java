package com.lichkin.framework.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.ArrayUtils;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

/**
 * 文件读取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFileReader {

	/**
	 * 读取文件
	 * @param fileName 文件相对路径
	 * @return 文件内容
	 */
	public static String[] read(final String fileName) {
		return read(fileName, "UTF-8");
	}


	/**
	 * 读取文件
	 * @param fileName 文件相对路径
	 * @param charset 字符集
	 * @return 文件内容
	 */
	public static String[] read(final String fileName, final String charset) {
		final File file = LKFileUtils.getFile(fileName);

		if (file == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] not exist.");
		}

		if (!file.isFile()) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] is not a file.");
		}

		if (!file.canRead()) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] has no read auth.");
		}

		String[] result = {};
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, charset);
			br = new BufferedReader(isr);
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				result = ArrayUtils.add(result, line);
			}
		} catch (final FileNotFoundException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] not found.");
		} catch (final UnsupportedEncodingException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] unsupported encoding.");
		} catch (final IOException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "file[" + fileName + "] can not read.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (final IOException e) {
					br = null;
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (final IOException e) {
					isr = null;
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (final IOException e) {
					fis = null;
				}
			}
		}
		return result;
	}

}
