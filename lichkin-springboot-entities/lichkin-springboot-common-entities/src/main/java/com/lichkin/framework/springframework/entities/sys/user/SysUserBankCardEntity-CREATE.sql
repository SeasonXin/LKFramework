-- DROP TABLE IF EXISTS `T_SYS_USER_BANK_CARD`;

CREATE TABLE `T_SYS_USER_BANK_CARD` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ACTIVATE_DATE` varchar(19) DEFAULT NULL COMMENT '激活时间',
  `ALIAS` varchar(50) DEFAULT NULL COMMENT '别名',
  `BANK_ACCOUNT_NUM_MASK` varchar(32) DEFAULT NULL COMMENT '银行卡号掩码',
  `BANK_BRANCH` varchar(100) DEFAULT NULL COMMENT '支行名称',
  `BANK_CODE` varchar(32) DEFAULT NULL COMMENT '银行编号',
  `BANK_NAME` varchar(100) DEFAULT NULL COMMENT '银行名称',
  `BANKCARD_ID` varchar(32) DEFAULT NULL COMMENT '银行卡绑定Id',
  `BRANCH_NO` varchar(32) DEFAULT NULL COMMENT '联行号',
  `CARD_ATTRIBUTE` varchar(32) DEFAULT NULL COMMENT '卡属性',
  `CARD_SKIN` varchar(32) DEFAULT NULL COMMENT '银行卡皮肤',
  `CARD_TYPE` varchar(32) DEFAULT NULL COMMENT '卡类型',
  `CARD_VALID_DATE` varchar(32) DEFAULT NULL COMMENT '卡验证时间',
  `CERT_NUM` varchar(18) DEFAULT NULL COMMENT '证件号',
  `CERT_TYPE` varchar(32) DEFAULT NULL COMMENT '证件类型',
  `CHANNEL_CODE` varchar(32) DEFAULT NULL COMMENT '渠道编码',
  `CHECK_CODE` varchar(32) DEFAULT NULL COMMENT '校验码',
  `CITY` varchar(32) DEFAULT NULL COMMENT '城市',
  `EXTENTION` varchar(200) DEFAULT NULL COMMENT '扩展信息',
  `FINANCIAL_CARD` varchar(50) DEFAULT NULL COMMENT '金融卡',
  `IS_SIGNING` varchar(32) DEFAULT NULL COMMENT '是否签约',
  `IS_VERIFIED` varchar(32) DEFAULT NULL COMMENT '是否认证',
  `LOGIN_ID` varchar(32) NOT NULL COMMENT '登录ID',
  `MEMBER_ID` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `MOBILE_NUM` varchar(11) DEFAULT NULL COMMENT '手机号',
  `PAY_ATTRIBUTE` varchar(32) DEFAULT NULL COMMENT '支付属性',
  `PROVINCE` varchar(32) DEFAULT NULL COMMENT '省份',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '户名',
  `STATUS` varchar(32) DEFAULT NULL COMMENT '状态',
  `UPDATE_TIME` varchar(19) DEFAULT NULL COMMENT '更新时间',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`),
  KEY `I_USER_BANK_CARD__USER_ID` (`USER_ID`),
  KEY `I_USER_BANK_CARD__LOGIN_ID` (`LOGIN_ID`),
  KEY `I_USER_BANK_CARD__REAL_NAME` (`REAL_NAME`),
  KEY `I_USER_BANK_CARD__MOBILE_NUM` (`MOBILE_NUM`),
  KEY `I_USER_BANK_CARD__CERT_NUM` (`CERT_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员银行卡表';



