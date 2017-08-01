ALTER TABLE T_SYS_MQ_LOG COMMENT='消息队列记录表';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN ID varchar(32) NOT NULL COMMENT '主键';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN HANDLE_FINISHED varchar(32) NOT NULL COMMENT '处理结束状态';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN HANDLE_ID varchar(32) NOT NULL COMMENT '处理ID';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN MSG_DETAIL longtext NOT NULL COMMENT '消息详情';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN MSG_ID varchar(100) NOT NULL COMMENT '消息ID';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN READ_TIME varchar(19) NOT NULL COMMENT '读取时间';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN TEXT_INFO longtext NOT NULL COMMENT '消息text信息';
ALTER TABLE T_SYS_MQ_LOG MODIFY COLUMN VALUE_INFO longtext NOT NULL COMMENT '消息value信息';

CREATE UNIQUE INDEX I_MQ_LOG__MSG_ID ON T_SYS_MQ_LOG (MSG_ID);
CREATE INDEX I_MQ_LOG__READ_TIME ON T_SYS_MQ_LOG (READ_TIME);



