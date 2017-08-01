-- DROP TABLE IF EXISTS `T_SYS_MQ_LOG`;

CREATE TABLE `T_SYS_MQ_LOG` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `HANDLE_FINISHED` varchar(32) NOT NULL COMMENT '处理结束状态',
  `HANDLE_ID` varchar(32) NOT NULL COMMENT '处理ID',
  `MSG_DETAIL` longtext NOT NULL COMMENT '消息详情',
  `MSG_ID` varchar(100) NOT NULL COMMENT '消息ID',
  `READ_TIME` varchar(19) NOT NULL COMMENT '读取时间',
  `TEXT_INFO` longtext NOT NULL COMMENT '消息text信息',
  `VALUE_INFO` longtext NOT NULL COMMENT '消息value信息',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `I_MQ_LOG__MSG_ID` (`MSG_ID`),
  KEY `I_MQ_LOG__READ_TIME` (`READ_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息队列记录表';



