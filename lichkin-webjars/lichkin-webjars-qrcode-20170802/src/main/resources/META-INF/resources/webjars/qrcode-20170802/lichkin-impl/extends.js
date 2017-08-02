/**
 * 扩展脚本
 */
LK.QRCode = new Object();

/**
 * 生成二维码
 * 
 * @param qrcodeOptions QRCode参数。
 * 
 * @param lkOptions QRCode自定义参数。
 */
LK.QRCode.qrcode = function(qrcodeOptions, lkOptions) {
  LK.log('call LK.QRCode.qrcode');
  LK.log({
    qrcodeOptions : qrcodeOptions,
    lkOptions : lkOptions
  });

  // 初始化参数
  if (typeof qrcodeOptions == 'undefined') {
    qrcodeOptions = {
      text : 'undefined',
      typeNumber : 10,
      errorCorrectionLevel : 'H'
    };
  } else if (typeof qrcodeOptions == 'string') {
    qrcodeOptions = {
      text : qrcodeOptions,
      typeNumber : 10,
      errorCorrectionLevel : 'H'
    };
  } else {
    if (typeof qrcodeOptions.text == 'undefined') {
      qrcodeOptions.text = 'undefined';
    }
    if (typeof qrcodeOptions.typeNumber == 'undefined') {
      qrcodeOptions.typeNumber = 10;
    }
    if (typeof qrcodeOptions.errorCorrectionLevel == 'undefined') {
      qrcodeOptions.errorCorrectionLevel = 'H';
    }
  }

  if (typeof lkOptions == 'undefined') {
    lkOptions = {
      target : document.body
    };
  } else if (typeof lkOptions == 'string') {
    lkOptions = {
      target : document.getElementById(lkOptions)
    };
  } else {
    if (typeof lkOptions.target == 'undefined') {
      lkOptions.target = document.body;
    }
  }

  LK.log(lkOptions.target);

  qrcode.stringToBytes = qrcode.stringToBytesFuncs['UTF-8'];
  var qr = qrcode(qrcodeOptions.typeNumber || 4, qrcodeOptions.errorCorrectionLevel || 'M');
  qr.addData(qrcodeOptions.text, qrcodeOptions.mode);
  qr.make();

  lkOptions.target.innerHTML = qr.createImgTag();
};

LK.qrcode = LK.QRCode.qrcode;
