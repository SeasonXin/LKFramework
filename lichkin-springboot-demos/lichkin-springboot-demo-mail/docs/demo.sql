-- 因此涉及账号信息，在此只提供样例，请将此配置为自己的邮箱相关信息。
INSERT INTO t_sys_config_mail (ID, AUTH, BUS_CODE, CONTENT, FROM_ADDRESS, FROM_DISPLAY_NAME, FROM_HOST, FROM_PASSWORD, FROM_PORT, FROM_USER_NAME, SUBJECT)
VALUES('demo', 1, 'DEMO', '#name，你好！~，感谢您的使用。', 'error.log@lichkin.com', '鑫宏利业', 'smtp.exmail.qq.com', '密码', '25', 'error.log@lichkin.com', '鑫宏利业（测试邮件） at #date');
