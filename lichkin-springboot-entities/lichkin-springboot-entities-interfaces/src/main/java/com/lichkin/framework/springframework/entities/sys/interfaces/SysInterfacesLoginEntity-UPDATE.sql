ALTER TABLE T_SYS_INTERFACES_LOGIN COMMENT='接口请求权限表';
ALTER TABLE T_SYS_INTERFACES_LOGIN MODIFY COLUMN ID varchar(32) NOT NULL COMMENT '主键';
ALTER TABLE T_SYS_INTERFACES_LOGIN MODIFY COLUMN INTERFACES_VERSION varchar(32) NOT NULL COMMENT '接口版本号';
ALTER TABLE T_SYS_INTERFACES_LOGIN MODIFY COLUMN LOGIN_NAME varchar(32) NOT NULL COMMENT '接口请求用户名';
ALTER TABLE T_SYS_INTERFACES_LOGIN MODIFY COLUMN PWD varchar(32) NOT NULL COMMENT '接口请求密码';
ALTER TABLE T_SYS_INTERFACES_LOGIN MODIFY COLUMN SYSTEM_TAG varchar(50) NOT NULL COMMENT '系统标识';


