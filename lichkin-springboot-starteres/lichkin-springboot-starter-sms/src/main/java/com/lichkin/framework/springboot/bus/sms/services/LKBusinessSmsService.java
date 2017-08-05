package com.lichkin.framework.springboot.bus.sms.services;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springboot.bus.sms.enums.LKSmsSenderEnum;
import com.lichkin.framework.springboot.bus.sms.utils.LKSmsHaiYanSender;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springframework.entities.sys.sms.SysSmsEntity;
import com.lichkin.framework.utils.lang.LKStringUtils;
import com.lichkin.framework.utils.regix.LKCommonValidator;

/**
 * 短信服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKBusinessSmsService extends LKDBService {

	/**
	 * 发送短信
	 * @param systemTag 系统标识
	 * @param sender 短信平台
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param message 短信内容
	 * @param threaded 单线程为true，方法将等待短信接口返回结果后继续执行，可以捕获到接口调用的异常信息；多线程为false，方法将开启一个新的线程调用短信接口，接口调用异常将只做日志输出。
	 */
	@Transactional
	public void sendSms(final String systemTag, final LKSmsSenderEnum sender, final LKPrototypeEnum busType, final String cellphone, final String message, boolean threaded) {
		// 参数验证
		LKCommonValidator.validateCellphone(cellphone);
		if (LKStringUtils.isBlank(message)) {
			throw new LKRuntimeException(LKErrorCodeEnum.PARAMS_EXCEPTION, "message is null.");
		}

		// 保存短信
		SysSmsEntity sms = new SysSmsEntity();
		sms.setSystemTag(systemTag);
		sms.setBusType(busType.toString());
		sms.setCellphone(cellphone);
		sms.setMessage(message);
		sms.setSendTime(DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn()));
		dao.save(sms);

		if (threaded) {
			try {
				// 发送短息
				String result = null;
				switch (sender) {
					case HAI_YAN:
						result = LKSmsHaiYanSender.getInstance().doSendSms(cellphone, message);
					break;
				}
				// 打印日志
				logger.info(LKStringUtils.format2SingleLine(result));
				// TODO 接口返回处理失败抛出异常
			} catch (Exception e) {
				logger.error(e);
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
			}
		} else {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						// 发送短息
						String result = null;
						switch (sender) {
							case HAI_YAN:
								result = LKSmsHaiYanSender.getInstance().doSendSms(cellphone, message);
							break;
						}
						// 打印日志
						logger.info(LKStringUtils.format2SingleLine(result));
						// TODO 接口返回处理失败输出错误日志
					} catch (Exception e) {
						logger.error(e);
					}
				}

			});
			t.start();
		}
	}


	/**
	 * 发送短信
	 * @param sender 短信平台
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param message 短信内容
	 * @param threaded 单线程为true，方法将等待短信接口返回结果后继续执行，可以捕获到接口调用的异常信息；多线程为false，方法将开启一个新的线程调用短信接口，接口调用异常将只做日志输出。
	 */
	@Transactional
	public void sendSms(final LKSmsSenderEnum sender, final LKPrototypeEnum busType, final String cellphone, final String message, boolean threaded) {
		sendSms($systemTag, sender, busType, cellphone, message, threaded);
	}

}
