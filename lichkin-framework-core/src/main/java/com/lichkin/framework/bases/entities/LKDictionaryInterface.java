package com.lichkin.framework.bases.entities;

/**
 * 字典接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKDictionaryInterface extends LKNormalInterface {

	/**
	 * 获取类目编号
	 * @return 类目编号
	 */
	public String getCategoryCode();


	/**
	 * 设置类目编号
	 * @param categoryCode 类目编号
	 */
	public void setCategoryCode(String categoryCode);


	/**
	 * 获取字典编号
	 * @return 字典编号
	 */
	public String getDictCode();


	/**
	 * 设置字典编号
	 * @param dictCode 字典编号
	 */
	public void setDictCode(String dictCode);


	/**
	 * 获取字典名称
	 * @return 字典名称
	 */
	public String getDictName();


	/**
	 * 设置字典名称
	 * @param dictName 字典名称
	 */
	public void setDictName(String dictName);


	/**
	 * 获取字典值
	 * @return 字典值
	 */
	public String getDictValue();


	/**
	 * 设置字典值
	 * @param dictValue 字典值
	 */
	public void setDictValue(String dictValue);


	/**
	 * 获取排序号
	 * @return 排序号
	 */
	public Byte getOrderId();


	/**
	 * 设置排序号
	 * @param orderId 排序号
	 */
	public void setOrderId(Byte orderId);

}
