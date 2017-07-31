package com.lichkin.framework.springboot.configurations.web;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.bases.vos.LKInvokeValueVo;

/**
 * LKInvokeValueVo处理，主要是将请求中的参数放入LKInvokeValueVo中，方便后续取值，以及将请求相关参数放入request中。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKInvokeValueVoHandlerMethodArgumentResolver extends LKDatasHandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(final MethodParameter parameter) {
		return LKInvokeValueVo.class.equals(parameter.getParameterType());
	}


	@Override
	public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
		final LKDatas datas = (LKDatas) super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
		return new LKInvokeValueVo(datas);
	}

}
