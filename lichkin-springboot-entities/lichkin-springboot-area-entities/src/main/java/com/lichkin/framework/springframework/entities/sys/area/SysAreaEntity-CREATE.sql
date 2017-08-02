-- DROP TABLE IF EXISTS `T_SYS_AREA`;

CREATE TABLE `T_SYS_AREA` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `AREA_LEVEL` varchar(32) NOT NULL COMMENT '区域等级',
  `AREA_NAME` varchar(100) NOT NULL COMMENT '区域名称',
  `TELEPHONE_CODE` varchar(6) DEFAULT NULL COMMENT '电话号码编码',
  `USER_CARD_CODE` varchar(6) NOT NULL COMMENT '身份证号码编码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';



