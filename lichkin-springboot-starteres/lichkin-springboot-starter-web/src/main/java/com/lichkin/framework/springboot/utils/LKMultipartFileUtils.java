package com.lichkin.framework.springboot.utils;

import java.util.Map.Entry;

import org.springframework.web.multipart.MultipartFile;

import com.lichkin.framework.bases.LKDatas;

/**
 * 文件工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKMultipartFileUtils {

	/**
	 * 将数据信息中的文件对象转换成文件名存储
	 * @param datas 数据信息
	 * @return 转换后的数据信息
	 */
	public static LKDatas convertMultipartFiles(final LKDatas datas) {
		final LKDatas datasNew = new LKDatas();
		for (final Entry<String, Object> entry : datas.entrySet()) {
			final Object object = entry.getValue();
			if (object instanceof MultipartFile) {
				datasNew.put(entry.getKey(), ((MultipartFile) object).getOriginalFilename());
			} else {
				datasNew.put(entry.getKey(), object);
			}
		}
		return datasNew;
	}

}
