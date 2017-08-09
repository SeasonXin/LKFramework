package com.lichkin.framework.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.enums.LKSmsSenderEnum;
import com.lichkin.framework.springboot.services.impl.LKSysSmsService;
import com.lichkin.framework.springboot.utils.LKSmsUtils;

@Component
@Order(value = 1)
public class Runner implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKSysSmsService service;


	@Override
	public void onApplicationEvent(final ApplicationContextEvent event) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (final InterruptedException e1) {
					e1.printStackTrace();
				}

				service.sendSms(LKSmsSenderEnum.HAI_YAN, BusinessEnum.DEMO, "18621118733", LKSmsUtils.getSmsMsg(BusinessEnum.DEMO, new LKDatas().put("#name", "庄绪鑫")), true);
			}

		}).start();
	}

}
