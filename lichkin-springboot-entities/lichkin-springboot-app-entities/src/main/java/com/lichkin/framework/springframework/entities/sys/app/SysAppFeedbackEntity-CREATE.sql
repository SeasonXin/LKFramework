-- DROP TABLE IF EXISTS `T_SYS_APP_FEEDBACK`;

CREATE TABLE `T_SYS_APP_FEEDBACK` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `REMARKS` longtext COMMENT '备注',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `APP_NAME` varchar(50) NOT NULL COMMENT '客户端名称',
  `CONTACT_WAY` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `CURRENT_APP_VERSION` varchar(10) NOT NULL COMMENT '当前版本，V1.0.0',
  `FEEDBACK_FILE_IDS` varchar(200) DEFAULT NULL COMMENT '反馈文件IDs',
  `PLATFORM` varchar(32) NOT NULL COMMENT '客户端类型',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户端反馈表';



