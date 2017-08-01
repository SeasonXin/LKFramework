-- DROP TABLE IF EXISTS `T_SYS_MAIL`;

CREATE TABLE `T_SYS_MAIL` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ATTACHMENTS` longtext NOT NULL COMMENT '附件列表',
  `BCCS` longtext NOT NULL COMMENT '暗送人列表',
  `CCS` longtext NOT NULL COMMENT '抄送人列表',
  `CONTENT` longtext NOT NULL COMMENT '邮件内容',
  `FROM_ADDRESS` varchar(100) NOT NULL COMMENT '发送人地址',
  `SEND_TIME` varchar(19) NOT NULL COMMENT '发送时间',
  `SUBJECT` varchar(100) NOT NULL COMMENT '邮件标题',
  `TOS` longtext NOT NULL COMMENT '收件人列表',
  PRIMARY KEY (`ID`),
  KEY `I_MAIL__FROM_ADDRESS` (`FROM_ADDRESS`),
  KEY `I_MAIL__SEND_TIME` (`SEND_TIME`),
  KEY `I_MAIL__SUBJECT` (`SUBJECT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件表';



