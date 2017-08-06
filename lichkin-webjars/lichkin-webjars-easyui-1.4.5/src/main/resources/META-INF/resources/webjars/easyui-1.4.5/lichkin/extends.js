/**
 * 扩展脚本
 */

/**
 * 扩展验证
 */
$.extend($.fn.validatebox.defaults.rules, {
  cellphone : {
    validator : function(value, param) {
      if (!(/^1\d{10}$/.test(value))) {
        return false;
      }
      return true;
    },
    message : '手机号码不正确'
  },
  userCard : {
    validator : function(value, param) {
      if (!(/(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(value))) {
        return false;
      }
      return true;
    },
    message : '身份证号码不正确'
  }
});

/** 扩展对象 */
LK.easyui = new Object();

/**
 * 初始化表格控件
 * @param obj 对话框标识，参见LK.$.selector.getJQueryObj。
 * @param easyuiOptions 参见EasyUI.datagrid。
 * @param lkOptions 参见LK.easyui.datagrid。
 */
LK.easyui.datagrid = function(obj, easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof easyuiOptions == 'undefined') {
    easyuiOptions = {};
  }
  if (typeof lkOptions == 'undefined') {
    lkOptions = {};
  }

  lkOptions = $.extend({
    frmSearch : 'frmSearch'
  }, lkOptions);

  if (obj == null) {
    obj = $('#divDatagrid');
  } else {
    obj = LK.$.getJQueryObj(obj, lkOptions.scope);
  }

  // 参数赋值
  easyuiOptions = $.extend({
    idField : 'id',
    url : 'page',
    fit : true,
    fitColumns : true,
    rownumbers : true,
    loadMsg : '数据读取中。。。',
    striped : true,
    method : 'post',
    pagination : true,
    pageSize : 25,
    pageList : [
        10, 25, 50, 100, 200
    ],
    loadFilter : function(data) {
      var returnValue = {
        rows : [],
        total : 0
      };

      if (typeof data == 'undefined') {
        LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
      } else {
        if (typeof data.code != 'undefined' && (data.code == 0 || data.code == '0')) {// 业务成功
          if (typeof data.datas == 'undefined') {// 无数据
            LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
          } else {
            if (LK.isArray(data.datas)) {// 列表数据
              if (data.datas.length == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常列表数据
                return {
                  rows : data.datas,
                  total : data.datas.length
                };
              }
            } else if (data.datas.content) {// 分页数据
              if (data.datas.totalElements == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常分页数据
                return {
                  rows : data.datas.content,
                  total : data.datas.totalElements
                };
              }
            } else {
              LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
            }
          }
        } else {// 业务失败
          LK.easyui.messager.showError(data.info);
        }
      }

      return returnValue;
    },
    onBeforeLoad : function(params) {
      $.extend(params, LK.easyui.datagrid.getSearchParams(params, lkOptions));
    },
    iconCls : 'lk-icon-datagrid'
  }, easyuiOptions);

  if (typeof easyuiOptions.data == 'undefined') {
    easyuiOptions.url = LK.resolveUrl(easyuiOptions.url, lkOptions.otherController);
  } else {
    delete easyuiOptions.url;
  }

  // 初始化对象
  return obj.datagrid(easyuiOptions);
};

/**
 * 获取查询参数
 * @param params 参数
 * @param lkOptions 自定义参数
 */
LK.easyui.datagrid.getSearchParams = function(params, lkOptions) {
  return LK.$.form.getParams(LK.$.getJQueryObj(lkOptions.frmSearch, lkOptions.scope), params);
};

/**
 * 校验表格选择数据
 * @param datagrid 数据表格对象
 * @param operName 操作名
 * @param multiple 是否多选
 */
LK.easyui.datagrid.checkSelections = function(datagrid, operName, multiple) {
  var selections = datagrid.datagrid('getSelections');
  if (selections.length == 0) {
    LK.easyui.messager.alert({
      msg : '请选择一条数据信息进行“' + operName + '”操作',
      icon : 'warning'
    });
    return false;
  }

  if (typeof multiple != 'undefined' && multiple == true) {
    return selections;
  } else {
    if (selections.length != 1) {
      LK.easyui.messager.alert({
        msg : '只能选择一条数据信息进行“' + operName + '”操作',
        icon : 'warning'
      });
      return false;
    }
    return selections[0];
  }
};

/**
 * 删除行数据
 * @param datagrid 数据表格对象
 * @param id 数据ID字段值
 */
LK.easyui.datagrid.deleteRow = function(datagrid, id) {
  datagrid.datagrid('deleteRow', datagrid.datagrid('getRowIndex', id));
};

/**
 * 删除行数据格式化
 * @param value 字段值
 * @param row 行数据
 * @param index 索引值
 */
LK.easyui.datagrid.deleteRowFormatter = function(value, row, index) {
  return '<a href="javascript:;" style="color:red;font-weight:bold;" onclick="LK.easyui.datagrid.deleteRow($(\'#divDatagrid\'),\'' + row.id + '\');">删除</a>';
}

/**
 * 初始化对话框控件
 * @param obj 对话框标识，默认会在lkOptions.scope的body中创建一个分区。有值时根据参见LK.$.getJQueryObj。
 * @param easyuiOptions 参见EasyUI.dialog。
 * @param lkOptions 参见LK.easyui.dialog。
 */
LK.easyui.dialog = function(obj, easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof lkOptions == 'undefined' || lkOptions == null) {
    lkOptions = {};
  }
  if (typeof easyuiOptions == 'undefined' || easyuiOptions == null) {
    easyuiOptions = {};
  }
  if (typeof obj == 'undefined' || obj == null) {
    if (typeof lkOptions.scope == 'undefined') {
      obj = $('<div></div>').appendTo('body');
    } else if (lkOptions.scope == 'top') {
      obj = top.$('<div></div>').appendTo(top.$('body'));
    } else if (lkOptions.scope == 'parent') {
      obj = parent.$('<div></div>').appendTo(parent.$('body'));
    } else {
      LK.alert({
        text : 'param error => LK.easyui.dialog => lkOptions.scope'
      });
      return;
    }
  } else {
    obj = LK.$.getJQueryObj(obj, lkOptions.scope);
  }

  // 参数赋值
  easyuiOptions = $.extend({
    iconCls : '',
    title : '',
    closed : true,
    cache : false,
    modal : true,
    width : 750,
    height : 550,
    closable : true,
    collapsible : true,
    minimizable : false,
    maximizable : false,
    onClose : function() {
      obj.dialog('destroy');
    },
    onMinimize : function() {
      obj.dialog('destroy');
    }
  }, easyuiOptions);

  if (typeof easyuiOptions.href != 'undefined') {
    easyuiOptions.href = LK.resolveUrl(easyuiOptions.href, lkOptions.otherController, '.html');
  }

  // 初始化对象
  return obj.dialog(easyuiOptions).dialog('open');
};

/**
 * 关闭对话框控件
 * @param obj 对话框标识，参见LK.$.getJQueryObj。
 * @param lkOptions 参见LK.easyui.dialog.close。
 */
LK.easyui.dialog.close = function(obj, lkOptions) {
  // 初始化参数
  if (typeof lkOptions == 'undefined' || lkOptions == null) {
    lkOptions = {};
  }
  if (typeof obj == 'object') {
  } else if (typeof obj == 'string') {
    obj = LK.$.getJQueryObj(obj, lkOptions.scope);
  } else {
    LK.alert({
      text : 'param error => LK.easyui.dialog.close => obj'
    });
    return;
  }
  if (typeof obj == 'object' && obj.length == 1) {
    obj.dialog('close');
  } else {
    LK.alert({
      text : 'param error => LK.easyui.dialog.close => obj'
    });
  }
};

/**
 * 销毁对话框控件
 * @param obj 对话框标识，参见LK.$.getJQueryObj。
 * @param lkOptions 参见LK.easyui.dialog.destroy。
 */
LK.easyui.dialog.destroy = function(obj, lkOptions) {
  // 初始化参数
  if (typeof lkOptions == 'undefined' || lkOptions == null) {
    lkOptions = {};
  }
  if (typeof obj == 'object') {
  } else if (typeof obj == 'string') {
    obj = LK.$.getJQueryObj(obj, lkOptions.scope);
  } else {
    LK.alert({
      text : 'param error => LK.easyui.dialog.destroy => obj'
    });
    return;
  }
  if (typeof obj == 'object' && obj.length == 1) {
    obj.dialog('destroy');
  } else {
    LK.alert({
      text : 'param error => LK.easyui.dialog.destroy => obj'
    });
  }
};

/**
 * 打开上传文件对话框
 */
LK.easyui.dialog.openUpload = function(lkOptions) {
  // 初始化参数
  lkOptions = $.extend({
    moduleName : 'moduleName',
    frmId : 'dataForm',
    fileIdsId : 'fileIds',
    maxSize : -1
  }, lkOptions);

  // 创建对话框
  var dlg = LK.easyui.dialog(null, {
    collapsible : false,
    width : 460,
    height : 333,
    title : '上传附件',
    content : '<iframe src="' + _CTX + '/lichkin/ftp/main.html?moduleName=' + lkOptions.moduleName + '&fileIds=' + $(lkOptions.fileShowObj).parents('#' + lkOptions.frmId).find('#' + lkOptions.fileIdsId).val() + '&maxSize=' + lkOptions.maxSize + '" style="width:100%;height:100%;" />',
    buttons : [
        {
          text : '确定',
          iconCls : 'lk-icon-ok',
          handler : function() {
            var rowData = dlg.find('iframe')[0].contentWindow.dg.datagrid('getData');
            var fileIds = '';
            var fileNames = '';
            if (rowData.total > 0) {
              for (var idx = 0; idx < rowData.total; idx++) {
                if (idx > 0) {
                  fileIds += ',';
                  fileNames += ',';
                }
                fileIds += '\'' + rowData.rows[idx].id + '\'';
                fileNames += rowData.rows[idx].showName;
              }
            }
            $(lkOptions.fileShowObj).parents('#' + lkOptions.frmId).find('#' + lkOptions.fileIdsId).val(fileIds);
            $(lkOptions.fileShowObj).val(fileNames);
            LK.easyui.dialog.close(dlg);
          }
        }, {
          text : '取消',
          iconCls : 'lk-icon-cancel',
          handler : function() {
            LK.easyui.dialog.close(dlg);
          }
        }
    ]
  }, {
    scope : 'top'
  });
};

/**
 * 信息框
 */
LK.easyui.messager = new Object();

/**
 * 提示信息显示框
 * @param easyuiOptions 参见EasyUI.messager.show。
 */
LK.easyui.messager.show = function(easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof lkOptions == 'undefined' || lkOptions == null) {
    lkOptions = {};
  }
  if (typeof easyuiOptions == 'undefined' || easyuiOptions == null) {
    easyuiOptions = {};
  }
  easyuiOptions = $.extend({
    title : '提示',
    msg : '提示信息',
    showType : 'slide',
    style : {
      right : '',
      bottom : ''
    }
  }, easyuiOptions);

  if (typeof lkOptions.scope == 'undefined') {
    $.messager.show(easyuiOptions);
  } else if (lkOptions.scope == 'top') {
    top.$.messager.show(easyuiOptions);
  } else if (lkOptions.scope == 'parent') {
    parent.$.messager.show(easyuiOptions);
  } else {
    LK.alert({
      text : 'param error => LK.easyui.messager.show => lkOptions.scope'
    });
    return;
  }
};

/**
 * 显示异常提示窗
 */
LK.easyui.messager.showError = function(msg) {
  if (typeof msg == 'undefined') {
    msg = '服务器忙，请稍后再试！~';
  }
  LK.easyui.messager.show({
    msg : msg,
    timeout : 500,
    showType : 'fade'
  }, {
    scope : 'top'
  });
};

/**
 * 提示对话框
 * @param easyuiOptions 参见EasyUI.messager.alert。
 */
LK.easyui.messager.alert = function(easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof lkOptions == 'undefined' || lkOptions == null) {
    lkOptions = {};
  }
  if (typeof easyuiOptions == 'undefined' || easyuiOptions == null) {
    easyuiOptions = {};
  }
  easyuiOptions = $.extend({
    title : '提示',
    msg : '提示信息',
    icon : 'info'
  }, easyuiOptions);

  var callback = easyuiOptions.fn;
  easyuiOptions.fn = function() {
    if (callback) {
      callback(easyuiOptions, lkOptions);
    }
  };

  if (typeof lkOptions.scope == 'undefined') {
    $.messager.alert(easyuiOptions);
  } else if (lkOptions.scope == 'top') {
    top.$.messager.alert(easyuiOptions);
  } else if (lkOptions.scope == 'parent') {
    parent.$.messager.alert(easyuiOptions);
  } else {
    LK.alert({
      text : 'param error => LK.easyui.alert => lkOptions.scope'
    });
    return;
  }
};

/**
 * 初始化选择控件
 * @param obj 对话框标识，参见LK.$.selector.getJQueryObj。
 * @param easyuiOptions 参见EasyUI.combobox。
 * @param lkOptions 参见LK.easyui.combobox。
 */
LK.easyui.combobox = function(obj, easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof easyuiOptions == 'undefined') {
    easyuiOptions = {};
  }
  if (typeof lkOptions == 'undefined') {
    lkOptions = {};
  }
  obj = LK.$.getJQueryObj(obj, lkOptions.scope);

  // 参数赋值
  easyuiOptions = $.extend({
    height : 30,
    loadFilter : function(data) {
      var returnValue = [];

      if (typeof data == 'undefined') {
        LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
      } else {
        if (typeof data.code != 'undefined' && (data.code == 0 || data.code == '0')) {// 业务成功
          if (typeof data.datas == 'undefined') {// 无数据
            LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
          } else {
            if (LK.isArray(data.datas)) {// 列表数据
              if (data.datas.length == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常列表数据
                return data.datas;
              }
            } else if (data.datas.content) {// 分页数据
              if (data.datas.totalElements == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常分页数据
                return data.datas.content;
              }
            } else {
              LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
            }
          }
        } else {// 业务失败
          LK.easyui.messager.showError(data.info);
        }
      }

      return returnValue;
    }
  }, easyuiOptions);

  if (typeof easyuiOptions.url != 'undefined') {
    easyuiOptions.url = LK.resolveUrl(easyuiOptions.url, lkOptions.otherController);
  }

  // 初始化对象
  return obj.combobox(easyuiOptions);
};

/**
 * 初始化树形控件
 * @param obj 对话框标识，参见LK.$.selector.getJQueryObj。
 * @param easyuiOptions 参见EasyUI.tree。
 * @param lkOptions 参见LK.easyui.tree。
 */
LK.easyui.tree = function(obj, easyuiOptions, lkOptions) {
  // 初始化参数
  if (typeof easyuiOptions == 'undefined') {
    easyuiOptions = {};
  }
  if (typeof lkOptions == 'undefined') {
    lkOptions = {};
  }

  if (obj == null) {
    obj = $('#divTree');
  } else {
    obj = LK.$.getJQueryObj(obj, lkOptions.scope);
  }

  if (obj.hasClass('lk-form-filed-value-tree')) {// 表单中的树形控件，进行结构改造。
    var treeFieldDiv = top.$('<div class="form-filed-value-tree"></div>').appendTo(obj.parent());
    var divCheck = top.$('<div class="lk-form-filed-value-tree-checkbox"><span class="tree-checkbox tree-checkbox0"></span><span class="tree-title">全选/反选</span></div>').appendTo(treeFieldDiv);
    divCheck.click(function() {
      var checkbox = $(this).find('.tree-checkbox');
      if (checkbox.hasClass('tree-checkbox0')) {
        checkbox.removeClass('tree-checkbox0');
        checkbox.addClass('tree-checkbox1');
        LK.easyui.tree.toggleCheckAll(obj, true);
      } else {
        checkbox.removeClass('tree-checkbox1');
        checkbox.addClass('tree-checkbox0');
        LK.easyui.tree.toggleCheckAll(obj, false);
      }
    });
    obj.removeClass('lk-form-filed-value-tree');
    obj.addClass('lk-form-filed-value-tree-tree');
    obj = obj.remove().appendTo(treeFieldDiv);
  }

  // 参数赋值
  easyuiOptions = $.extend({
    url : 'tree',
    animate : true,
    loadFilter : function(data) {
      var returnValue = [];

      if (typeof data == 'undefined') {
        LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
      } else {
        if (typeof data.code != 'undefined' && (data.code == 0 || data.code == '0')) {// 业务成功
          if (typeof data.datas == 'undefined') {// 无数据
            LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
          } else {
            if (LK.isArray(data.datas)) {// 列表数据
              if (data.datas.length == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常列表数据
                return data.datas;
              }
            } else if (data.datas.content) {// 分页数据
              if (data.datas.totalElements == 0) {// 无数据
                LK.easyui.messager.showError('没有满足条件的数据信息！~');
              } else {// 正常分页数据
                return data.datas.content;
              }
            } else {
              LK.easyui.messager.showError('系统没有返回可以解析的数据！~');
            }
          }
        } else {// 业务失败
          LK.easyui.messager.showError(data.info);
        }
      }

      return returnValue;
    }
  }, easyuiOptions);

  if (typeof easyuiOptions.onSelect == 'undefined' && easyuiOptions.checkbox) {
    easyuiOptions = $.extend({
      onLoadSuccess : function() {
        if (obj.parents('.lk-form-field-value').length > 0 && obj.parents('.lk-form-field-value').next('.lk-form-field-error-message').length == 0) {
          obj.parents('.lk-form-field-value').after('<div class="lk-form-field-error-message"></div>');
        }
        LK.easyui.tree.validate(obj);
      },
      onSelect : function(node) {
        if (node.checked) {
          obj.tree('uncheck', node.target);
        } else {
          obj.tree('check', node.target);
        }
      },
      onCheck : function() {
        LK.easyui.tree.validate(obj);
      }
    }, easyuiOptions);
  }

  if (typeof easyuiOptions.url != 'undefined') {
    easyuiOptions.url = LK.resolveUrl(easyuiOptions.url, lkOptions.otherController);
  }

  // 初始化对象
  return obj.tree(easyuiOptions);
};

/**
 * 全选/反选树形菜单
 */
LK.easyui.tree.toggleCheckAll = function(obj, toggleAllTree) {
  var check = (toggleAllTree == true) ? 'check' : 'uncheck';
  var roots = obj.tree('getRoots');
  for (var idx = 0; idx < roots.length; idx++) {
    obj.tree(check, obj.tree('find', roots[idx].id).target);
  }
}

/**
 * 树形控件校验
 */
LK.easyui.tree.validate = function(obj) {
  if (obj.tree('getChecked').length == 0) {
    obj.parent().addClass('lk-form-filed-value-tree-invalid');
    obj.parents('.lk-form-field-value').next('.lk-form-field-error-message').html($.fn['validatebox'].defaults.missingMessage);
    return false;
  } else {
    obj.parent().removeClass('lk-form-filed-value-tree-invalid');
    obj.parents('.lk-form-field-value').next('.lk-form-field-error-message').html('');
    return true;
  }
};