-- DROP TABLE IF EXISTS `T_SYS_DICTIONARY`;

CREATE TABLE `T_SYS_DICTIONARY` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `REMARKS` longtext COMMENT '备注',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态',
  `CATEGORY_CODE` varchar(32) NOT NULL COMMENT '类目编号',
  `DICT_CODE` varchar(32) NOT NULL COMMENT '字典编号',
  `DICT_NAME` varchar(200) NOT NULL COMMENT '字典名称',
  `DICT_VALUE` varchar(200) NOT NULL COMMENT '字典值',
  `ORDER_ID` tinyint(4) NOT NULL COMMENT '排序号',
  PRIMARY KEY (`ID`),
  KEY `I_DICTIONARY__CATEGORY_CODE` (`CATEGORY_CODE`),
  KEY `I_DICTIONARY__DICT_CODE` (`DICT_CODE`),
  KEY `I_DICTIONARY__DICT_NAME` (`DICT_NAME`),
  KEY `I_DICTIONARY__USING_STATUS` (`USING_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';




