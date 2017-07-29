package com.lichkin.framework.bases.entities;

/**
 * 一般业务接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKBaseInterface extends LKNormalInterface {

	/**
	 * 获取新增操作系统编码
	 * @return 新增操作系统编码
	 */
	public String getInsertSystemTag();


	/**
	 * 设置新增操作系统编码
	 * @param insertSystemTag 新增操作系统编码
	 */
	public void setInsertSystemTag(final String insertSystemTag);


	/**
	 * 获取新增操作时间
	 * @return 新增操作时间
	 */
	public String getInsertTime();


	/**
	 * 设置新增操作时间
	 * @param insertTime 新增操作时间
	 */
	public void setInsertTime(final String insertTime);


	/**
	 * 获取新增操作人登录ID
	 * @return 新增操作人登录ID
	 */
	public String getInsertLoginId();


	/**
	 * 设置新增操作人登录ID
	 * @param insertLoginId 新增操作人登录ID
	 */
	public void setInsertLoginId(final String insertLoginId);


	/**
	 * 获取更新操作系统编码
	 * @return 更新操作系统编码
	 */
	public String getUpdateSystemTag();


	/**
	 * 设置更新操作系统编码
	 * @param updateSystemTag 更新操作系统编码
	 */
	public void setUpdateSystemTag(final String updateSystemTag);


	/**
	 * 获取更新操作时间
	 * @return 更新操作时间
	 */
	public String getUpdateTime();


	/**
	 * 设置更新操作时间
	 * @param updateTime 更新操作时间
	 */
	public void setUpdateTime(final String updateTime);


	/**
	 * 获取更新操作人登录ID
	 * @return 更新操作人登录ID
	 */
	public String getUpdateLoginId();


	/**
	 * 设置更新操作人登录ID
	 * @param updateLoginId 更新操作人登录ID
	 */
	public void setUpdateLoginId(final String updateLoginId);

}
