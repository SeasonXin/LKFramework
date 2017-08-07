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


	@Scheduled(cron = "0 0/1 * * * ?")
	public void statusCheck() {
		logger.info("每分钟执行一次");
		taskService.executeTask();
	}


	@Scheduled(fixedRate = 20000)
	public void testTasks() {
		logger.info("每20秒执行一次");
		taskService.executeTask();
	}

}
