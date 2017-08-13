package com.lichkin.framework.android.preferences;

import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 在硬盘中存储数据信息用
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSharedPreferences {

	/** 硬盘存储文件名 */
	public static final String LK_SHARED_PREFERENCES = "LKSharedPreferences";

	/** 共享参数 */
	private static SharedPreferences sp;

	/** 共享参数编辑器 */
	private static SharedPreferences.Editor editor;


	/**
	 * 初始化
	 * @param context 环境上下文
	 */
	public static synchronized void init(final Context context) {
		if ((sp == null) && (editor == null)) {
			sp = context.getSharedPreferences(LK_SHARED_PREFERENCES, Context.MODE_PRIVATE);
			editor = sp.edit();
		}
	}


	/**
	 * 新增共享参数
	 * @param key 键
	 * @param value 值
	 */
	public static void put(final String key, final String value) {
		editor.putString(key, value);
		editor.commit();
	}


	/**
	 * 移除共享参数
	 * @param key 键
	 */
	public static void remove(final String key) {
		editor.remove(key);
		editor.commit();
	}


	/**
	 * 获取共享参数
	 * @param key 键
	 * @return 值
	 */
	public static String get(final String key) {
		return sp.getString(key, "");
	}


	/**
	 * 获取共享参数
	 * @param key 键
	 * @param defaultString 默认值
	 * @return 值
	 */
	public static String get(final String key, final String defaultString) {
		return sp.getString(key, defaultString);
	}


	/**
	 * 新增共享参数
	 * @param key 键
	 * @param value 值
	 */
	public static void putSet(final String key, final Set<String> value) {
		editor.putStringSet(key, value);
		editor.commit();
	}


	/**
	 * 获取共享参数
	 * @param key 键
	 * @return 值
	 */
	public static Set<String> getSet(final String key) {
		return sp.getStringSet(key, null);
	}

}
