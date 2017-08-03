-- DROP TABLE IF EXISTS `T_SYS_NEWS`;

CREATE TABLE `T_SYS_NEWS` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `INSERT_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '新增操作人ID',
  `INSERT_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '新增操作系统标识',
  `INSERT_TIME` varchar(19) NOT NULL COMMENT '新增操作时间(yyyy-MM-dd HH:mm:ss)',
  `REMARKS` longtext COMMENT '备注',
  `UPDATE_LOGIN_ID` varchar(32) DEFAULT NULL COMMENT '更新操作人ID',
  `UPDATE_SYSTEM_TAG` varchar(100) NOT NULL COMMENT '更新操作系统标识',
  `UPDATE_TIME` varchar(19) NOT NULL COMMENT '更新操作时间(yyyy-MM-dd HH:mm:ss)',
  `USING_STATUS` varchar(32) NOT NULL COMMENT '在用状态(枚举)',
  `AUTHOR` varchar(100) DEFAULT NULL COMMENT '作者',
  `BANNER_FILE_ID` varchar(32) DEFAULT NULL COMMENT '轮播图 (对应文件表id)',
  `BRIEF` varchar(200) DEFAULT NULL COMMENT '简介',
  `CATEGORY_CODE` varchar(32) DEFAULT NULL COMMENT '分类(对应字典表ID)',
  `CONTENT` longtext COMMENT '内容',
  `LINK_URL` varchar(200) DEFAULT NULL COMMENT '外链地址',
  `NEWS_TITLE` varchar(50) DEFAULT NULL COMMENT '标题',
  `NEWS_TYPE` varchar(20) DEFAULT NULL COMMENT '类型(枚举)',
  `SORT_NUM` int(2) DEFAULT NULL COMMENT '轮播图序号',
  `THUMBNAIL_FILE_ID` varchar(32) DEFAULT NULL COMMENT '缩略图(对应文件表id)',
  PRIMARY KEY (`ID`),
  KEY `I_NEWS__INSERT_TIME` (`INSERT_TIME`),
  KEY `I_NEWS__USING_STATUS` (`USING_STATUS`),
  KEY `I_NEWS__AUTHOR` (`AUTHOR`),
  KEY `I_NEWS__CATEGORY_CODE` (`CATEGORY_CODE`),
  KEY `I_NEWS__NEWS_TITLE` (`NEWS_TITLE`),
  KEY `I_NEWS__NEWS_TYPE` (`NEWS_TYPE`),
  KEY `I_NEWS__SORT_NUM` (`SORT_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻表';


