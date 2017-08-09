package com.lichkin.framework.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lichkin.framework.springboot.entities.impl.SysSecurityCodeEntity;
import com.lichkin.framework.springboot.services.impl.LKSysScService;

@Component
@Order(value = 1)
public class Runner implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKSysScService service;

	private final boolean useTimeout = false;


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

				final SysSecurityCodeEntity sc = service.createSecurityCode(BusinessEnum.DEMO, "18621118733", 6, 1);

				if (useTimeout) {
					try {
						Thread.sleep(61000);
					} catch (final InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(service.checkSecurityCode(BusinessEnum.DEMO, "18621118733", sc.getSecurityCode(), 1));
			}

		}).start();
	}

}
