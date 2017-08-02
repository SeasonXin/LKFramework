<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="set.jsp"%>
<%@include file="css.jsp"%>
<c:choose>
  <c:when test="${webjarsCompress == true}">
    <script type="text/javascript" src="${jquery}/jquery-3.2.1.min.js"></script>
  </c:when>
  <c:otherwise>
    <script type="text/javascript" src="${jquery}/jquery-3.2.1.js"></script>
  </c:otherwise>
</c:choose>
<%@include file="js.jsp"%>