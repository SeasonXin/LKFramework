<%@page import="com.lichkin.framework.springboot.utils.LKPropertiesUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.lichkin.framework.bases.statics.configs.LKSysConfigKeys"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="webjars" value="${ctx}/webjars" />
<c:set var="webjars_lichkin" value="${webjars}/lichkin-1.0.0" />
<c:set var="res" value="${ctx}/res" />
<c:set var="img" value="${res}/img" />
<c:set var="css" value="${res}/css" />
<c:set var="js" value="${res}/js" />
<c:set var="production" value="<%= LKPropertiesUtils.getProperty(LKSysConfigKeys.CONFIG_LK_SYSTEM_PRODUCTION, false) %>" />
<c:set var="webjarsCompress" value="<%= LKPropertiesUtils.getProperty("lichkin.framework.web.webjarsCompress", false) %>" />
<c:set var="requestSuffix" value="<%="?_$=" + new SimpleDateFormat(LKPropertiesUtils.getProperty("lichkin.framework.web.request.suffix.formatter", "yyyy_MM_dd_HH")).format(new Date())%>" />
<script type="text/javascript">
  var _CTX = '${ctx}', _WEBJARS = '${webjars}', _RES = '${res}', _IMG = '${img}', _CSS = '${css}', _JS = '${js}';
</script>
<script type="text/javascript">
  var LK_PRODUCTION = '${production}';
  var LK_REQUEST_CTX = '${requestDatas.lichkin_requestCtx}';
  var LK_REQUEST_URI = '${requestDatas.lichkin_requestURI}';
  var LK_REQUEST_URI_WITHOUT_CTX = '${requestDatas.lichkin_requestURIWithoutCtx}';
  var LK_REQUEST_URI_ROOT = '${requestDatas.lichkin_requestURIRoot}';
  var LK_REQUEST_URI_SUB = '${requestDatas.lichkin_requestURISub}';
  var LK_ONCLOSE_FUNC_NAME = '${requestDatas.lichkin_onCloseFuncName}';
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
