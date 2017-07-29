package com.lichkin.framework.bases.entities;

/**
 * 类目接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKCategoryInterface extends LKNormalInterface {

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
	 * 获取类目名称
	 * @return 类目名称
	 */
	public String getCategoryName();


	/**
	 * 设置类目名称
	 * @param categoryName 类目名称
	 */
	public void setCategoryName(String categoryName);


	/**
	 * 获取类目值
	 * @return 类目值
	 */
	public String getCategoryValue();


	/**
	 * 设置类目值
	 * @param categoryValue 类目值
	 */
	public void setCategoryValue(String categoryValue);


	/**
	 * 获取父类目编号
	 * @return 父类目编号
	 */
	public String getParentCode();


	/**
	 * 设置父类目编号
	 * @param parentCode 父类目编号
	 */
	public void setParentCode(String parentCode);

}
