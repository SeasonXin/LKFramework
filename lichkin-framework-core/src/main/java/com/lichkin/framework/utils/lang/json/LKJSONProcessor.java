package com.lichkin.framework.utils.lang.json;

import java.util.Date;

import org.joda.time.DateTime;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.enums.LKDatePatternEnum;
import com.lichkin.framework.utils.lang.LKObjectUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JSON处理类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKJSONProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(final Object value, final JsonConfig jsonConfig) {
		return processValue(value);
	}


	@Override
	public Object processObjectValue(final String key, final Object value, final JsonConfig jsonConfig) {
		return processValue(value);
	}


	private Object processValue(final Object value) {
		if (LKStringUtils.isBlank(LKObjectUtils.toString(value, null))) {
			return null;
		}
		if (value instanceof LKDatas) {
			// TODO 转JSON
			return (value);
		}
		if (value instanceof Date) {
			return new DateTime(((Date) value).getTime()).toString(LKDatePatternEnum.STANDARD.getNameEn());
		}
		return value;
	}

}
