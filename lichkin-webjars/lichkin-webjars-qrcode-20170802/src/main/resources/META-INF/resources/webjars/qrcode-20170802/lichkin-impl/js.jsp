<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
  <c:when test="${webjarsCompress == true}">
    <script type="text/javascript" src="${qrcodeLichKin}/overwrite.min.js${requestSuffix}"></script>
    <script type="text/javascript" src="${qrcodeLichKin}/extends.min.js${requestSuffix}"></script>
  </c:when>
  <c:otherwise>
    <script type="text/javascript" src="${qrcodeLichKin}/overwrite.js${requestSuffix}"></script>
    <script type="text/javascript" src="${qrcodeLichKin}/extends.js${requestSuffix}"></script>
  </c:otherwise>
</c:choose>