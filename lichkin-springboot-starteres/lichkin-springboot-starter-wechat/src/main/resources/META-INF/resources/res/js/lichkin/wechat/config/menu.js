var frm;// form对象
var btnName;// 表单中btnName对象
var btnType;// 表单中btnType对象
var typeView;// 表单中typeView对象
var currentBtn;// 当前操作的按钮对象
var currentX;// 当前操作的X坐标
var currentY;// 当前操作的Y坐标

$(function() {
  // 初始化表单相关对象
  frm = $('#frm');
  btnName = frm.find('[name=btnName]');
  btnType = frm.find('[name=btnType]');
  typeView = frm.find('[name=typeView]');
});

/**
 * 增加focus样式
 */
function addFocus() {
  if (currentBtn) {
    if (currentY == 0) {// 一级菜单
      currentBtn.addClass('focus');
    } else {// 二级菜单
      currentBtn.parent().addClass('focus');
    }
  }
}

/**
 * 更新当前操作按钮对象
 * @param btn 按钮对象
 * @param x X坐标
 * @param y Y坐标
 */
function updateCurrent(btn, x, y) {
  currentBtn = btn;
  currentX = x;
  currentY = y;
}

/**
 * 验证当前按钮是否可以进行相应的编辑
 */
function validateCurrentBtn() {
  if (currentBtn) {
    if (currentY == 0) {// 一级菜单
      if (currentX != 0) {// 非第一个一级菜单，需要验证是否设置了前一个一级菜单。
        var pre = $('#menu' + (currentX - 1) + 0);
        if (pre.html() == '&nbsp;&nbsp;') {
          alert('没有设置前一个一级菜单');
          // 当前操作对象修改为前一个一级菜单，并增加focus样式。
          updateCurrent(pre, currentX - 1, 0);
          addFocus();
          return false;
        }
      }
    } else {// 二级菜单
      if (currentY != 1) {// 非第一个二级菜单，需要验证是否设置了前一个二级菜单。
        var pre = $('#menu' + currentX + (currentY - 1));
        if (pre.html() == '&nbsp;&nbsp;') {
          alert('没有设置前一个二级菜单');
          // 当前操作对象修改为前一个二级菜单，并增加focus样式。
          updateCurrent(pre, currentX, currentY - 1);
          addFocus();
          return false;
        }
      } else {// 第一个二级菜单，需要验证是否设置了一级菜单。
        var parent = $('#menu' + currentX + 0);
        if (parent.html() == '&nbsp;&nbsp;') {
          alert('没有设置一级菜单');
          // 当前操作对象修改为一级菜单，并增加focus样式。
          updateCurrent(parent, currentX, 0);
          addFocus();
          return false;
        }
      }
    }
  }
  return true;
}

/**
 * 显示详情
 * @param x X坐标
 * @param y Y坐标
 */
function showDetail(x, y) {
  // 清除focus样式
  if (currentBtn) {
    if (currentY == 0) {// 一级菜单
      currentBtn.removeClass('focus');
    } else {// 二级菜单
      currentBtn.parent().removeClass('focus');
    }
  }

  // 还原默认显示
  btnType.show();
  typeView.hide();

  // 更新当前操作按钮对象
  updateCurrent($("#menu" + x + y), x, y);

  // 隐藏表单
  frm.parent().hide();

  // 验证当前按钮是否可以进行相应的编辑
  if (!validateCurrentBtn()) {
    return;
  }

  // 增加focus样式
  addFocus();

  // 修改表单内容
  btnName.val(currentBtn.html().replace(new RegExp(/(&nbsp;)/g), ''));
  btnType.val(currentBtn.data('type'));
  if (currentY == 0) {// 一级菜单中如果设置了二级菜单，则类型不能进行修改。
    var sub = $('#menu' + currentX + 1);
    if (sub.html() != '&nbsp;&nbsp;') {
      btnType.hide();
      typeView.show();
    }
  }

  // 显示表单对象
  frm.parent().show();
}

/**
 * 保存按钮
 */
function doSaveButton() {
  // 参数验证
  if (!btnName.val()) {
    alert('没有输入名称。');
    return;
  }
  if (!btnType.val()) {
    alert('没有选择类型。');
    return;
  }

  // 修改样式
  if (currentY == 0) {// 一级菜单
    currentBtn.removeClass();
    currentBtn.addClass(btnType.val());
  } else {// 二级菜单
    currentBtn.parent().removeClass();
    currentBtn.parent().addClass(btnType.val());
    // 将一级菜单强制修改为view类型
    var parent = $('#menu' + currentX + 0);
    if (parent.data('type') != 'view') {
      parent.removeClass();
      parent.addClass('view');
      parent.data('type', 'view');
    }
  }

  // 修改值
  currentBtn.html('&nbsp;' + btnName.val() + '&nbsp;');
  currentBtn.data('type', btnType.val());

  // 隐藏表单
  frm.parent().hide();
}

/**
 * 删除按钮
 */
function doDeleteButton() {
  // 隐藏表单
  frm.parent().hide();

  // 参数验证
  if (currentY == 0) {// 一级菜单
    // 修改样式
    currentBtn.removeClass('focus');
    if (currentX != 2) {// 非最后一个一级菜单
      // 一级菜单如果设置了后续一级菜单，则不能进行删除。
      var next = $('#menu' + (currentX + 1) + currentY);
      if (next.html() != '&nbsp;&nbsp;') {
        alert('存在后续一级菜单');
        // 当前操作对象修改为后续一级菜单，并增加focus样式。
        updateCurrent(next, currentX + 1, currentY);
        addFocus();
        return;
      }
    }
    // 一级菜单中如果设置了二级菜单，则不能进行删除。
    var sub = $('#menu' + currentX + 1);
    if (sub.html() != '&nbsp;&nbsp;') {
      alert('存在二级菜单');
      // 当前操作对象修改为二级菜单，并增加focus样式。
      updateCurrent(sub, currentX, 1);
      addFocus();
      return;
    }
    // 修改样式
    currentBtn.removeClass();
  } else {// 二级菜单
    // 修改样式
    currentBtn.parent().removeClass('focus');
    if (currentY != 5) {// 非最后一个二级菜单
      // 二级菜单如果设置了后续二级菜单，则不能进行删除。
      var next = $('#menu' + currentX + (currentY + 1));
      if (next.html() != '&nbsp;&nbsp;') {
        alert('存在后续二级菜单');
        // 当前操作对象修改为后续二级菜单，并增加focus样式。
        updateCurrent(next, currentX, currentY + 1);
        addFocus();
        return;
      }
    }
    // 修改样式
    currentBtn.parent().removeClass();
  }

  // 修改值
  currentBtn.html('&nbsp;&nbsp;');
  currentBtn.data('type', '');
}

/**
 * 保存菜单
 * @param falg true：发布菜单；false：保存菜单。
 */
function doSaveMenu(flag) {
  var menuDatas = new Array();
  for (var x = 0; x < 3; x++) {
    var menuX = new Array();
    for (var y = 0; y <= 5; y++) {
      var menuXY = new Object();
      var obj = $('#menu' + x + y);
      var name = obj.html();
      if (name == '&nbsp;&nbsp;') {
        menuX[y] = null;
      } else {
        menuXY.btnName = name.replace(new RegExp(/(&nbsp;)/g), '');
        menuXY.btnType = obj.data('type');
        menuX[y] = menuXY;
      }
    }
    menuDatas[x] = menuX;
  }
  LK.$.ajax({
    url : '/config/saveMenu',
    data : {
      flag : flag,
      menuDatas : JSON.stringify(menuDatas)
    }
  });
}
