/**
 * 重写脚本
 */

/**
 * @Override 弹出提示窗
 */
LK.alert = function(params, callback) {
  if (typeof params == 'string') {
    params = {
      msg : params
    };
  }
  LK.easyui.messager.alert($.extend(params, {
    fn : callback
  }), params);
};

/**
 * @Override AJAX请求成功默认处理方法
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
 * 
 * @param lkOptions[showSuccess_type] 成功提示对话框显示类型，默认值'alert'，可选值'toast'、'alert'。
 * @param lkOptions[showSuccess_reloadDatagrids] 成功后刷新表格列表。
 * @param lkOptions[showSuccess_closeDialogs] 成功后关闭对话框列表。
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
    if (callbackOptions.showSuccess_reloadDatagrids) {
      for (var idx = 0; idx < callbackOptions.showSuccess_reloadDatagrids.length; idx++) {
        callbackOptions.showSuccess_reloadDatagrids[idx].datagrid('reload');
      }
    }
    if (callbackOptions.showSuccess_closeDialogs) {
      for (var idx = 0; idx < callbackOptions.showSuccess_closeDialogs.length; idx++) {
        callbackOptions.showSuccess_closeDialogs[idx].dialog('close');
      }
    }
  };
  if (lkOptions.showSuccess == true) {
    if (typeof lkOptions.showSuccess_type != 'undefined' && lkOptions.showSuccess_type == 'toast') {
      LK.easyui.messager.show({
        msg : lkOptions.msg,
        timeout : 1000
      }, lkOptions);
      callback(lkOptions);
    } else {
      LK.alert(lkOptions, callback);

    }
  } else {
    callback(lkOptions);
  }
};

/**
 * @Override 验证表单
 */
LK.$.form.validate = function(frm, lkOptions) {
  if (!frm.form('validate')) {
    return false;
  }

  var treeValidates = true;
  frm.find('.lk-form-filed-value-tree-tree').each(function(index, item) {
    if (!LK.easyui.tree.validate(LK.$.getJQueryObjByDom(this, lkOptions.scope))) {
      treeValidates = false;
    }
  });
  if (!treeValidates) {
    return false;
  }

  return true;
};

/**
 * @Override 获取表单参数
 */
LK.$.form.getParams = function(frm, params, lkOptions) {
  if (!params) {
    params = {};
  }

  if (frm) {
    frm.find('.lk-form-filed-value-tree-tree').each(function(index, item) {
      var obj = LK.$.getJQueryObjByDom(this, lkOptions.scope);
      var checks = obj.tree('getChecked', [
          'checked', 'indeterminate'
      ]);
      var values = new Array();
      for (var idx = 0; idx < checks.length; idx++) {
        values.push(checks[idx].id);
      }
      obj.parents('.form-filed-value-tree').prev('input[type=hidden]').val(values.join('#@#'));
    });

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
};

/**
 * @Override 获取表单参数
 */
LK.$.form.bind = function(frm, datas, lkOptions) {
  frm.form('load', datas);
  frm.find('.lk-form-filed-value-tree-tree').each(function(index, item) {
    var obj = LK.$.getJQueryObjByDom(this, lkOptions.scope);
    var ids = obj.parents('.form-filed-value-tree').prev('input[type=hidden]').val();
    if (ids) {
      var arr = ids.split('#@#');
      if (arr.length > 0) {
        for (var idx = 0; idx < arr.length; idx++) {
          var node = obj.tree('find', arr[idx]).target;
          if (obj.tree('isLeaf', node)) {
            obj.tree('check', node);
          }
        }
      }
    }
  });
};