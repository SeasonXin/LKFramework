<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lichkin.framework.springboot.applications.LKApplicationContext"%>
<%@ page import="com.lichkin.framework.wechat.vo.Signature"%>
<%@ page import="com.lichkin.framework.wechat.service.LKWechatJsTicketService"%>
<%@ page import="com.lichkin.framework.wechat.LKWechatProperties"%>

<%@ include file="lichkin-web.jsp"%>

<%
	if (!LKWechatProperties.WECHAT_DEBUG) {
		Signature signature = LKApplicationContext.getBean(LKWechatJsTicketService.class).getSignature(request.getRequestURL().toString());
%>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>
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
