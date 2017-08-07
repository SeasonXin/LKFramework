<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/webjars/includes/lichkin-web.jsp"%>
<%@include file="/webjars/jquery-1.11.3/lichkin.jsp"%>
<link href="${css}/lichkin/wechat/config/menu.css${requestSuffix}" rel="stylesheet" type="text/css">
<script src="${js}/lichkin/wechat/config/menu.js${requestSuffix}" type="text/javascript"></script>

<%@include file="/webjars/includes/head-end.jsp"%>

<body style="background-color: #FFEEEE;">
  <div style="margin-top: 5%; text-align: center; display: none;">
    <form id="frm">
      <table>
        <tr>
          <td>名称</td>
          <td>
            <input name="btnName" type="text" />
          </td>
        </tr>
        <tr>
          <td>类型</td>
          <td>
            <select name="btnType">
              <option value="">无</option>
              <option value="view">跳转页面类型</option>
              <option value="click">消息推送类型</option>
            </select>
            <input name="typeView" type="text" value="列表类型" readonly="readonly" style="display: none;" />
          </td>
        </tr>
      </table>
    </form>
    <div class="lk-btn-bar">
      <a href="javascript:;" class="lk-btn lk-btn-green" onclick="doSaveButton();">保存</a>
      <a href="javascript:;" class="lk-btn lk-btn-red" onclick="doDeleteButton();">删除</a>
    </div>
  </div>
  <div class="lk-wechat-menu">
    <nav>
      <div>
        <ul style="bottom: 33px;">
          <c:forEach var="arr" varStatus="x" items="${tdArray}">
            <li>
              <div onclick="showDetail(${x.index},0);">
                <span id="menu${x.index}0" title="btn${x.count}1" class="${arr[0].type}" data-type="${arr[0].type}">&nbsp;${arr[0].name}&nbsp;</span>
              </div>
              <dl>
                <c:forEach var="btn" varStatus="y" items="${arr}" begin="1">
                  <dd onclick="showDetail(${x.index},${y.index});" class="${btn.type}">
                    <span id="menu${x.index}${y.index}" title="btn${x.count}${y.index}" data-type="${btn.type}">&nbsp;${btn.name}&nbsp;</span>
                  </dd>
                </c:forEach>
              </dl>
            </li>
          </c:forEach>
        </ul>
      </div>
    </nav>
  </div>
  <div class="lk-btn-bar" style="position: fixed; bottom: 0px;">
    <a href="javascript:;" class="lk-btn lk-btn-green" onclick="doSaveMenu(false);">保存</a>
    <a href="javascript:;" class="lk-btn lk-btn-red" onclick="doSaveMenu(true);">发布</a>
  </div>
</body>

<%@include file="/webjars/includes/html-end.jsp"%>