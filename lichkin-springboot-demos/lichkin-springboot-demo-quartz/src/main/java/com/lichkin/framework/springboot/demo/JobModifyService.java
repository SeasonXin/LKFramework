package com.lichkin.framework.springboot.demo;

import org.quartz.CronTrigger;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;

import com.lichkin.framework.springboot.configurations.LKQuartzManager;
import com.lichkin.framework.springboot.daos.LKDao;
import com.lichkin.framework.springboot.entities.impl.SysConfigQuartzEntity;

@Configuration
public class JobModifyService implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKDao dao;


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
				System.out.println("JobModifyService running");

				final SysConfigQuartzEntity quartz = dao.findOneById(SysConfigQuartzEntity.class, "1");
				quartz.setCronExpression("0/10 * * * * ?");// 修改为10秒执行一次
				final CronTrigger trigger = LKQuartzManager.rebuildCronTrigger(quartz);
				try {
					LKQuartzManager.getScheduler().rescheduleJob(trigger.getKey(), trigger);
				} catch (final SchedulerException e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

}
