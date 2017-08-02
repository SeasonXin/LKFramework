<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lichkin.framework.springboot.utils.LKPropertiesUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="lichkin.jsp"%>
<link href="${img}/favicon.ico" type="image/x-icon" rel="shortcut icon">

<c:choose>
  <c:when test="${webjarsCompress == true}">
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-app.min.css${requestSuffix}">
    <script type="text/javascript" src="${webjars_lichkin}/lichkin.min.js${requestSuffix}"></script>
  </c:when>
  <c:otherwise>
    <link rel="stylesheet" type="text/css" href="${webjars_lichkin}/lichkin-app.css${requestSuffix}">
    <script type="text/javascript" src="${webjars_lichkin}/lichkin.js${requestSuffix}"></script>
  </c:otherwise>
</c:choose>

<c:choose>
  <c:when test="${requestDatas.inApp != false}">
    <script type="text/javascript">
        // 使用WebViewJavascriptBridge时，需先监听事件初始化。
        document.addEventListener('WebViewJavascriptBridgeReady', function onBridgeReady(event) {
          event.bridge.init();
        }, false);
    </script>
  </c:when>
</c:choose>