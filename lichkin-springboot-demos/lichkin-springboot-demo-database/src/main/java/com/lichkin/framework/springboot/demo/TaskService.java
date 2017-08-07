package com.lichkin.framework.springboot.demo;

import org.springframework.stereotype.Service;

import com.lichkin.framework.springboot.demo.entities.DemoEntity;
import com.lichkin.framework.springboot.services.LKBaseTaskDBService;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 定时任务业务处理服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class TaskService extends LKBaseTaskDBService {

	@Override
	public void doTask() {
		logger.debug("doTask");
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
		logger.debug("查询数据");
		logger.debug(LKJSONUtils.toJson(dao.findOneById(DemoEntity.class, "1"), false, false));
	}


	/**
	 * 保存数据
	 */
	public void save() {
		logger.debug("保存数据");
		final DemoEntity demo = new DemoEntity();
		demo.setFieldStr("demo str");
		dao.save(demo);
	}

}
