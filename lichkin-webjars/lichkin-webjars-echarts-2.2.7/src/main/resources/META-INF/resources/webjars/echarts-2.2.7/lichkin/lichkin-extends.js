/**
 * 扩展脚本
 */
LK.ECharts = new Object();

/**
 * 创建线性图标
 * @param echartsOptions echarts参数
 * @param lkOptions 自定义参数
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

  require.config({
    paths : {
      'echarts/chart/line' : _ECHARTS + '/build/dist/chart/line',
      'echarts/chart/bar' : _ECHARTS + '/build/dist/chart/bar'
    }
  });

  require([
      'echarts', 'echarts/chart/line', 'echarts/chart/bar'
  ], function(echarts) {
    var myChart = echarts.init(document.getElementById(lkOptions.target));
    myChart.setOption(echartsOptions);
    window.addEventListener("resize", function() {
      myChart.resize();
    });
  });
};
