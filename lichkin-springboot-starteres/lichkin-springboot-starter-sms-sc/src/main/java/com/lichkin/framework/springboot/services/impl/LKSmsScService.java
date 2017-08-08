package com.lichkin.framework.springboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.enums.LKSmsSenderEnum;
import com.lichkin.framework.springboot.entities.impl.SysSecurityCodeEntity;
import com.lichkin.framework.springboot.services.LKDBService;

/**
 * 短信验证码服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKSmsScService extends LKDBService {

	@Autowired
	private LKSysScService scService;

	@Autowired
	private LKSysSmsService smsService;


	/**
	 * 获取验证码并发送短信
	 * @param systemTag 系统标识
	 * @param sender 短信平台
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param message 短信内容
	 * @param length 验证码长度
	 * @param threaded 单线程为true，方法将等待短信接口返回结果后继续执行，可以捕获到接口调用的异常信息；多线程为false，方法将开启一个新的线程调用短信接口，接口调用异常将只做日志输出。
	 * @param timeout 超时时长（分钟）
	 * @return 验证码对象
	 */
	public SysSecurityCodeEntity getScAndSendSms(final String systemTag, final LKSmsSenderEnum sender, final LKPrototypeEnum busType, final String cellphone, final String message, final int length, final boolean threaded, final int timeout) {
		// 获取验证码
		final SysSecurityCodeEntity entity = scService.createSecurityCode(systemTag, busType, cellphone, length, timeout);

		// 发送短信
		smsService.sendSms(systemTag, sender, busType, cellphone, message, threaded);

		return entity;
	}


	/**
	 * 获取验证码并发送短信
	 * @param sender 短信平台
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param message 短信内容
	 * @param length 验证码长度
	 * @param threaded 单线程为true，方法将等待短信接口返回结果后继续执行，可以捕获到接口调用的异常信息；多线程为false，方法将开启一个新的线程调用短信接口，接口调用异常将只做日志输出。
	 * @param timeout 超时时长（分钟）
	 * @return 验证码对象
	 */
	public SysSecurityCodeEntity getScAndSendSms(final LKSmsSenderEnum sender, final LKPrototypeEnum busType, final String cellphone, final String message, final int length, final boolean threaded, final int timeout) {
		return getScAndSendSms($systemTag, sender, busType, cellphone, message, length, threaded, timeout);
	}


	/**
	 * 判断验证码是否正确
	 * @param systemTag 系统标识
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param securityCode 待验证的验证码
	 * @param timeout 超时时长（分钟）
	 * @return 正确返回true，否则返回false。
	 */
	public boolean checkSecurityCode(final String systemTag, final LKPrototypeEnum busType, final String cellphone, final String securityCode, final int timeout) {
		return scService.checkSecurityCode(systemTag, busType, cellphone, securityCode, timeout);
	}


	/**
	 * 判断验证码是否正确
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param securityCode 待验证的验证码
	 * @param timeout 超时时长（分钟）
	 * @return 正确返回true，否则返回false。
	 */
	public boolean checkSecurityCode(final LKPrototypeEnum busType, final String cellphone, final String securityCode, final int timeout) {
		return checkSecurityCode($systemTag, busType, cellphone, securityCode, timeout);
	}

}
