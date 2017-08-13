package com.lichkin.framework.android.statics;

/**
 * 二维码扫描常亮值
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKSCScanStatics {

	/** 是否使用自定义的扫描结果处理 */
	public static boolean USE_LICHKIN_RESULT_HANDLER = true;

	/** 是否使用Google的扫描结果处理 */
	public static boolean USE_GOOGLE_RESULT_HANDLER = false;

	/** 调用扫描特殊定义的编码 */
	public static final int SCAN_CODE = 0x0000;

	/** 扫描结果特殊定义的KEY */
	public static final String KEY_SCAN_RESULT = "lkScanResult";

}
