package com.lichkin.framework.springboot.configurations.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lichkin.framework.bases.enums.LKReturnValueShowTypeEnum;
import com.lichkin.framework.bases.vos.LKReturnValueVo;

/**
 * JSON请求响应的信息处理
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {

	@Override
	protected boolean supports(final Class<?> clazz) {
		return true;
	}


	@Override
	protected void writeInternal(final Object obj, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		if ((obj instanceof String) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Boolean)) {
			// 基本类型及String类型直接返回
			super.writeInternal(obj, outputMessage);
		} else if (obj instanceof LKReturnValueVo) {
			final LKReturnValueShowTypeEnum showType = ((LKReturnValueVo) obj).obtainShowType();
			final int code = ((LKReturnValueVo) obj).getCode();

			switch (showType) {
				case CODE_ONLY:// 只显示包含code的json
					final Map<String, Integer> codeJson = new HashMap<>();
					codeJson.put("code", code);
					super.writeInternal(codeJson, outputMessage);
				break;
				case CODE_VALUE:// 只显示code的值
					super.writeInternal(code, outputMessage);
				break;
				case STANDARD:// 标准显示
					super.writeInternal(obj, outputMessage);
				default:
				break;
			}
		} else {
			// AJAX请求，将返回值转换为标准返回值类型。
			super.writeInternal(new LKReturnValueVo(obj), outputMessage);
		}
	}

}
