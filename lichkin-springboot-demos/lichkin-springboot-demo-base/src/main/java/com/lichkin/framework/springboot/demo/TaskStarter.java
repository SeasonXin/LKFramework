package com.lichkin.framework.springboot.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务启动类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component
@EnableScheduling
public class TaskStarter {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private TaskService taskService;


	@Scheduled(cron = "0/5 * * * * ?")
	public void statusCheck() {
		logger.info("每5秒钟执行一次");
		taskService.executeTask();
	}


	@Scheduled(fixedRate = 3000)
	public void testTasks() {
		logger.info("每3秒钟执行一次");
		taskService.executeTask();
	}

}
