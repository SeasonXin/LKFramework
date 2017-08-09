package com.lichkin.framework.springboot.web.services.impl;

import org.springframework.stereotype.Service;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.springboot.services.LKLoginService;
import com.lichkin.framework.springboot.web.LKSessionUser;

/**
 * web后台项目必须要实现登录逻辑，并返回登录信息对象，此为demo项目，暂未实现登录逻辑。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LoginService extends LKLoginService {

	@Override
	public LKSessionUser doLogin(final LKDatas requestDatas) {
		return null;
	}

}
