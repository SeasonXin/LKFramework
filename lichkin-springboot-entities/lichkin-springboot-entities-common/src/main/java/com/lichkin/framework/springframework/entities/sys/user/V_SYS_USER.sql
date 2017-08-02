create or replace view V_SYS_USER as
select
	u.BUS_ID,
	u.ID as USER_ID,
	u.CHECK_CODE as USER_CHECK_CODE,
	u.CELLPHONE,
	u.USER_NAME,
	u.USER_CARD,
	u.AUTHENTICATION,
	ul.ID as LOGIN_ID,
	ul.CHECK_CODE as LOGIN_CHECK_CODE,
	ul.LOGIN_NAME,
	ul.SYSTEM_TAG,
	u.INSERT_TIME,
	u.UPDATE_TIME
from
	t_sys_user u left join t_sys_user_login ul on
	ul.USER_ID = u.ID
where
	u.USING_STATUS = 'USING'
	and ul.USING_STATUS = 'USING'