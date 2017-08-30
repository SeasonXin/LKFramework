/**
 * 空值验证
 */
LK.checkNull = function(value) {
  if (value) {
    return true;
  }
  return false;
};

/**
 * 手机号码验证
 */
LK.checkCellphone = function(value) {
  return /^1[3-8]\d{9}$/.test(value);
};

/**
 * 验证码验证
 */
LK.checkSecurityCode = function(value) {
  return /^[a-zA-z0-9]{6}$/.test(value);
};

/**
 * 姓名验证
 */
LK.checkUserName = function(value) {
  return /^[\u4e00-\u9fa5]{2,30}$/.test(value);
};

/**
 * 密码验证
 */
LK.checkPwd = function(value) {
  return /^\w{6,10}$/.test(value);
};

/**
 * 登录名验证
 */
LK.checkLoginName = function(value) {
  return /^[a-zA-z0-9]{15}$/.test(value);
};

/**
 * 邮箱验证
 */
LK.checkEmail = function(value) {
  return /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(value);
};

/**
 * 日期验证
 */
LK.checkDate = function(value) {
  return /^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/.test(value);
};

/**
 * 验证提醒内容
 */
LK.checkRemindMsg = function(value) {
  return /^[\u4e00-\u9fa5_a-zA-Z0-9,，.。]{10,50}$/.test(value);
};
