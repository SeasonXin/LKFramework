-- DROP TABLE IF EXISTS `T_SYS_FTP`;

CREATE TABLE `T_SYS_FTP` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `REMARKS` longtext COMMENT '备注',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `EXT_NAME` varchar(5) NOT NULL COMMENT '扩展名',
  `FILE_FULL_NAME` varchar(150) NOT NULL COMMENT '文件全名',
  `FILE_NAME` varchar(50) NOT NULL COMMENT '文件名',
  `FILE_SIZE` bigint(20) NOT NULL COMMENT '文件大小',
  `MD5` varchar(32) NOT NULL COMMENT '文件MD5值',
  `RELATIVE_PATH` varchar(21) NOT NULL COMMENT '相对路径',
  `ROOT_PATH` varchar(25) NOT NULL COMMENT '根路径',
  `SERVER_PATH` varchar(50) DEFAULT NULL COMMENT 'FTP服务器地址',
  `SHOW_NAME` varchar(15) NOT NULL COMMENT '显示名',
  PRIMARY KEY (`ID`),
  KEY `I_FTP__USING_STATUS` (`USING_STATUS`),
  KEY `I_FTP__INSERT_TIME` (`INSERT_TIME`),
  KEY `I_FTP__EXT_NAME` (`EXT_NAME`),
  KEY `I_FTP__MD5` (`MD5`),
  KEY `I_FTP__ROOT_PATH` (`ROOT_PATH`),
  KEY `I_FTP__SERVER_PATH` (`SERVER_PATH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';



