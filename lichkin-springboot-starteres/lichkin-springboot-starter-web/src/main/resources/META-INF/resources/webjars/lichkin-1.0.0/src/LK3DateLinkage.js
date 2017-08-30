/**
 * 三级时间联动控件
 * @param $year 年份对象
 * @param $month 月份对象
 * @param $day 日期对象
 * @param startYear 开始年份
 * @param endYear 结束年份
 * @param disAllowBlanks 禁用空选项
 * @param showDateText 显示日期文本
 */
var LK3DateLinkage = function($year, $month, $day, endYear, startYear, disAllowBlanks, showDateText) {
  // 为参数设置默认值
  if (typeof $year == 'undefined' || $year == null) {
    $year = $("#year");// 默认控件
  }
  if (typeof $month == 'undefined' || $month == null) {
    $month = $("#month");// 默认控件
  }
  if (typeof $day == 'undefined' || $day == null) {
    $day = $("#day");// 默认控件
  }
  if (typeof endYear == 'undefined' || endYear == null) {
    endYear = new Date().getFullYear();// 默认今年
  }
  if (typeof startYear == 'undefined' || startYear == null) {
    startYear = endYear - 100;// 默认100年前
  }
  if (typeof disAllowBlanks == 'undefined' || disAllowBlanks == null) {
    disAllowBlanks = false;// 默认启用空选项
  }
  if (typeof showDateText == 'undefined' || showDateText == null) {
    showDateText = true;// 默认显示日期文本
  }

  // 存储对象级参数
  this.$year = $year;
  this.$month = $month;
  this.$day = $day;
  this.endYear = endYear;
  this.startYear = startYear;
  this.disAllowBlanks = disAllowBlanks;
  this.showDateText = showDateText;

  // 每月的天数
  this._daysInMonth = [
      0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  ];

  // 增加对象级方法定义
  /**
   * 判断是否为闰年
   * @param year 年份
   * @returns 闰年返回true，否则返回false。
   */
  this.isLeapYear = function(year) {
    return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0))
  };

  /**
   * 初始化年份选项
   */
  this.initYears = function() {
    if (!this.disAllowBlanks) {
      this.$year.append('<option value="">' + (this.showDateText ? '年' : '') + '</option>');
    }
    for (var i = this.startYear; i <= this.endYear; i++) {
      this.$year.append('<option value="' + i + '">' + i + (this.showDateText ? '年' : '') + '</option>');
    }
    var yearVal = this.$year.data('current-value');
    if (yearVal) {
      this.$year.val(yearVal);
    } else {
      if (this.disAllowBlanks) {
        this.$year.val(this.startYear);
      }
    }
  };

  /**
   * 初始化月份选项
   */
  this.initMonths = function() {
    if (!this.disAllowBlanks) {
      this.$month.append('<option value="">' + (this.showDateText ? '月' : '') + '</option>');
    }
    for (var i = 1; i <= 12; i++) {
      if (i <= 9) {
        i = '0' + i;
      }
      this.$month.append('<option value="' + i + '">' + i + (this.showDateText ? '月' : '') + '</option>');
    }
    var monthVal = this.$month.data('current-value');
    if (monthVal) {
      if (monthVal <= 9) {
        monthVal = '0' + monthVal;
      }
      this.$month.val(monthVal);
    } else {
      if (this.disAllowBlanks) {
        this.$month.val('01');
      }
    }
  };

  /**
   * 初始化日期选项
   */
  this.initDays = function() {
    var monthVal = this.$month.val();
    if (monthVal == '') {
      monthVal = '01';
    }
    var dayCnt = this._daysInMonth[parseInt(monthVal)];
    if (monthVal == 2 && this.isLeapYear(this.$year.val())) {// 闰年二月份处理
      dayCnt++;
    }
    this.$day.empty();
    if (!this.disAllowBlanks) {
      this.$day.append('<option value="">' + (this.showDateText ? '日' : '') + '</option>');
    }
    for (var i = 1; i <= dayCnt; i++) {
      if (i <= 9) {
        i = '0' + i;
      }
      this.$day.append('<option value="' + i + '">' + i + (this.showDateText ? '日' : '') + '</option>');
    }
    var dayVal = this.$day.data('current-value');
    if (dayVal) {
      if (dayVal <= 9) {
        dayVal = '0' + dayVal;
      }
      this.$day.val(dayVal);
    } else {
      if (this.disAllowBlanks) {
        this.$day.val('01');
      }
    }
  };

  /**
   * 获取日期
   */
  this.getDate = function() {
    if (this.$year.val() == '' || this.$month.val() == '' || this.$day.val() == '') {
      return null;
    }
    return this.$year.val() + '-' + this.$month.val() + '-' + this.$day.val();
  };

  // 调用对象级方法
  // 初始化年
  this.initYears();
  // 初始化月
  this.initMonths();
  // 初始化日
  this.initDays();

  var linkage = this;
  // 增加联动事件
  // 年份控件联动
  this.$year.change(function() {
    linkage.initDays();
  });
  // 月份控件联动
  this.$month.change(function() {
    linkage.initDays();
  });

};
