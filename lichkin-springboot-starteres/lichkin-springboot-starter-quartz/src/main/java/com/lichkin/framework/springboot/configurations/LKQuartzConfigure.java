package com.lichkin.framework.springboot.configurations;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.springboot.db.dao.LKDao;
import com.lichkin.framework.springframework.entities.sys.quartz.SysConfigQuartzEntity;

/**
 * 定时任务基础实现
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
public class LKQuartzConfigure implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKDao dao;


	@Override
	public void onApplicationEvent(final ApplicationContextEvent event) {
		final Scheduler scheduler = LKQuartzManager.getScheduler();
		try {
			final List<SysConfigQuartzEntity> listConfigQuartz = dao.findListByHql(new LKSqlVo("from SysConfigQuartzEntity where usingStatus = ?", LKUsingStatusEnum.USING), SysConfigQuartzEntity.class);
			for (final SysConfigQuartzEntity configQuartz : listConfigQuartz) {
				scheduler.scheduleJob(LKQuartzManager.buildJobDetail(configQuartz), LKQuartzManager.buildCronTrigger(configQuartz));
			}
			scheduler.start();
		} catch (final SchedulerException se) {
			se.printStackTrace();
		}
	}

}
