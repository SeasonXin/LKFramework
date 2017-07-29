package com.lichkin.framework.bases.entities;

/**
 * 登录&amp;角色关联接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKLoginRoleInterface extends LKIDInterface {

	/**
	 * 获取登录ID
	 * @return 登录ID
	 */
	public String getLoginId();


	/**
	 * 设置登录ID
	 * @param menuId 登录ID
	 */
	public void setLoginId(String menuId);


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

}
