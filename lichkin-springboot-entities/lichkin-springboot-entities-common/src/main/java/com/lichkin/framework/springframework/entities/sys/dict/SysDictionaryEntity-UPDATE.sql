ALTER TABLE T_SYS_DICTIONARY COMMENT='字典表';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN ID varchar(32) NOT NULL COMMENT '主键';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN CATEGORY_CODE varchar(32) NOT NULL COMMENT '类目编号';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN DICT_CODE varchar(32) NOT NULL COMMENT '字典编号';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN DICT_VALUE varchar(200) NOT NULL COMMENT '字典值';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN DICT_NAME varchar(200) NOT NULL COMMENT '字典名称';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN USING_STATUS varchar(32) NOT NULL COMMENT '在用状态';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN ORDER_ID tinyint(4) NOT NULL COMMENT '排序号';
ALTER TABLE T_SYS_DICTIONARY MODIFY COLUMN REMARKS longtext COMMENT '备注';

CREATE INDEX I_DICTIONARY__CATEGORY_CODE ON T_SYS_DICTIONARY (CATEGORY_CODE);
CREATE INDEX I_DICTIONARY__DICT_CODE ON T_SYS_DICTIONARY (DICT_CODE);
CREATE INDEX I_DICTIONARY__DICT_NAME ON T_SYS_DICTIONARY (DICT_NAME);
CREATE INDEX I_DICTIONARY__USING_STATUS ON T_SYS_DICTIONARY (USING_STATUS);


