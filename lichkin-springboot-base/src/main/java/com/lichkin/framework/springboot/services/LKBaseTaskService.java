package com.lichkin.framework.springboot.services;

import org.joda.time.DateTime;

import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 通用基本任务服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKBaseTaskService extends LKService {

	/** 当前任务开始时间 */
	private final DateTime startTime = DateTime.now();

	/** 当前任务ID */
	private final String taskId = startTime.toString(LKDatePatternEnum.TIMESTAPFULL.getNameEn()) + LKRandomUtils.create(15);

	/** 当前业务ID */
	private String busId;


	/**
	 * 执行任务
	 */
	public void executeTask() {
		logger.info("taskId: [" + taskId + "] starting at " + startTime.toString(LKDatePatternEnum.ALL.getNameEn()) + ".");

		doTask();

		final DateTime endTime = DateTime.now();// 当前任务结束时间
		logger.info("taskId: [" + taskId + "] ended at " + endTime.toString(LKDatePatternEnum.ALL.getNameEn()) + ". consuming " + (endTime.getMillis() - startTime.getMillis()) + " millisecond.");
	}


	/**
	 * 执行任务
	 */
	public abstract void doTask();


	/**
	 * 转换为统一日志内容
	 * @param content 日志内容
	 * @return 统一日志内容
	 */
	protected String toUnifyLog(final String content) {
		return "taskId: [" + taskId + "]" + (LKStringUtils.isBlank(busId) ? "" : (", busId: [" + busId + "]")) + "=>" + content;
	}

}
