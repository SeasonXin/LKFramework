-- DROP TABLE IF EXISTS `T_SYS_ADMIN_LOGIN`;

CREATE TABLE `T_SYS_ADMIN_LOGIN` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `REMARKS` longtext COMMENT '备注',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `BUS_ID` varchar(50) DEFAULT NULL COMMENT '业务ID',
  `CELLPHONE` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `CHECK_CODE` varchar(32) DEFAULT NULL COMMENT '校验码',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `ERROR_TIMES` tinyint(4) DEFAULT NULL COMMENT '密码错误次数',
  `FIELD1` varchar(200) DEFAULT NULL COMMENT '备用字段',
  `FIELD2` varchar(200) DEFAULT NULL COMMENT '备用字段',
  `FIELD3` varchar(200) DEFAULT NULL COMMENT '备用字段',
  `LOGIN_NAME` varchar(32) NOT NULL COMMENT '登录名',
  `PWD` varchar(32) NOT NULL COMMENT '密码(MD5)',
  `SECURITY_CODE` varchar(10) DEFAULT NULL COMMENT '验证码',
  `SYSTEM_TAG` varchar(100) NOT NULL COMMENT '系统标识',
  `TOKEN` varchar(32) DEFAULT NULL COMMENT '登录token',
  `USER_CARD` varchar(64) DEFAULT NULL COMMENT '身份证号码',
  `USER_ID` varchar(32) NOT NULL COMMENT '人员ID',
  PRIMARY KEY (`ID`),
  KEY `I_ADMIN_LOGIN__USING_STATUS` (`USING_STATUS`),
  KEY `I_ADMIN_LOGIN__INSERT_TIME` (`INSERT_TIME`),
  KEY `I_ADMIN_LOGIN__BUS_ID` (`BUS_ID`),
  KEY `I_ADMIN_LOGIN__USER_ID` (`USER_ID`),
  KEY `I_ADMIN_LOGIN__CELLPHONE` (`CELLPHONE`),
  KEY `I_ADMIN_LOGIN__EMAIL` (`EMAIL`),
  KEY `I_ADMIN_LOGIN__USER_CARD` (`USER_CARD`),
  KEY `I_ADMIN_LOGIN__LOGIN_NAME` (`LOGIN_NAME`),
  KEY `I_ADMIN_LOGIN__SYSTEM_TAG` (`SYSTEM_TAG`),
  KEY `I_ADMIN_LOGIN__TOKEN` (`TOKEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员登录表';


