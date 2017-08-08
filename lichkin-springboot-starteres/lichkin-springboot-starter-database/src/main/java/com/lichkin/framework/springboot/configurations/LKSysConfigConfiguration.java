package com.lichkin.framework.springboot.configurations;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKUsingStatusEnum;
import com.lichkin.framework.bases.statics.configs.LKSysConfig;
import com.lichkin.framework.bases.statics.configs.LKSysConfigs;
import com.lichkin.framework.springboot.entities.impl.SysConfigEntity;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONUtils;

/**
 * 系统配置信息配置
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Component
public class LKSysConfigConfiguration extends LKDBService implements InitializingBean {

	/** 日志对象 */
	protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("load configs from T_SYS_CONFIG.");
		final List<SysConfigEntity> listConfig = dao.findListByHql(new LKSqlVo("from SysConfigEntity where usingStatus = ? and systemTag = ?").addParam(LKUsingStatusEnum.USING).addParam($systemTag), SysConfigEntity.class);
		if (CollectionUtils.isNotEmpty(listConfig)) {
			for (final SysConfigEntity config : listConfig) {
				LKSysConfigs.put(new LKSysConfig(config.getConfigKey(), config.getConfigValue()));
			}
		}
		logger.info("load configs finished." + LKJSONUtils.toJson(LKSysConfigs.map, false, false));
	}

}
