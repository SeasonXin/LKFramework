package com.lichkin.framework.springboot.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lichkin.framework.springboot.services.LKBaseJobService;

public class JobService extends LKBaseJobService {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public void doJob() {
		logger.debug("doJob");
		logger.debug($systemName);
		logger.debug($systemTag);
	}

}
