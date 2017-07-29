package com.lichkin.framework.http.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP地址类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public final class LKIpUtils {

	/**
	 * 获取IP地址
	 * @param request HttpServletRequest
	 * @return IP地址
	 */
	public static String getIp(final HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

		if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
			if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			final String[] ips = ip.split(",");
			for (final String ip2 : ips) {
				final String strIp = ip2;
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

}
