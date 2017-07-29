package com.lichkin.framework.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件写入工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFileWriter {

	/**
	 * 写入文件
	 * @param file 文件对象
	 * @param is 输入流
	 * @return 文件对象
	 * @throws IOException 写入文件可能抛出异常
	 */
	public static File write(final File file, InputStream is) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			final byte[] buffer = new byte[65536];
			int num = 0;
			while ((num = is.read(buffer)) != -1) {
				fos.write(buffer, 0, num);
			}
			return file;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final Exception e) {
					e.printStackTrace();
					is = null;
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (final Exception e) {
					e.printStackTrace();
					fos = null;
				}
			}
		}
	}


	/**
	 * 写入流
	 * @param file 文件对象
	 * @param os 输出流
	 * @throws IOException 写入文件可能抛出异常
	 */
	public static void write(final File file, final OutputStream os) throws IOException {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			int num = 0;
			final byte[] buffer = new byte[65536];
			while ((num = is.read(buffer)) != -1) {
				os.write(buffer, 0, num);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final Exception e) {
					is = null;
				}

			}
		}
	}

}
