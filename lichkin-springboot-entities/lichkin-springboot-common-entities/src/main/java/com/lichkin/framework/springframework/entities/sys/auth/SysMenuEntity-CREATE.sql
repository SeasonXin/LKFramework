-- DROP TABLE IF EXISTS `T_SYS_MENU`;

CREATE TABLE `T_SYS_MENU` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `REMARKS` longtext COMMENT '备注',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `ASSIGNABLE` varchar(32) DEFAULT NULL COMMENT '是否可分配',
  `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `MENU_CODE` varchar(32) NOT NULL COMMENT '菜单编码',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单名称',
  `ORDER_ID` tinyint(4) NOT NULL COMMENT '排序号',
  `PARENT_CODE` varchar(32) DEFAULT NULL COMMENT '父菜单编码',
  `SYSTEM_TAG` varchar(100) NOT NULL COMMENT '系统标识',
  `URL` varchar(200) DEFAULT NULL COMMENT '菜单地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';



