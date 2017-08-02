/**
 * 扩展脚本
 */
LK.$ = new Object();

/**
 * AJAX请求
 * 
 * @param ajaxOptions AJAX请求参数，参见$.ajax。
 * 
 * @param lkOptions AJAX请求自定义参数。
 * 
 * @param lkOptions[showLoading] 显示加载效果，默认值true。
 * @param lkOptions[showLoading_info] 参见LK.showLoading，默认值''。
 * @param lkOptions[showLoading_timeout] 参见LK.showLoading，默认值-1。
 * @param lkOptions[showLoading_theme] 参见LK.showLoadin，默认值'default'。
 * 
 * @param lkOptions[closeLoading_waitTime] 参见LK.closeLoading，默认值0。
 * 
 * @param lkOptions[otherController] URL只拼接_CTX路径，默认值false。
 * 
 * @param lkOptions[showSuccess] 显示成功提示对话框，默认值false。
 * @param lkOptions[showSuccess_title] 成功提示对话框标题，默认值'提示'。
 * @param lkOptions[showSuccess_msg] 成功提示对话框内容，默认值'操作成功！~'。
 * @param lkOptions[showSuccess_icon] 成功提示对话框图标，默认值'info'。
 * @param lkOptions[showSuccess_callback] 成功提示对话框确认按钮回调方法，默认值function(lkOptions){}。
 * 
 * @param lkOptions[showError] 显示失败提示对话框，默认值true。
 * @param lkOptions[showError_title] 失败提示对话框标题，默认值'提示'。
 * @param lkOptions[showError_msg] 失败提示对话框内容，默认值$.ajax错误内容。
 * @param lkOptions[showError_icon] 失败提示对话框图标，默认值'warning'。
 * @param lkOptions[showError_callback] 失败提示对话框确认按钮回调方法，默认值function(lkOptions){}。
 */
LK.$.ajax = function(ajaxOptions, lkOptions) {
  LK.log('call LK.$.ajax');
  LK.log({
    ajaxOptions : ajaxOptions,
    lkOptions : lkOptions
  });

  // 初始化参数
  if (typeof lkOptions == 'undefined') {
    lkOptions = {};
  }

  if (typeof lkOptions.showLoading == 'undefined' || lkOptions.showLoading == true || lkOptions.showLoading == 'true') {
    lkOptions.showLoading = true;
  } else {
    lkOptions.showLoading = false;
  }

  if (typeof lkOptions.showLoading_info == 'undefined') {
    lkOptions.showLoading_info = '';
  }

  if (typeof lkOptions.showLoading_timeout == 'undefined') {
    lkOptions.showLoading_timeout = -1;
  }

  if (typeof lkOptions.showLoading_theme == 'undefined') {
    lkOptions.showLoading_theme = 'default';
  }

  if (typeof lkOptions.closeLoading_waitTime == 'undefined') {
    lkOptions.closeLoading_waitTime = 500;
  }

  if (typeof lkOptions.otherController == 'undefined' || lkOptions.otherController == false || lkOptions.otherController == 'false') {
    lkOptions.otherController = false;
  } else {
    lkOptions.otherController = true;
  }

  if (typeof lkOptions.showSuccess == 'undefined' || lkOptions.showSuccess == false || lkOptions.showSuccess == 'false') {
    lkOptions.showSuccess = false;
  } else {
    lkOptions.showSuccess = true;
  }

  if (typeof lkOptions.showError == 'undefined' || lkOptions.showError == true || lkOptions.showError == 'true') {
    lkOptions.showError = true;
  } else {
    lkOptions.showError = false;
  }

  // 增加遮罩
  if (lkOptions.showLoading) {
    LK.showLoading({
      info : lkOptions.showLoading_info,
      timeout : lkOptions.showLoading_timeout,
      theme : lkOptions.showLoading_theme
    });
  }

  // 基本属性赋值
  ajaxOptions = $.extend({
    dataType : 'json',
    type : 'POST'
  }, ajaxOptions);

  ajaxOptions.url = LK.resolveUrl(ajaxOptions.url, lkOptions.otherController);

  // 失败回调方法处理
  var error = ajaxOptions.error;
  ajaxOptions.error = function(requestObj, code, info, responseDatas, ajaxOptionsCallback, lkOptionsCallback) {
    ajaxOptionsCallback = (typeof ajaxOptionsCallback == 'undefined') ? ajaxOptions : ajaxOptionsCallback;
    lkOptionsCallback = (typeof lkOptionsCallback == 'undefined') ? lkOptions : lkOptionsCallback;
    // 关闭遮罩
    if (lkOptionsCallback.showLoading) {
      LK.closeLoading({
        waitTime : lkOptionsCallback.closeLoading_waitTime
      });
    }
    if (error) {
      // 回调自定义方法
      LK.log('callback error');
      LK.log({
        requestObj : requestObj,
        code : code,
        info : info,
        responseDatas : responseDatas,
        ajaxOptions : ajaxOptionsCallback,
        lkOptions : lkOptionsCallback
      });
      error(requestObj, code, info, responseDatas, ajaxOptionsCallback, lkOptionsCallback);
    } else {
      // 默认处理
      LK.log('callback LK.$.ajax_error');
      LK.log({
        requestObj : requestObj,
        code : code,
        info : info,
        responseDatas : responseDatas,
        ajaxOptions : ajaxOptionsCallback,
        lkOptions : lkOptionsCallback
      });
      LK.$.ajax_error(requestObj, code, info, responseDatas, ajaxOptionsCallback, lkOptionsCallback);
    }
  };

  // 成功回调方法处理
  var success = ajaxOptions.success;
  ajaxOptions.success = function(responseText) {
    // 关闭遮罩
    if (lkOptions.showLoading) {
      LK.closeLoading({
        waitTime : lkOptions.closeLoading_waitTime
      });
    }
    if (typeof responseText == 'object' && typeof responseText.code != 'undefined') {
      if (responseText.code == 0) {// 成功
        // 回调自定义方法
        if (success) {
          LK.log('callback success');
          LK.log({
            responseDatas : responseText.datas,
            ajaxOptions : ajaxOptions,
            lkOptions : lkOptions
          });
          success(responseText.datas, ajaxOptions, lkOptions);
        } else {
          // 默认处理
          LK.log('callback LK.$.ajax_success');
          LK.log({
            responseDatas : responseText.datas,
            ajaxOptions : ajaxOptions,
            lkOptions : lkOptions
          });
          LK.$.ajax_success(responseText.datas, ajaxOptions, lkOptions);
        }
      } else if (responseText.code > 0) {// 失败
        ajaxOptions.error(responseText, responseText.code, responseText.info, responseText.datas, ajaxOptions, lkOptions);
      } else {// 服务器异常
        // 默认处理
        LK.log('callback LK.$.ajax_serverError');
        LK.log({
          requestObj : responseText,
          code : responseText.code,
          info : responseText.info,
          ajaxOptions : ajaxOptions,
          lkOptions : lkOptions
        });
        LK.$.ajax_serverError(responseText, responseText.code, responseText.info, responseText.datas, ajaxOptions, lkOptions);
      }
    } else if (typeof responseText == 'string') {
      if (responseText == 'success') {
        // 回调自定义方法
        if (success) {
          LK.log('callback success');
          LK.log({
            responseDatas : null,
            ajaxOptions : ajaxOptions,
            lkOptions : lkOptions
          });
          success(null, ajaxOptions, lkOptions);
        } else {
          // 默认处理
          LK.log('callback LK.$.ajax_success');
          LK.log({
            responseDatas : null,
            ajaxOptions : ajaxOptions,
            lkOptions : lkOptions
          });
          LK.$.ajax_success(null, ajaxOptions, lkOptions);
        }
      } else if (responseText == 'error') {
        ajaxOptions.error(responseText, responseText, responseText, responseText, ajaxOptions, lkOptions);
      }
    }
  };

  LK.log('call $.ajax');
  LK.log({
    ajaxOptions : ajaxOptions,
    lkOptions : lkOptions
  });

  // 发送请求
  $.ajax(ajaxOptions);
};

/**
 * AJAX请求成功默认处理方法
 * 
 * @param responseDatas 响应数据
 * 
 * @param ajaxOptions AJAX请求参数
 * 
 * @param lkOptions AJAX请求自定义参数
 * 
 * @param lkOptions[showSuccess] 显示成功提示对话框，默认值false。
 * @param lkOptions[showSuccess_title] 成功提示对话框标题，默认值'提示'。
 * @param lkOptions[showSuccess_msg] 成功提示对话框内容，默认值'操作成功！~'。
 * @param lkOptions[showSuccess_icon] 成功提示对话框图标，默认值'info'。
 * @param lkOptions[showSuccess_callback] 成功提示对话框确认按钮回调方法，默认值function(lkOptions){}。
 */
LK.$.ajax_success = function(responseDatas, ajaxOptions, lkOptions) {
  lkOptions = $.extend(lkOptions, {
    title : (lkOptions.showSuccess_title) ? lkOptions.showSuccess_title : '提示',
    msg : (lkOptions.showSuccess_msg) ? lkOptions.showSuccess_msg : '操作成功！~',
    icon : (lkOptions.showSuccess_icon) ? lkOptions.showSuccess_icon : 'info',
    responseDatas : responseDatas
  });
  callback = (typeof lkOptions.showSuccess_callback == 'function') ? lkOptions.showSuccess_callback : function(callbackOptions) {
    LK.log('callback LK.$.ajax_success => showSuccess_callback');
    LK.log({
      callbackOptions : callbackOptions
    });
  };
  if (lkOptions.showSuccess == true) {
    LK.alert(lkOptions, callback);
  } else {
    callback(lkOptions);
  }
};

/**
 * AJAX请求失败默认处理方法
 * 
 * @param requestObj 请求对象
 * 
 * @param code 错误编码
 * 
 * @param info 错误提示
 * 
 * @param responseDatas 响应数据
 * 
 * @param ajaxOptions AJAX请求参数
 * 
 * @param lkOptions AJAX请求自定义参数
 * 
 * @param lkOptions[showError] 显示失败提示对话框，默认值true。
 * @param lkOptions[showError_title] 失败提示对话框标题，默认值'提示'。
 * @param lkOptions[showError_msg] 失败提示对话框内容，默认值$.ajax错误内容。
 * @param lkOptions[showError_icon] 失败提示对话框图标，默认值'warning'。
 * @param lkOptions[showError_callback] 失败提示对话框确认按钮回调方法，默认值function(lkOptions){}。
 */
LK.$.ajax_error = function(requestObj, code, info, responseDatas, ajaxOptions, lkOptions) {
  if (lkOptions.showError == true) {
    lkOptions = $.extend(lkOptions, {
      title : (lkOptions.showError_title) ? lkOptions.showError_title : '提示',
      msg : (lkOptions.showError_msg) ? lkOptions.showError_msg : (LK.contains(info, '=>')) ? info.split('=>')[1] : info,
      icon : (lkOptions.showError_icon) ? lkOptions.showError_icon : 'warning',
      responseDatas : responseDatas
    });
    LK.alert(lkOptions, (typeof lkOptions.showError_callback == 'function') ? lkOptions.showError_callback : function(callbackOptions) {
      LK.log('callback LK.$.ajax_success => alert callback');
      LK.log({
        callbackOptions : callbackOptions
      });
    });
  }
};

/**
 * AJAX请求服务器异常默认处理方法
 * 
 * @param requestObj 请求对象
 * 
 * @param code 错误编码
 * 
 * @param info 错误提示
 * 
 * @param responseDatas 响应数据
 * 
 * @param ajaxOptions AJAX请求参数
 * 
 * @param lkOptions AJAX请求自定义参数
 * 
 * @param lkOptions[showError] 显示失败提示对话框，默认值true。
 * @param lkOptions[showError_title] 失败提示对话框标题，默认值'提示'。
 * @param lkOptions[showError_msg] 失败提示对话框内容，默认值$.ajax错误内容。
 * @param lkOptions[showError_icon] 失败提示对话框图标，默认值'info'。
 * @param lkOptions[showError_callback] 失败提示对话框确认按钮回调方法，默认值function(lkOptions){}。
 */
LK.$.ajax_serverError = function(requestObj, code, info, ajaxOptions, lkOptions) {
  LK.$.ajax_error(requestObj, code, info, ajaxOptions, $.extend(lkOptions, {
    icon : (lkOptions.showError_icon) ? lkOptions.showError_icon : 'error'
  }));
};

/**
 * 表单工具类
 */
LK.$.form = {

  /**
   * 获取表单参数
   */
  getParams : function(frm, params) {
    if (!params) {
      params = {};
    }

    if (frm) {
      var frmParams = {};
      var arr = frm.serializeArray();
      if (arr && arr.length > 0) {
        for (var idx = 0; idx < arr.length; idx++) {
          if (typeof frmParams[arr[idx].name] != 'undefined') {
            frmParams[arr[idx].name] = frmParams[arr[idx].name] + '#@#' + arr[idx].value;
          } else {
            frmParams[arr[idx].name] = arr[idx].value;
          }
        }
      }
      return $.extend(frmParams, params);
    }
    return params;
  },

  /**
   * 绑定表单
   */
  bind : function(frm, params) {
  },

  /**
   * 验证表单
   */
  validate : function(frm) {
    return true;
  },

  /**
   * 创建form表单
   * @param obj from的外层容器
   * @param datas 数据
   * @returns form对象
   */
  createFormDom : function(obj, datas) {
    var frm = $('<form></form>').appendTo(obj);
    var fieldsDiv = $('<div class="lk-form-fields"></div>').appendTo(frm);
    for (var idx = 0; idx < datas.length; idx++) {
      if (typeof datas[idx].type == 'undefined') {
        var fieldDiv = $('<div class="lk-form-field"></div>').appendTo(fieldsDiv);
        var fieldKeyDiv = $('<div class="lk-form-field-key">' + datas[idx].key + '：</div>').appendTo(fieldDiv);
        var fieldValueDiv = $('<div class="lk-form-field-value"></div>').appendTo(fieldDiv);
        var fieldValueTextSpan = $('<span class="lk-form-field-value-text">').appendTo(fieldValueDiv);
        fieldValueTextSpan.html(datas[idx].value);
      } else {
        switch (datas[idx].type) {
          case 'img':
            var fieldDiv = $('<div class="lk-form-field lk-form-field-with-img"></div>').appendTo(fieldsDiv);
            var fieldKeyDiv = $('<div class="lk-form-field-key">' + datas[idx].key + '：</div>').appendTo(fieldDiv);
            var fieldValueDiv = $('<div class="lk-form-field-value"></div>').appendTo(fieldDiv);
            fieldValueDiv.append('<img src="' + datas[idx].value + '" style="' + ((typeof datas[idx].width == 'undefined') ? '' : ('width:' + datas[idx].width + ';')) + ((typeof datas[idx].height == 'undefined') ? '' : ('height:' + datas[idx].height + ';')) + '" />');
            break;
          default:
            break;
        }
      }
    }
    return frm;
  },

  /**
   * 上传
   * @param frm 表单
   * @param params 参数
   */
  upload : function(frm, params) {
    // 增加遮罩
    LK.showLoading();

    // 动态创建一个iframe
    var frameId = 'uploadFrame' + new Date().getTime();
    var iframeObj = $('<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute;top:-9999px;left:-9999px" src="javascript:false;"></iframe>').appendTo(window.top.document.body);

    // 动态设置form属性
    frm.attr({
      target : frameId
    });

    // 提交表单
    frm.submit();

    // 获取iframe内容
    iframeObj.load(function() {
      // 关闭遮罩
      LK.closeLoading();

      // 解析XML
      var iframe = window.top.document.getElementById(frameId);
      var xml = {
        responseText : iframe.contentWindow.document.body.innerText
      };

      // 解绑并移除iframe
      iframeObj.unbind();
      setTimeout(function() {
        iframeObj.remove();
      }, 100);

      var responseText = eval("data = " + xml.responseText);
      if (responseText.code == 0) {
        params.success(responseText.datas);
      } else {
        LK.alert(responseText.info);
      }
    });
  }

};

/**
 * 获取JQuery对象
 * @param selector 如果是JQuery对象直接返回，如果是字符串则认为是id或id选择器。
 * @param scope JQuery范围，默认为当前页面，设置为true或'top'将从取top中的JQuery进行选择。
 */
LK.$.getJQueryObj = function(selector, scope) {
  if (typeof selector == 'string') {
    if (LK.startsWith(selector, '#')) {
      if (typeof scope == 'undefined') {
        return $(selector);
      } else if (scope == 'top') {
        return top.$(selector);
      } else if (scope == 'parent') {
        return parent.$(selector);
      } else {
        LK.alert({
          text : 'param error => LK.$.getJQueryObj => scope'
        });
        return null;
      }
    } else {
      if (typeof scope == 'undefined') {
        return $('#' + selector);
      } else if (scope == 'top') {
        return top.$('#' + selector);
      } else if (scope == 'parent') {
        return parent.$('#' + selector);
      } else {
        LK.alert({
          text : 'param error => LK.$.getJQueryObj => scope'
        });
        return null;
      }
    }
  }
  return selector;
};

/**
 * 获取JQuery对象
 * @param dom DOM对象
 * @param scope JQuery范围，默认为当前页面，设置为true或'top'将从取top中的JQuery进行选择。
 */
LK.$.getJQueryObjByDom = function(dom, scope) {
  if (typeof scope == 'undefined') {
    return $(dom);
  } else if (scope == 'top') {
    return top.$(dom);
  } else if (scope == 'parent') {
    return parent.$(dom);
  } else {
    LK.alert({
      text : 'param error => LK.$.getJQueryObj => scope'
    });
    return null;
  }
};

/**
 * 创建JQuery对象
 * @param htmlStr HTML文本。
 * @param toObj 添加到的JQuery对象。
 * @param scope JQuery范围，默认为当前页面。可选值'top','parent'。
 */
LK.$.appendTo = function(htmlStr, toObj, scope) {
  if (typeof scope == 'undefined') {
    return $(htmlStr).appendTo(toObj);
  } else if (scope == 'top') {
    return top.$(htmlStr).appendTo(toObj);
  } else if (scope == 'parent') {
    return parent.$(htmlStr).appendTo(toObj);
  }
};
