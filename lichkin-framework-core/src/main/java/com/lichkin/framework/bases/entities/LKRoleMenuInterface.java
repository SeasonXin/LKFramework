package com.lichkin.framework.bases.entities;

/**
 * 角色&amp;菜单关联接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKRoleMenuInterface extends LKIDInterface {

	/**
	 * 获取角色ID
	 * @return 角色ID
	 */
	public String getRoleId();


	/**
	 * 设置角色ID
	 * @param roleId 角色ID
	 */
	public void setRoleId(String roleId);


	/**
	 * 获取菜单ID
	 * @return 菜单ID
	 */
	public String getMenuId();


	/**
	 * 设置菜单ID
	 * @param menuId 菜单ID
	 */
	public void setMenuId(String menuId);

}
