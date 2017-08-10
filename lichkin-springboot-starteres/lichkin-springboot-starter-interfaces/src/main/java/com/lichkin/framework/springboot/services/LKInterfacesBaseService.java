package com.lichkin.framework.springboot.services;

import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;
import com.lichkin.framework.bases.vos.LKInvokeValueVo;
import com.lichkin.framework.springboot.entities.impl.SysInterfacesLoginEntity;
import com.lichkin.framework.springboot.entities.impl.SysInterfacesRequestLogEntity;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 接口框架验证服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public abstract class LKInterfacesBaseService extends LKDBService {

	/**
	 * 验证并获取请求参数
	 * @param invokeValue 调用值对象
	 * @param interfacesVersion 接口版本
	 * @param saveRequestLog 是否记录请求日志
	 * @return 请求参数
	 */
	@Transactional
	public LKDatas validate(final LKInvokeValueVo invokeValue, final String interfacesVersion, final boolean saveRequestLog) {
		final String callerName = invokeValue.getCallerName();
		final String password = invokeValue.getPassword();
		final LKDatas requestDatas = invokeValue.getRequestDatas();

		final LKSqlVo sql = new LKSqlVo("from SysInterfacesLoginEntity t where 1 = 1");
		sql.appendSql("and t.loginName = ?").addParam(callerName);
		sql.appendSql("and t.pwd = ?").addParam(password);
		sql.appendSql("and t.systemTag = ?").addParam($systemTag);
		sql.appendSql("and t.interfacesVersion = ?").addParam(interfacesVersion);

		final SysInterfacesLoginEntity entity = dao.findOneByHql(sql, SysInterfacesLoginEntity.class);
		if (entity == null) {
			throw new LKRuntimeException(LKErrorCodeEnum.PERMISSION_DENIED, "请求用户名或密码或接口版本不正确");
		}

		if (saveRequestLog) {
			final SysInterfacesRequestLogEntity log = new SysInterfacesRequestLogEntity();
			log.setCallerName(callerName);
			log.setPassword(password);
			log.setRequestDatas(LKJSONUtils.toJson(requestDatas.getMapWithOutFrameworkParams(), false, false));
			log.setRequestId(requestDatas.getRequestId());
			log.setRequestIp(requestDatas.getRequestIp());
			log.setRequestTime(requestDatas.getRequestTime());
			log.setRequestUrl(requestDatas.getRequestUrl());
			dao.save(log);
		}

		return requestDatas;
	}

}
