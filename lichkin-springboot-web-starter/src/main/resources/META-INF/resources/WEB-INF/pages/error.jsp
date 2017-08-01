<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webjars/includes/lichkin-web.jsp"%>

<script>
  function onload() {
    var h = window.screen.height - 70;
    if (window.screen.height < window.screen.width) {
      h = h * 0.7;
    }
    document.getElementsByTagName('body')[0].style.height = h + "px";
    document.getElementById('divA').style.fontSize = h * 8 / 100 + "px";
    document.getElementById('divB').style.fontSize = h * 12 / 100 + "px";
  }
</script>

<%@ include file="/webjars/includes/head-end.jsp"%>

<body style="background-color: #67AEE6;" onload="onload();">
  <div style="width: 100%; height: 44.5%; text-align: center; background-color: #FFFFFF;">
    <img src="${img}/error/top.png" style="height: 80%;">
  </div>
  <div id="divA" style="width: 100%; height: 10%; margin-top: 5%; text-align: center; color: #FFFFFF;">哎呀</div>
  <div id="divB" style="width: 100%; height: 17.5%; margin-top: 5%; text-align: center; color: #FFFFFF;">出错啦</div>
  <div id="divC" style="width: 100%; height: 10%; margin-top: 5%; text-align: center; color: #FFFFFF;">
    <img src="${img}/error/btn.png" style="height: 80%;" onclick="javascript:window.location.href='${ctx}/index.jsp';">
  </div>
</body>

<%@ include file="/webjars/includes/html-end.jsp"%>