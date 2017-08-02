package com.lichkin.framework.springboot.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lichkin.framework.springframework.LKProperties;

/**
 * 通用服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKService {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());

	/** 当前系统标识 */
	protected String $systemTag = LKProperties.LK_SYSTEM_TAG;

	/** 当前系统名称 */
	protected String $systemName = LKProperties.LK_SYSTEM_NAME;

}
