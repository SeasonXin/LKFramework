INSERT INTO db_test.t_sys_config (ID,REMARKS,USING_STATUS,CONFIG_KEY,CONFIG_VALUE,SYSTEM_TAG)
VALUES 
('wechat.00.debug',NULL,'USING','lichkin.framework.wechat.debug','false','LichKin-Project')
('wechat.00.debug.openid',NULL,'USING','lichkin.framework.wechat.debug.openid','oZwfPviq9MDTmNSwnpOHzSJmtijA','LichKin-Project'),
('wechat.01.appid',NULL,'USING','lichkin.framework.wechat.appid','wx1234567890','LichKin-Project'),
('wechat.02.secret',NULL,'USING','lichkin.framework.wechat.secret','1234567890','LichKin-Project'),
('wechat.03.token',NULL,'USING','lichkin.framework.wechat.token','lichkin','LichKin-Project'),
('wechat.04.project.url',NULL,'USING','lichkin.framework.wechat.project.url','http://localhost:8080','LichKin-Project'),
('wechat.apiUrls.authorize',NULL,'USING','lichkin.framework.wechat.apiUrls.authorize','https://open.weixin.qq.com/connect/oauth2/authorize?appid=#appid&redirect_uri=#projectUrl%2Flichkin%2Fwechat%2Foauth2%2Fredirect.html%3FbtnName%3D#btnName&response_type=code&scope=snsapi_base&state=#state	#wechat_redirect','LichKin-Project'),
('wechat.apiUrls.getAccessToken',NULL,'USING','lichkin.framework.wechat.apiUrls.getAccessToken','https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=#appid&secret=#secret','LichKin-Project'),
('wechat.apiUrls.getJsTicket',NULL,'USING','lichkin.framework.wechat.apiUrls.getJsTicket','https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=#access_token&type=jsapi','LichKin-Project'),
('wechat.apiUrls.getOpenid',NULL,'USING','lichkin.framework.wechat.apiUrls.getOpenid','https://api.weixin.qq.com/sns/oauth2/access_token?appid=#appid&secret=#secret&code=#code&grant_type=authorization_code','LichKin-Project'),
('wechat.apiUrls.menuCreate',NULL,'USING','lichkin.framework.wechat.apiUrls.menuCreate','https://api.weixin.qq.com/cgi-bin/menu/create?access_token=#access_token','LichKin-Project')
('wechat.msg.demo.templateId',NULL,'USING','lichkin.framework.wechat.msg.demo.templateId','123456','LichKin-Project'),
('wechat.msg.demo.url',NULL,'USING','lichkin.framework.wechat.msg.demo.url','http://localhost:8080/demo.html','LichKin-Project'),
('wechat.msg.welcome.description',NULL,'USING','lichkin.framework.wechat.msg.welcome.description','苏州鑫宏利业信息科技有限公司','LichKin-Project'),
('wechat.msg.welcome.picUrl',NULL,'USING','lichkin.framework.wechat.msg.welcome.picUrl','http://yun.baidu.com/share/link?shareid=1843259259&uk=1469070818','LichKin-Project'),
('wechat.msg.welcome.title',NULL,'USING','lichkin.framework.wechat.msg.welcome.title','欢迎访问鑫宏利业微信公众号','LichKin-Project'),
('wechat.msg.welcome.url',NULL,'USING','lichkin.framework.wechat.msg.welcome.url','http://localhost:8080/welcome.html?openid=#openid','LichKin-Project')
;