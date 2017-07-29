package com.lichkin.framework.bases.entities;

import com.lichkin.framework.bases.enums.LKYesNoEnum;

/**
 * 菜单接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKMenuInterface extends LKIDInterface {

	/**
	 * 获取菜单编码
	 * @return 菜单编码
	 */
	public String getMenuCode();


	/**
	 * 设置菜单编码
	 * @param menuCode 菜单编码
	 */
	public void setMenuCode(String menuCode);


	/**
	 * 获取菜单名称
	 * @return 菜单名称
	 */
	public String getMenuName();


	/**
	 * 设置菜单名称
	 * @param menuName 菜单名称
	 */
	public void setMenuName(String menuName);


	/**
	 * 获取菜单URL
	 * @return 菜单URL
	 */
	public String getUrl();


	/**
	 * 设置菜单URL
	 * @param url 菜单URL
	 */
	public void setUrl(String url);


	/**
	 * 获取父菜单编码
	 * @return 父菜单编码
	 */
	public String getParentCode();


	/**
	 * 设置父菜单编码
	 * @param parentCode 父菜单编码
	 */
	public void setParentCode(String parentCode);


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


	/**
	 * 获取图标
	 * @return 图标
	 */
	public String getIcon();


	/**
	 * 设置图标
	 * @param icon 图标
	 */
	public void setIcon(String icon);


	/**
	 * 获取系统编码
	 * @return 系统编码
	 */
	public String getSystemTag();


	/**
	 * 设置系统编码
	 * @param systemTag 系统编码
	 */
	public void setSystemTag(final String systemTag);


	/**
	 * 获取是否可分配
	 * @return 是否可分配
	 */
	public LKYesNoEnum getAssignable();


	/**
	 * 设置是否可分配
	 * @param assignable 是否可分配
	 */
	public void setAssignable(final LKYesNoEnum assignable);

}
