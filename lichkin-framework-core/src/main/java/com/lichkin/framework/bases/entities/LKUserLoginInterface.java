package com.lichkin.framework.bases.entities;

/**
 * 用户登录接口
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKUserLoginInterface extends LKIDInterface {

	/**
	 * 获取业务ID
	 * @return 业务ID
	 */
	public String getBusId();


	/**
	 * 设置业务ID
	 * @param busId 业务ID
	 */
	public void setBusId(String busId);


	/**
	 * 获取用户ID
	 * @return 用户ID
	 */
	public String getUserId();


	/**
	 * 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(String userId);


	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getUserCard();


	/**
	 * 设置身份证号
	 * @param userCard 身份证号
	 */
	public void setUserCard(final String userCard);


	/**
	 * 获取登录名
	 * @return 登录名
	 */
	public String getLoginName();


	/**
	 * 设置登录名
	 * @param loginName 登录名
	 */
	public void setLoginName(String loginName);


	/**
	 * 获取手机号码
	 * @return 手机号码
	 */
	public String getCellphone();


	/**
	 * 设置手机号码
	 * @param cellphone 手机号码
	 */
	public void setCellphone(final String cellphone);


	/**
	 * 获取邮箱
	 * @return 邮箱
	 */
	public String getEmail();


	/**
	 * 设置邮箱
	 * @param email 邮箱
	 */
	public void setEmail(final String email);


	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPwd();


	/**
	 * 设置密码
	 * @param pwd 密码
	 */
	public void setPwd(String pwd);


	/**
	 * 获取系统标识
	 * @return 系统标识
	 */
	public String getSystemTag();


	/**
	 * 设置系统标识
	 * @param systemTag 系统标识
	 */
	public void setSystemTag(String systemTag);


	/**
	 * 获取Token
	 * @return Token
	 */
	public String getToken();


	/**
	 * 设置Token
	 * @param token Token
	 */
	public void setToken(String token);


	/**
	 * 获取备用字段1
	 * @return 备用字段1
	 */
	public String getField1();


	/**
	 * 设置备用字段1
	 * @param field1 备用字段1
	 */
	public void setField1(String field1);


	/**
	 * 获取备用字段2
	 * @return 备用字段2
	 */
	public String getField2();


	/**
	 * 设置备用字段2
	 * @param field2 备用字段2
	 */
	public void setField2(String field2);


	/**
	 * 获取备用字段3
	 * @return 备用字段3
	 */
	public String getField3();


	/**
	 * 设置备用字段3
	 * @param field3 备用字段3
	 */
	public void setField3(String field3);

}
