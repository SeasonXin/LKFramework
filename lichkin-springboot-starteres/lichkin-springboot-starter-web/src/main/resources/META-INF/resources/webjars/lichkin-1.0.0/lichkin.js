;
/**
 * 常用方法汇总。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
(function() {
  // 定义内部实现
  var $LK = function() {

    /**
     * 控制台输出
     * @param params 参数。网页支持JSON、字符串、DOM等，客户端仅支持JSON、字符串。
     */
    this.log = function(params) {
      if (typeof LK_PRODUCTION == 'undefined' || LK_PRODUCTION == 'false') {
        if (window.WebViewJavascriptBridge) {
          if (typeof params == 'undefined') {
            params = 'params is undefined';
          }
          if (typeof params != 'string') {
            params = JSON.stringify(params);
          }
          window.WebViewJavascriptBridge.callHandler('log', params);
        } else {
          console.log(params);
        }
      }
    };

    /**
     * 弹出提示窗
     * @param params 参数。支持JSON、字符串。
     * @param params[msg] 输出信息，如果params为JSON，且此JSON中有msg的键，则输出此msg信息。
     * @param callback 回调函数，方法块或方法名。
     */
    this.alert = function(params, callback) {
      if (typeof params == 'undefined') {
        LK.log('params is undefined');
        return;
      }
      if (typeof params != 'string') {
        params = JSON.stringify(params);
      }
      if (typeof callback == 'string') {
        callback = window[callback];
      }
      if (window.WebViewJavascriptBridge) {
        window.WebViewJavascriptBridge.callHandler('alert', params, callback);
      } else {
        if (typeof params == 'undefined') {
          alert('undefined');
        } else if (typeof params == 'string') {
          alert(params);
        } else if (typeof params == 'object') {
          if (typeof params.msg != 'undefined') {
            alert(JSON.stringify(params.msg));
          } else {
            alert(JSON.stringify(params));
          }
        }
        if (typeof callback == 'function') {
          callback(params);
        }
      }
    };

    /**
     * 显示遮罩
     * @param params JSON参数。
     * @param params[info] 提示信息.
     * @param params[theme] 主题，目前只支持'default'默认。
     * @param params[timeout] 超时时间（毫秒）。不填/小于0：无超时；0：默认10秒；大于0，设定值。
     */
    this.showLoading = function(params) {
      if (typeof params == 'undefined') {
        params = {
          info : '加载中...',
          theme : 'default',
          timeout : -1
        };
      }
      if (window.WebViewJavascriptBridge) {
        window.WebViewJavascriptBridge.callHandler('showLoading', params);
      } else {
        params.info = (typeof params.info == 'undefined') ? '加载中...' : params.info;
        params.info = params.info ? params.info : '加载中...';

        params.theme = (typeof params.theme == 'undefined') ? 'default' : params.theme;

        if (params.theme == 'default') {
          var divLoadingMask = top.document.createElement('div');
          divLoadingMask.id = 'lk-loading-mask';
          divLoadingMask.style.width = top.document.body.scrollWidth + "px";
          divLoadingMask.style.height = top.document.body.scrollHeight + "px";
          top.document.body.appendChild(divLoadingMask);

          var imgLoading = top.document.createElement('img');
          imgLoading.id = 'lk-loading-img';
          imgLoading.style.left = (top.document.body.clientWidth - 50) / 2 + "px";
          imgLoading.style.top = (top.document.documentElement.clientHeight - 50) / 2 + "px";
          imgLoading.src = _IMG + '/loading.gif';
          top.document.body.appendChild(imgLoading);

          var divInfo = top.document.createElement('div');
          divInfo.id = 'lk-loading-info';
          divInfo.style.top = (top.document.documentElement.clientHeight + 50) / 2 + "px";
          divInfo.style.width = top.document.body.clientWidth + "px";
          divInfo.innerHTML = params.info;
          top.document.body.appendChild(divInfo);
        }

        // 超时时间后关闭遮罩
        params.timeout = (typeof params.timeout == 'undefined') ? -1 : params.timeout;
        if (typeof params.timeout != 'number') {
          params.timeout = parseInt(params.timeout);
        }
        if (params.timeout == 0) {
          params.timeout = 10000;
        }
        if (params.timeout > 0) {
          setTimeout(function() {
            LK.closeLoading();
          }, params.timeout);
        }

      }
    };

    /**
     * 关闭遮罩
     * @param params JSON参数。
     * @param params[theme] 主题，目前只支持'default'默认。
     * @param params[waitTime] 等待时间（毫秒）。不填/小于等于0：立即关闭；大于0，设定值。
     */
    this.closeLoading = function(params) {
      if (typeof params == 'undefined') {
        params = {
          theme : 'default',
          waitTime : 0
        };
      }
      if (window.WebViewJavascriptBridge) {
        window.WebViewJavascriptBridge.callHandler('closeLoading', params);
      } else {
        params.waitTime = (typeof params.waitTime == 'undefined') ? 0 : params.waitTime;
        params.waitTime = (params.waitTime < 0) ? 0 : params.waitTime;

        setTimeout(function() {
          var divLoading = top.document.getElementById('lk-loading-mask');
          if (divLoading) {
            top.document.body.removeChild(divLoading);
          }
          var imgLoading = top.document.getElementById('lk-loading-img');
          if (imgLoading) {
            top.document.body.removeChild(imgLoading);
          }
          var divInfo = top.document.getElementById('lk-loading-info');
          if (divInfo) {
            top.document.body.removeChild(divInfo);
          }
        }, params.waitTime);
      }
    };

    /**
     * 打开新窗口
     * @param params JSON参数。
     * @param params[theme] 主题，目前只支持'default'默认。
     * @param params[url] 新页面地址
     * @param params[onClose] 新页面关闭后调用方法块或方法名
     */
    this.openWin = function(params) {
      if (typeof params == 'undefined') {
        params = {
          theme : 'default',
          url : _CTX,
          onClose : function(callbackParams) {
            LK.log('onClose undefined');
          }
        };
      }
      if (typeof params == 'string') {
        params = {
          theme : 'default',
          url : params,
          onClose : function(callbackParams) {
            LK.log('onClose is undefined when openWin called.');
          }
        };
      } else {
        if (typeof params.onClose == 'undefined') {
          params.onClose = function(callbackParams) {
            LK.log('onClose is undefined when openWin called.');
          };
        }
      }
      if (typeof params.onClose == 'function') {
        params.onClose = LK.addFunc('_openWinOnClose', new Date().getTime(), params.onClose);
      }
      if (window.WebViewJavascriptBridge) {
        window.WebViewJavascriptBridge.callHandler('openWin', params);
      } else {
        window.open(LK.spliceUrl(params.url, {
          lichkin_onCloseFuncName : params.onClose
        }));
      }
    };

    /**
     * 关闭窗口
     * @param params JSON参数。
     * @param params[theme] 主题，目前只支持'default'默认。
     * @param params[callbackParams] 关闭页面时，调用openWin方法指定的onClose方法的回传参数。
     * @param params[refreshOpener] 是否刷新打开本页面的页面。
     */
    this.closeWin = function(params) {
      if (typeof params == 'undefined') {
        params = {
          theme : 'default',
          callbackParams : {},
          refreshOpener : false
        };
      }
      if (window.WebViewJavascriptBridge) {
        window.WebViewJavascriptBridge.callHandler('closeWin', params);
      } else {
        if (window.opener) {
          if (LK_ONCLOSE_FUNC_NAME && window.opener[LK_ONCLOSE_FUNC_NAME]) {
            window.opener[LK_ONCLOSE_FUNC_NAME](params.callbackParams);
          }
          if (params.refreshOpener) {
            window.opener.location.reload(false);
          }
        }
        window.opener = null;
        window.open('', '_self');
        window.close();
      }
    };

    /**
     * 拼接URL
     * @param url 地址
     * @param params 参数
     * @param noSuffix true：不加后缀；false：加后缀。
     */
    this.spliceUrl = function(url, params, noSuffix) {
      if (!url) {
        url = '';
      }
      if (!params) {
        params = {};
      }
      if (!noSuffix) {
        params['_$'] = new Date().getTime();
      }
      for ( var key in params) {
        if (url.indexOf('?') == -1) {
          url += '?';
        } else {
          url += '&';
        }
        url += key + '=' + params[key];
      }
      return url;
    };

    /**
     * 解析URL
     */
    this.resolveUrl = function(url, otherController, suffix) {
      // 参数初始化
      if (typeof otherController == 'undefined' || otherController == false || otherController == 'false') {
        otherController = false;
      } else {
        otherController = true;
      }

      if (typeof suffix == 'undefined') {
        suffix = '.do';
      }

      // URL前缀处理
      if (LK.startsWith(url, 'http')) {
        // 全路径请求，不做前缀处理。
      } else if (LK.startsWith(url, '/')) {
        // 相对路径请求。
        if (otherController) {
          // 请求其他控制器，则只拼接CTX路径。
          url = LK_REQUEST_CTX + url;
        } else {
          // 请求当前控制器，则拼接CTX路径及ROOT路径。
          url = LK_REQUEST_CTX + LK_REQUEST_URI_ROOT + url;
        }
      } else {
        // 相对路径请求。
        if (otherController) {
          // 请求其他控制器，则只拼接CTX路径。
          url = LK_REQUEST_CTX + '/' + url;
        } else {
          // 请求当前控制器，则拼接CTX路径及ROOT路径。
          url = LK_REQUEST_CTX + LK_REQUEST_URI_ROOT + '/' + url;
        }
      }

      // URL后缀处理
      if (!LK.endsWith(url, suffix)) {
        url += suffix;
      }
      url += '?_$=' + new Date().getTime();
      return url;
    };

    /**
     * 向window增加方法
     * @param prefix 方法前缀
     * @param suffix 方法后缀
     * @param func 方法内容
     */
    this.addFunc = function(prefix, suffix, func) {
      var funcName = (prefix ? prefix : '') + '_' + (suffix ? suffix : '');
      window[funcName] = func;
      return funcName;
    };

    /**
     * 判断字符串是否以前缀开始
     * @param str 字符串
     * @param prefix 前缀
     */
    this.startsWith = function(str, prefix) {
      return new RegExp('^' + prefix).test(str);
    };

    /**
     * 判断字符串是否包含子字符串
     * @param str 字符串
     * @param subStr 子字符串
     */
    this.contains = function(str, subStr) {
      return new RegExp(subStr).test(str);
    };

    /**
     * 判断字符串是否以后缀结尾
     * @param str 字符串
     * @param suffix 后缀
     */
    this.endsWith = function(str, suffix) {
      return new RegExp(suffix + '$').test(str);
    };

    /**
     * 判断对象是否为数组
     * @param obj 对象
     * @returns 是数组返回true，否则返回false。
     */
    this.isArray = function(obj) {
      if (obj instanceof Array || (!(obj instanceof Object) && (Object.prototype.toString.call((obj)) == '[object Array]') || typeof obj.length == 'number' && typeof obj.splice != 'undefined' && typeof obj.propertyIsEnumerable != 'undefined' && !obj.propertyIsEnumerable('splice'))) {
        return true;
      }
      return false;
    }

    /**
     * 调用方法
     * @param funcName 方法名
     * @param params 方法参数
     */
    this.callfunc = function(funcName, params) {
      if (typeof params.scope == 'undefined') {
        funcName(params);
      } else if (params.scope == 'top') {
        top.window[funcName](params);
      } else if (params.scope == 'parent') {
        parent.window[funcName](params);
      } else if (params.scope == 'tab') {
        top.mainTabs.tabs('getSelected').children('iframe')[0].contentWindow[funcName](params);
      } else {
        LK.alert({
          text : 'param error => LK.callfunc => params.scope'
        });
        return;
      }
    }

  };

  // 暴露给外部使用的对象
  LK = new $LK();
})();