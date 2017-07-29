package com.lichkin.framework.bases.enums;

import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;

/**
 * 返回值显示类型枚举
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public enum LKReturnValueShowTypeEnum implements LKPrototypeEnum {

	/** 标准显示 */
	STANDARD,

	/** 只显示code的值 */
	CODE_VALUE,

	/** 只显示包含code的json */
	CODE_ONLY

}
