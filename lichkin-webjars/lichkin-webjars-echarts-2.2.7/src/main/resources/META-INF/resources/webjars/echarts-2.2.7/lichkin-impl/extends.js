/**
 * 扩展脚本
 */
LK.ECharts = new Object();

/**
 * 生成二维码
 * 
 * @param echartsOptions QRCode参数。
 * 
 * @param lkOptions QRCode自定义参数。
 */
LK.ECharts.line = function(echartsOptions, lkOptions) {
  LK.log('call LK.ECharts.line');
  LK.log({
    echartsOptions : echartsOptions,
    lkOptions : lkOptions
  });

  // 初始化参数
  var defaultTooltip = {
    trigger : 'axis'
  };
  var defaultToolbox = {
    show : true,
    feature : {
      magicType : {
        show : true,
        type : [
            'line', 'bar'
        ]
      },
      restore : {
        show : true
      },
      saveAsImage : {
        show : true
      }
    }
  };
  if (typeof echartsOptions == 'undefined') {
    echartsOptions = {
      tooltip : defaultTooltip,
      toolbox : defaultToolbox
    };
  } else {
    if (typeof echartsOptions.tooltip == 'undefined') {
      echartsOptions.tooltip = defaultTooltip;
    }
    if (typeof echartsOptions.toolbox == 'undefined') {
      echartsOptions.toolbox = defaultToolbox;
    }
  }

  if (typeof lkOptions == 'string') {
    lkOptions = {
      target : lkOptions
    };
  }

  LK.log(lkOptions.target);

  var myChart = echarts.init(document.getElementById(lkOptions.target));

  myChart.setOption(echartsOptions);
};
