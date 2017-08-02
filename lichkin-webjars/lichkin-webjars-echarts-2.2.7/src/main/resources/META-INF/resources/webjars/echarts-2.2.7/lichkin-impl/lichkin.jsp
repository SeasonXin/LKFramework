<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="echarts" value="${webjars}/echarts-2.2.7" />
<c:choose>
  <c:when test="${webjarsCompress == true}">
    <script type="text/javascript" src="${echarts}/build/dist/echarts.js"></script>
  </c:when>
  <c:otherwise>
    <script type="text/javascript" src="${echarts}/build/source/echarts.js"></script>
  </c:otherwise>
</c:choose>
<script type="text/javascript" src="${echarts}/lichkin-impl/extends.js${requestSuffix}"></script>
