-- DROP TABLE IF EXISTS `T_SYS_WECHAT_MENU`;

CREATE TABLE `T_SYS_WECHAT_MENU` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `BTN_NAME` varchar(10) NOT NULL COMMENT '按钮名称',
  `BTN_TYPE` varchar(5) NOT NULL COMMENT '按钮类型',
  `X` tinyint(4) NOT NULL COMMENT '按钮位于菜单的横坐标',
  `Y` tinyint(4) NOT NULL COMMENT '按钮位于菜单的纵坐标',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信菜单表';



