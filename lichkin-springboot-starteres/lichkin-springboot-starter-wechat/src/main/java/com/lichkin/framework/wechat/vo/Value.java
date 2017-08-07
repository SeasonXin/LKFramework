package com.lichkin.framework.wechat.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@NoArgsConstructor
public class Value {

	/**
	 * 构造方法
	 * @param value 值
	 * @param color 颜色
	 */
	public Value(final String value, final Colors color) {
		super();
		this.value = value;
		switch (color) {
			case RED:
				this.color = "#DF0000";
			break;
			case BLUE:
				this.color = "#2B99FF";
			break;
			default:
				this.color = "#333333";
			break;
		}
	}


	/**
	 * 色值枚举
	 * @author SuZhou LichKin Information Technology Co., Ltd.
	 */
	public enum Colors {
		/** 红色 */
		RED,
		/** 蓝色 */
		BLUE,
		/** 黑色 */
		BLACK
	}


	/** 值 */
	private String value;

	/** 颜色 */
	private String color;

}
