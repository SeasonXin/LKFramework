<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lichkin.framework.springboot.applications.LKApplicationContext"%>
<%@ page import="com.lichkin.framework.wechat.statics.LKWechatConfigStatics"%>
<%@ page import="com.lichkin.framework.wechat.vo.Signature"%>
<%@ page import="com.lichkin.framework.springboot.services.impl.LKWechatJsTicketService"%>

<%@ include file="lichkin-web.jsp"%>

<%
	if (!LKWechatConfigStatics.debug) {
		Signature signature = LKApplicationContext.getBean(LKWechatJsTicketService.class).getSignature(request.getRequestURL().toString());
%>
<script src="<%= LKWechatConfigStatics.wechatJsUrl %>" type="text/javascript"></script>
<script type="text/javascript" src="${webjars_lichkin}/lichkin-wechat-1.0.0.js${requestSuffix}"></script>
<script type="text/javascript">
  LKWechat.init({
    appId: '<%=signature.getAppid()%>',
    timestamp: <%=signature.getTimestamp()%>,
    nonceStr: '<%=signature.getNonceStr()%>',
    signature: '<%=signature.getSignature()%>'
  });
</script>
<%
	}
%>
