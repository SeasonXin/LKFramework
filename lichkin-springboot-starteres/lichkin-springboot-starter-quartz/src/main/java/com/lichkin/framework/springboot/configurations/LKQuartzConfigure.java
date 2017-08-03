package com.lichkin.framework.springboot.configurations;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.springboot.db.dao.LKDao;
import com.lichkin.framework.springframework.entities.sys.quartz.SysQuartzEntity;

/**
 * 定时任务基础实现
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
public class LKQuartzConfigure implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private LKDao dao;


	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		try {
			final Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			final List<SysQuartzEntity> listQuartz = dao.findListByHql(new LKSqlVo("from SysQuartzEntity where usingStatus = ?", LKUsingStatusEnum.USING), SysQuartzEntity.class);
			for (final SysQuartzEntity quartz : listQuartz) {
				Class<? extends Job> clazz = null;
				try {
					clazz = (Class<? extends Job>) Class.forName(quartz.getClassName());
				} catch (final ClassNotFoundException e) {
					e.printStackTrace();
				}
				final JobBuilder jobBuilder = JobBuilder.newJob(clazz);
				jobBuilder.withIdentity(quartz.getJobName(), quartz.getGroupName());
				jobBuilder.usingJobData("methodName", quartz.getMethodName());
				final JobDetail jobDetail = jobBuilder.build();
				final CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
				final CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(quartz.getJobName(), quartz.getGroupName()).withSchedule(cron).build();
				scheduler.scheduleJob(jobDetail, trigger);
			}

			scheduler.start();
		} catch (final SchedulerException se) {
			se.printStackTrace();
		}
	}

}
