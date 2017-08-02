-- DROP TABLE IF EXISTS `T_SYS_ROLE`;

CREATE TABLE `T_SYS_ROLE` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `REMARKS` longtext COMMENT '备注',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `DESCRIPTION` varchar(100) NOT NULL COMMENT '描述',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称',
  `SYSTEM_TAG` varchar(100) NOT NULL COMMENT '系统标识',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';



