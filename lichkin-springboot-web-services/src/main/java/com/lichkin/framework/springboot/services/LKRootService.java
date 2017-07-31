package com.lichkin.framework.springboot.services;

import org.springframework.stereotype.Service;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.web.LKSessionUser;

/**
 * 根路径服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public abstract class LKRootService extends LKDBService {

	/**
	 * 登录
	 * @param requestDatas 请求参数，由框架自动解析请求的参数并注入。
	 * @return 成功返回登录信息，否则返回null。
	 */
	public abstract LKSessionUser doLogin(LKDatas requestDatas);

}
