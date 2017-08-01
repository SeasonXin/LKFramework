package com.lichkin.framework.springboot.web.http.request;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lichkin.framework.bases.LKDatas;
import com.lichkin.framework.http.request.LKRequestExtractor;
import com.lichkin.framework.utils.lang.LKStringUtils;

/**
 * 请求参数提取工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRequestExtractorOnSpring extends LKRequestExtractor {

	/**
	 * 获取请求对象
	 * @return 请求对象
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}


	/**
	 * 获取回调方法
	 * @return 回调方法
	 */
	public static String getCallbackFun() {
		return LKStringUtils.toString(LKRequestExtractorOnSpring.getRequest().getParameter("callback"), "");
	}


	/**
	 * 获取请求中的参数集合
	 * @param request HttpServletRequest
	 * @return 参数集合
	 */
	public static LKDatas getRequestParamsFromFile(final HttpServletRequest request) {
		final LKDatas datas = new LKDatas();
		try {
			final MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
			for (final Iterator<String> iterator = mRequest.getFileNames(); iterator.hasNext();) {
				final String fileName = iterator.next();
				datas.put(fileName, mRequest.getFile(fileName));
			}
		} catch (final Exception e) {
		}
		return datas;
	}


	/**
	 * 获取请求中的参数集合
	 * @param request HttpServletRequest
	 * @return 参数集合
	 * @throws IOException 读取输入流时可能抛出异常
	 */
	public static LKDatas getRequestParamsFromAll(final HttpServletRequest request) throws IOException {
		final LKDatas datas = LKRequestExtractor.getRequestParamsFromAll(request);

		final LKDatas datasFile = LKRequestExtractorOnSpring.getRequestParamsFromFile(request);
		final Set<Entry<String, Object>> datasFileEntrySet = datasFile.getMap().entrySet();
		for (final Entry<String, Object> entry : datasFileEntrySet) {
			datas.put(entry.getKey(), entry.getValue());
		}

		return datas;
	}

}
