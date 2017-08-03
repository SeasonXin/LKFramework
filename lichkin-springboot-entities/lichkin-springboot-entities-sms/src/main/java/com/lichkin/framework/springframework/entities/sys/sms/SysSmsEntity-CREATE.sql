-- DROP TABLE IF EXISTS `T_SYS_SMS`;

CREATE TABLE `T_SYS_SMS` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `CELLPHONE` varchar(11) NOT NULL COMMENT '手机号码',
  `MESSAGE` varchar(255) NOT NULL COMMENT '短信内容',
  `SEND_TIME` varchar(19) DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`ID`),
  KEY `I_SMS__CELLPHONE` (`CELLPHONE`),
  KEY `I_SMS__SEND_TIME` (`SEND_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信表';


