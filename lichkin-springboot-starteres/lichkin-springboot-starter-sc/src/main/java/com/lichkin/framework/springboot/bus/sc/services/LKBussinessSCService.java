package com.lichkin.framework.springboot.bus.sc.services;

import static com.lichkin.framework.bases.enums.LKUsingStatusEnum.DEPRECATED;
import static com.lichkin.framework.bases.enums.LKUsingStatusEnum.USING;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.bases.db.vo.LKSqlVo;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.bases.enums.interfaces.LKPrototypeEnum;
import com.lichkin.framework.springboot.db.utils.LKEntityInitializer;
import com.lichkin.framework.springboot.services.LKDBService;
import com.lichkin.framework.springframework.entities.sys.sc.SysSecurityCodeEntity;
import com.lichkin.framework.utils.lang.LKRandomUtils;

/**
 * 验证码服务类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Service
public class LKBussinessSCService extends LKDBService {

	/**
	 * 生成验证码
	 * @param systemTag 系统标识
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param length 验证码长度
	 * @param timeout 超时时长（分钟）
	 * @return 验证码
	 */
	@Transactional
	public SysSecurityCodeEntity createSecurityCode(final String systemTag, final LKPrototypeEnum busType, final String cellphone, final int length, final int timeout) {
		// 获取已有验证码
		SysSecurityCodeEntity entity = findExist(systemTag, busType, cellphone, timeout);

		if (entity == null) {
			// 没有验证码则生成一个验证码
			final String nowStr = DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn());
			final String loginId = LKEntityInitializer.getLoginId();
			entity = new SysSecurityCodeEntity();

			entity.setDisableInject(true);
			entity.setUsingStatus(USING);
			entity.setInsertTime(nowStr);
			entity.setInsertSystemTag(systemTag);
			entity.setInsertLoginId(loginId);
			entity.setUpdateTime(nowStr);
			entity.setUpdateSystemTag(systemTag);
			entity.setUpdateLoginId(loginId);

			entity.setBusType(busType.toString());
			entity.setCellphone(cellphone);
			entity.setSecurityCode(LKRandomUtils.createNumber(((length > 10) || (length < 0)) ? 6 : length));
			dao.save(entity);
		}

		return entity;
	}


	/**
	 * 生成验证码
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param length 验证码长度
	 * @param timeout 超时时长（分钟）
	 * @return 验证码
	 */
	@Transactional
	public SysSecurityCodeEntity createSecurityCode(final LKPrototypeEnum busType, final String cellphone, final int length, final int timeout) {
		return createSecurityCode($systemTag, busType, cellphone, length, timeout);
	}


	/**
	 * 判断验证码是否正确
	 * @param systemTag 系统标识
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param securityCode 待验证的验证码
	 * @param timeout 超时时长（分钟）
	 * @return 正确返回true，否则返回false。
	 */
	@Transactional
	public boolean checkSecurityCode(final String systemTag, final LKPrototypeEnum busType, final String cellphone, final String securityCode, final int timeout) {
		// 获取已有验证码
		final SysSecurityCodeEntity entity = findExist(systemTag, busType, cellphone, timeout);

		if (entity == null) {
			return false;
		} else {
			if (!entity.getSecurityCode().equals(securityCode)) {
				return false;
			}
		}

		// 验证成功后改为删除状态
		entity.setDisableInject(true);
		entity.setUsingStatus(DEPRECATED);
		entity.setUpdateTime(DateTime.now().toString(LKDatePatternEnum.STANDARD.getNameEn()));
		entity.setUpdateSystemTag(systemTag);
		entity.setUpdateLoginId(LKEntityInitializer.getLoginId());
		dao.save(entity);

		return true;
	}


	/**
	 * 判断验证码是否正确
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param securityCode 待验证的验证码
	 * @param timeout 超时时长（分钟）
	 * @return 正确返回true，否则返回false。
	 */
	@Transactional
	public boolean checkSecurityCode(final LKPrototypeEnum busType, final String cellphone, final String securityCode, final int timeout) {
		return checkSecurityCode($systemTag, busType, cellphone, securityCode, timeout);
	}


	/**
	 * 获取已有验证码
	 * @param systemTag 系统标识
	 * @param busType 业务类型
	 * @param cellphone 手机号码
	 * @param timeout 超时时长（分钟）
	 * @return 验证码
	 */
	private SysSecurityCodeEntity findExist(final String systemTag, final LKPrototypeEnum busType, final String cellphone, final int timeout) {
		final LKSqlVo sql = new LKSqlVo("from SysSecurityCodeEntity t");
		sql.appendSql("where t.usingStatus = ?").addParam(USING);
		sql.appendSql("and t.systemTag = ?").addParam(systemTag);
		sql.appendSql("and t.busType = ?").addParam(busType);
		sql.appendSql("and t.cellphone = ?").addParam(cellphone);
		sql.appendSql("and t.insertTime > ?").addParam(DateTime.now().minusMinutes(timeout).toString(LKDatePatternEnum.STANDARD.getNameEn()));
		final SysSecurityCodeEntity entity = dao.findOneByHql(sql, SysSecurityCodeEntity.class);
		return entity;
	}

}
