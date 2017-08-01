-- DROP TABLE IF EXISTS `T_SYS_APP_VERSION`;

CREATE TABLE `T_SYS_APP_VERSION` (
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
  `BRIEF` varchar(100) NOT NULL COMMENT '新版本简介',
  `CURRENT_APP_VERSION` varchar(10) NOT NULL COMMENT '当前版本，V1.0.0',
  `FORCE_UPDATE` varchar(32) NOT NULL COMMENT '是否强制更新',
  `PLATFORM` varchar(32) NOT NULL COMMENT '客户端类型',
  `URL` varchar(100) DEFAULT NULL COMMENT '安卓客户端下载地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户端版本表';



