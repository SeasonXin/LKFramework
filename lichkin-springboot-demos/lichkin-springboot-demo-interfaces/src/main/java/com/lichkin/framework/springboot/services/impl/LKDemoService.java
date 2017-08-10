package com.lichkin.framework.springboot.services.impl;

import org.springframework.stereotype.Service;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.springboot.entities.impl.SysConfigEntity;
import com.lichkin.framework.springboot.services.LKInterfacesBaseService;

/**
 * 基本的业务处理
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKDemoService extends LKInterfacesBaseService {

	public Object doDemo(final LKDatas datas) {
		logger.debug(datas);
		return dao.findListByHql(new LKSqlVo("from SysConfigEntity where usingStatus = ? and systemTag = ?").addParam(LKUsingStatusEnum.USING).addParam($systemTag), SysConfigEntity.class);
	}

}
