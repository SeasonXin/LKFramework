<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
  <c:when test="${webjarsCompress == true}">
    <link type="text/css" rel="stylesheet" href="${jqueryLichKin}/extends.min.css${requestSuffix}">
  </c:when>
  <c:otherwise>
    <link type="text/css" rel="stylesheet" href="${jqueryLichKin}/extends.css${requestSuffix}">
  </c:otherwise>
</c:choose>