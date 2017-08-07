package com.lichkin.framework.springboot.demo;

import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.services.LKBaseTaskService;

/**
 * 定时任务业务处理服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class TaskService extends LKBaseTaskService {

	@Override
	public void doTask() {
		logger.debug("doTask");
		logger.debug($systemTag);
		logger.debug($systemName);
		for (int i = 0; i < 10000000; i++) {
		}
	}

}
