package com.lichkin.framework.bases.enums.interfaces;

/**
 * 基本枚举接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKBaseEnum extends LKEnum, LKPairEnum {

	/**
	 * 获取编码
	 * @return 编码
	 */
	@Override
	public abstract Integer getCode();


	/**
	 * 获取中文名称
	 * @return 中文名称
	 */
	@Override
	public abstract String getName();


	/**
	 * 获取英文名称
	 * @return 英文名称
	 */
	public abstract String getNameEn();

}
