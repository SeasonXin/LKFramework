package com.lichkin.framework.springboot.services;

import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.springboot.applications.LKApplicationContext;
import com.lichkin.framework.springboot.daos.LKDao;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 通用基本任务服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKBaseJobService extends LKService implements Job {

	/** 当前任务开始时间 */
	private DateTime startTime;

	/** 当前任务ID */
	private String jobId;

	/** 当前业务ID */
	private String busId;

	/** 数据库访问对象 */
	protected LKDao dao = (LKDao) LKApplicationContext.getBean("dao");


	/**
	 * 执行任务
	 */
	public abstract void doJob();


	/**
	 * 转换为统一日志内容
	 * @param content 日志内容
	 * @return 统一日志内容
	 */
	protected String toUnifyLog(final String content) {
		return "jobId: [" + jobId + "]" + (LKStringUtils.isBlank(busId) ? "" : (", busId: [" + busId + "]")) + "=>" + content;
	}


	@Override
	public void execute(final JobExecutionContext context) throws JobExecutionException {
		startTime = DateTime.now();
		jobId = startTime.toString(LKDatePatternEnum.TIMESTAPFULL.getNameEn()) + LKRandomUtils.create(15);

		logger.info("jobId: [" + jobId + "] starting at " + startTime.toString(LKDatePatternEnum.ALL.getNameEn()) + ".");

		doJob();

		final DateTime endTime = DateTime.now();// 当前任务结束时间
		logger.info("jobId: [" + jobId + "] ended at " + endTime.toString(LKDatePatternEnum.ALL.getNameEn()) + ". consuming " + (endTime.getMillis() - startTime.getMillis()) + " millisecond.");
	}

}
