<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lichkin.framework.springboot.utils.LKPropertiesUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="lichkin.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="${img}/favicon.ico" type="image/x-icon" rel="shortcut icon">
<c:choose>
  <c:when test="${webjarsCompress == true}">
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-icons.min.css${requestSuffix}">
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-web.min.css${requestSuffix}">
    <script type="text/javascript" src="${webjars_lichkin}/lichkin.min.js${requestSuffix}"></script>
  </c:when>
  <c:otherwise>
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-icons.css${requestSuffix}">
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-web.css${requestSuffix}">
    <script type="text/javascript" src="${webjars_lichkin}/lichkin.js${requestSuffix}"></script>
  </c:otherwise>
</c:choose>