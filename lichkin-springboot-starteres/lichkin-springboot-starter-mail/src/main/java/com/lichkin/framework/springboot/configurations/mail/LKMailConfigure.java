package com.lichkin.framework.springboot.configurations.mail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.springboot.db.dao.LKDao;
import com.lichkin.framework.springframework.entities.sys.mail.SysConfigMailEntity;

/**
 * 邮件基础实现
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
public class LKMailConfigure implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKDao dao;


	@Override
	public void onApplicationEvent(final ApplicationContextEvent event) {
		LKMailManager.configs = new HashMap<>();
		final List<SysConfigMailEntity> listConfigMail = dao.findListByHql(new LKSqlVo("from SysConfigMailEntity"), SysConfigMailEntity.class);
		for (final SysConfigMailEntity configMail : listConfigMail) {
			LKMailManager.configs.put(configMail.getBusCode(), configMail);
		}
	}

}
