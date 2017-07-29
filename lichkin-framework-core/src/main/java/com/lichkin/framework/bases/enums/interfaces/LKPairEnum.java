package com.lichkin.framework.bases.enums.interfaces;

/**
 * 基本键值对枚举接口，键取枚举值，值取name属性。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKPairEnum extends LKPrototypeEnum {

	/**
	 * 获取中文名称
	 * @return 中文名称
	 */
	public abstract String getName();

}
