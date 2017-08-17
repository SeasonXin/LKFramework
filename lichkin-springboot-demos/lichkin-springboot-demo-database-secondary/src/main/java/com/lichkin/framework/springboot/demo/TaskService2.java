package com.lichkin.framework.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.daos.LKDao;
import com.lichkin.framework.springboot.demo.entity.impl.DemoSecondaryEntity;
import com.lichkin.framework.springboot.services.LKBaseTaskDBService;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 定时任务业务处理服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class TaskService2 extends LKBaseTaskDBService {

	@Autowired
	private LKDao dao2;

	@Override
	public void doTask() {
		logger.debug("doTask2");
		logger.debug($systemTag);
		logger.debug($systemName);
		for (int i = 0; i < 10000000; i++) {
		}
		query();
		save();
	}


	/**
	 * 查询数据
	 */
	public void query() {
		logger.debug("查询数据2");
		logger.debug(LKJSONUtils.toJson(dao2.findOneById(DemoSecondaryEntity.class, "demo"), false, false));
	}


	/**
	 * 保存数据
	 */
	public void save() {
		logger.debug("保存数据2");
		final DemoSecondaryEntity demo = new DemoSecondaryEntity();
		demo.setFieldStr("demo str2");
		dao2.save(demo);
	}

}
