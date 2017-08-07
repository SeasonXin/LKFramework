;
/**
 * 微信网页端对象
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
(function() {
  // 定义内部实现
  var $LKWECHAT = function() {

    /**
     * 初始化
     * @param params 参数。JSON。
     * @param params[appId] 应用ID
     * @param params[timestamp] 时间戳
     * @param params[nonceStr] 临时变量
     * @param params[signature] 签名
     */
    this.init = function(json) {
      this.appId = json.appId;
      this.timestamp = json.timestamp;
      this.nonceStr = json.nonceStr;
      this.signature = json.signature;
    };

    /**
     * 调用微信配置
     * @param params 参数。JSON，参考微信文档。
     */
    this.config = function(json) {
      var configs = {
        debug : false,
        appId : this.appId,
        timestamp : this.timestamp,
        nonceStr : this.nonceStr,
        signature : this.signature
      };
      for ( var key in json) {
        configs[key] = json[key];
      }
      wx.config(configs);
    };

  };

  // 暴露给外部使用的对象
  LKWechat = new $LKWECHAT();
})();