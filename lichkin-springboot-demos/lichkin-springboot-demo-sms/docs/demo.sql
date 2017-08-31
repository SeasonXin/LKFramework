-- 因此涉及账号信息，在此只提供样例，请将此配置为自己的短信相关信息。
INSERT INTO t_sys_config (ID, REMARKS, USING_STATUS, CONFIG_KEY, CONFIG_VALUE, SYSTEM_TAG)
VALUES
('sms01', NULL, 'USING', 'lichkin.business.sms.haiyan.encoding', 'UTF-8', 'LichKin-Project'),
('sms02', NULL, 'USING', 'lichkin.business.sms.haiyan.userid', '用户ID', 'LichKin-Project'),
('sms03', NULL, 'USING', 'lichkin.business.sms.haiyan.account', '账号', 'LichKin-Project'),
('sms04', NULL, 'USING', 'lichkin.business.sms.haiyan.password', '密码', 'LichKin-Project'),
('sms05', NULL, 'USING', 'lichkin.business.sms.msg.DEMO', '#name，您好！~', 'LichKin-Project');
