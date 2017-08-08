package com.lichkin.framework.springboot.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;

import com.lichkin.framework.mail.bean.LKSysMailInfoBean;
import com.lichkin.framework.springboot.configurations.LKMailManager;
import com.lichkin.framework.springboot.services.impl.LKSysMailService;

@Configuration
public class MailService implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private LKSysMailService service;


	@Override
	public void onApplicationEvent(final ApplicationContextEvent event) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}

				final Map<String, String> datas = new HashMap<>();
				datas.put("#date", DateTime.now().toString("yyyy-MM-dd"));
				datas.put("#who", "是我");
				final LKSysMailInfoBean mailInfo = LKMailManager.getMailInfo("demo", datas);
				if (mailInfo != null) {
					mailInfo.addTo("zhuangxuxin@hotmail.com", "庄绪鑫");
					mailInfo.addTo("lichkin@lichkin.com", "LichKin");
					mailInfo.addCc("zhuangxuxin@hotmail.com", "庄绪鑫");
					mailInfo.addCc("service@lichkin.com", "Service");
					mailInfo.addBcc("zhuang.xu.xin@icloud.com", "ZXX");
					mailInfo.addBcc("zhuangxuxin@lichkin.com", "Kin");
					mailInfo.addBcc("zhuangxuxin@hotmail.com", "庄绪鑫");
					mailInfo.addAttachment(new File("C:\\Gits\\LKFramework\\lichkin-springboot-demos\\lichkin-springboot-demo-mail\\README.md"));
					mailInfo.addAttachment(new File("C:\\Gits\\LKFramework\\lichkin-springboot-demos\\lichkin-springboot-demo-mail\\pom.xml"));
					service.sendMail(mailInfo, true);
				}
			}

		}).start();
	}

}
