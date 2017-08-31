<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webjars/includes/lichkin-web.jsp"%>
<!-- your codes in head tag start -->

<%@ include file="/webjars/lichkin-jquery.jsp"%>
<link href="${css}/lichkin/wechat/common.css${requestSuffix}" rel="stylesheet" type="text/css">
<link href="${css}/lichkin/wechat/config/menu.css${requestSuffix}" rel="stylesheet" type="text/css">

<!-- your codes in head tag end -->
<%@ include file="/webjars/includes/head-end.jsp"%>
<body>
  <!-- your codes in body tag start -->

  <div class="blankLine"></div>

  <div class="boxOut">
    <div class="boxIn" style="text-align: center;">
      <span class="label">微信菜单配置</span>
    </div>
  </div>

  <div class="blankLine"></div>

  <div class="boxOut" style="display: none;">
    <div class="boxIn">
      <form id="frm">
        <table style="width: 100%;">
          <tr>
            <td style="width: 30%;">名称</td>
            <td style="padding: 10px;">
              <input name="btnName" type="text" />
            </td>
          </tr>
          <tr>
            <td>类型</td>
            <td style="padding: 10px;">
              <select name="btnType" style="width: 100%;">
                <option value="">无</option>
                <option value="view">跳转页面类型</option>
                <option value="click">消息推送类型</option>
              </select>
              <input name="typeView" type="text" value="列表类型" readonly="readonly" style="display: none;" />
            </td>
          </tr>
        </table>
      </form>

      <div class="blankLine"></div>

      <div class="boxOut">
        <div class="boxIn">
          <div style="float: left; width: 40%;">
            <div class="btn" onclick="doSaveButton();">确&nbsp;&nbsp;&nbsp;定</div>
          </div>
          <div style="float: right; width: 40%;">
            <div class="btn" onclick="doDeleteButton();">取&nbsp;&nbsp;&nbsp;消</div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="lk-wechat-menu">
    <nav>
      <div>
        <ul style="bottom: 60px;">
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

  <div class="boxOut" style="position: fixed; bottom: 10px;">
    <div class="boxIn">
      <div style="float: left; width: 40%;">
        <div class="btn" onclick="doSaveMenu(false);">保&nbsp;&nbsp;&nbsp;存</div>
      </div>
      <div style="float: right; width: 40%;">
        <div class="btn" onclick="doSaveMenu(true);">发&nbsp;&nbsp;&nbsp;布</div>
      </div>
    </div>
  </div>

  <script src="${js}/lichkin/wechat/config/menu.js${requestSuffix}" type="text/javascript"></script>

  <!-- your codes in body tag end -->
</body>
<%@ include file="/webjars/includes/html-end.jsp"%>