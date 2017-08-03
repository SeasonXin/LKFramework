package com.lichkin.framework.springboot.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.services.LKBaseTaskService;

@Service
public class TaskService extends LKBaseTaskService {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public void doTask() {
		logger.debug("doTask");
		for (int i = 0; i < 10000000; i++) {
		}
	}

}
