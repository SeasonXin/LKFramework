package com.lichkin.framework.springboot.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.quartz.services.LKBaseJobService;

@Service
public class JobService extends LKBaseJobService {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public void doJob() {
		logger.debug("doJob");
		for (int i = 0; i < 10000000; i++) {
		}
	}

}
