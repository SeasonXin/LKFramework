-- DROP TABLE IF EXISTS `T_SYS_WECHAT_TOKEN`;

CREATE TABLE `T_SYS_WECHAT_TOKEN` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ACCESS_TOKEN` longtext NOT NULL COMMENT '微信全局唯一票据',
  `EXPIRES_IN` int(11) NOT NULL COMMENT '凭证有效时间',
  `REQUEST_TIME` varchar(19) NOT NULL COMMENT '获取凭证时间',
  `TOKEN_TYPE` tinyint(4) NOT NULL COMMENT '凭证类型。0:accessToken;1:jsapi_ticket;',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信access_token';



