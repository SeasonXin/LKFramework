CREATE OR REPLACE VIEW V_SYS_USER_CAR AS
select
	car.ID,
	car.BRAND_ID,
	car.DEFAULT_CAR,
	car.ENGINE_NUMBER,
	car.FRAME_NUMBER,
	car.LICENSE_PLATE_HEADER,
	car.LICENSE_PLATE_NUMBER,
	car.MODEL_ID,
	car.SERISE_ID,
	car.USER_ID,
	m.BRAND_NAME,
	m.SERISE_NAME,
	m.MODEL_NAME,
	m.DISPLACEMENT,
	m.GUIDE_PRICE,
	m.PRODUCTION_STATE,
	m.PRODUCTION_WAY,
	m.SALE_VERSION,
	m.SALE_YEAR,
	u.USER_NAME,
	u.BUS_ID
from
	t_sys_user_car car,
	t_sys_car_model m,
	v_sys_user u
where
	car.MODEL_ID = m.ID
	and car.USER_ID = u.USER_ID
	and m.USING_STATUS = 'USING'
	and car.USING_STATUS = 'USING'
