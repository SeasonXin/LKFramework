package com.lichkin.framework.bases.vos;

import com.lichkin.framework.bases.enums.LKErrorCodeEnum;
import com.lichkin.framework.bases.enums.LKReturnValueShowTypeEnum;
import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;
import com.lichkin.framework.bases.exceptions.LKException;
import com.lichkin.framework.bases.exceptions.LKRuntimeException;

/**
 * 接口响应数据标准类型
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKReturnValueVo {

	/**
	 * 构造方法
	 */
	public LKReturnValueVo() {
		this(null);
	}


	/**
	 * 构造方法
	 * @param datas 返回值信息
	 */
	public LKReturnValueVo(final Object datas) {
		if (datas instanceof LKRuntimeException) {
			initWithErrorCode(((LKRuntimeException) datas).getErrorCode());
		} else if (datas instanceof LKException) {
			initWithErrorCode(((LKException) datas).getErrorCode());
		} else if (datas instanceof Throwable) {
			initWithErrorCode(LKErrorCodeEnum.ERROR);
		} else {
			initWithErrorCode(LKErrorCodeEnum.SUCCESS);
			this.datas = datas;
		}
	}


	/**
	 * 使用错误编码初始化
	 * @param errorCode 错误编码
	 */
	private void initWithErrorCode(final LKBaseEnum errorCode) {
		code = errorCode.getCode();
		info = errorCode.getNameEn() + "=>" + errorCode.getName();
	}


	/** 编码 */
	private int code;

	/** 信息 */
	private String info;

	/** 数据 */
	private Object datas;


	/**
	 * 获取编码
	 * @return 编码
	 */
	public int getCode() {
		return code;
	}


	/**
	 * 获取信息
	 * @return 信息
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * 获取数据
	 * @return 数据
	 */
	public Object getDatas() {
		return datas;
	}


	/** 显示类型 */
	private LKReturnValueShowTypeEnum showType = LKReturnValueShowTypeEnum.STANDARD;


	/**
	 * 获取显示类型
	 * @return 显示类型
	 */
	public LKReturnValueShowTypeEnum obtainShowType() {
		return showType;
	}


	/**
	 * 设置显示类型
	 * @param showType 显示类型
	 */
	public void putShowType(final LKReturnValueShowTypeEnum showType) {
		this.showType = showType;
	}

}
