<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lichkin.framework.springboot.web.LKWebProperties"%>

<%
	response.sendRedirect(request.getContextPath() + LKWebProperties.LK_WEB_PAGE_INDEX_URL);
%>