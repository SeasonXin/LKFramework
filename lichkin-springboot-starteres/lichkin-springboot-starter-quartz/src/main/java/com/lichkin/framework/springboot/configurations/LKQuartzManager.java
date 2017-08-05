package com.lichkin.framework.springboot.configurations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.springframework.entities.sys.quartz.SysConfigQuartzEntity;

/**
 * 定时任务管理类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKQuartzManager {

	/** 日志对象 */
	protected static final Log logger = LogFactory.getLog(LKQuartzManager.class);

	/** Scheduler */
	static Scheduler scheduler;


	/**
	 * 获取Scheduler
	 * @return Scheduler
	 */
	public static Scheduler getScheduler() {
		if (LKQuartzManager.scheduler == null) {
			try {
				LKQuartzManager.logger.warn("scheduler is null, we create a new one for this.");
				LKQuartzManager.scheduler = StdSchedulerFactory.getDefaultScheduler();
			} catch (final SchedulerException e) {
				throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
			}
		}
		return LKQuartzManager.scheduler;
	}


	/**
	 * 构建任务详情
	 * @param configQuartz 定时任务对象
	 * @return 任务详情
	 */
	@SuppressWarnings("unchecked")
	public static JobDetail buildJobDetail(final SysConfigQuartzEntity configQuartz) {
		Class<? extends Job> clazz = null;
		try {
			clazz = (Class<? extends Job>) Class.forName(configQuartz.getClassName());
		} catch (final ClassNotFoundException e) {
			throw new LKRuntimeException(LKErrorCodeEnum.ERROR, e);
		}
		final JobBuilder jobBuilder = JobBuilder.newJob(clazz);
		jobBuilder.withIdentity(configQuartz.getJobName(), configQuartz.getGroupName());
		jobBuilder.usingJobData("methodName", configQuartz.getMethodName());
		final JobDetail jobDetail = jobBuilder.build();
		return jobDetail;
	}


	/**
	 * 构建触发器
	 * @param configQuartz 定时任务对象
	 * @param rebuild 是否是重新构建
	 * @return 触发器
	 */
	@SuppressWarnings("unchecked")
	public static CronTrigger buildCronTrigger(final SysConfigQuartzEntity configQuartz, final boolean rebuild) {
		TriggerBuilder<Trigger> triggerBuilder = null;
		if (rebuild) {
			try {
				final Trigger trigger = LKQuartzManager.scheduler.getTrigger(new TriggerKey(configQuartz.getJobName(), configQuartz.getGroupName()));
				if (trigger == null) {
					throw new LKRuntimeException(LKErrorCodeEnum.ERROR, "no trigger to rebuild.");
				}
				triggerBuilder = (TriggerBuilder<Trigger>) trigger.getTriggerBuilder();
			} catch (final SchedulerException e) {
				e.printStackTrace();
			}
		} else {
			triggerBuilder = TriggerBuilder.newTrigger();
		}
		triggerBuilder.withIdentity(configQuartz.getJobName(), configQuartz.getGroupName());
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(configQuartz.getCronExpression()));
		return (CronTrigger) triggerBuilder.build();
	}


	/**
	 * 构建触发器
	 * @param configQuartz 定时任务对象
	 * @return 触发器
	 */
	public static CronTrigger buildCronTrigger(final SysConfigQuartzEntity configQuartz) {
		return LKQuartzManager.buildCronTrigger(configQuartz, false);
	}


	/**
	 * 重新构建触发器
	 * @param configQuartz 定时任务对象
	 * @return 触发器
	 */
	public static CronTrigger rebuildCronTrigger(final SysConfigQuartzEntity configQuartz) {
		return LKQuartzManager.buildCronTrigger(configQuartz, true);
	}

}
