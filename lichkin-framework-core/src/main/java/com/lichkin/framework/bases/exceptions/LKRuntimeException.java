package com.lichkin.framework.bases.exceptions;

import com.lichkin.framework.bases.enums.interfaces.LKBaseEnum;

/**
 * 运行时异常
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKRuntimeException extends RuntimeException {

	/** serialVersionUID */
	static final long serialVersionUID = -1476773748417076030L;

	/** 错误编码枚举 */
	private final LKBaseEnum errorCode;

	/** 错误信息 */
	private final String msg;


	/**
	 * 获取错误编码枚举
	 * @return 错误编码枚举
	 */
	public LKBaseEnum getErrorCode() {
		return errorCode;
	}


	/**
	 * 获取错误信息
	 * @return 错误信息
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * 构造方法
	 * @param errorCode 错误编码枚举
	 */
	public LKRuntimeException(final LKBaseEnum errorCode) {
		this(errorCode, errorCode.getName());
	}


	/**
	 * 构造方法
	 * @param errorCode 错误编码枚举
	 * @param msg 错误信息
	 */
	public LKRuntimeException(final LKBaseEnum errorCode, final String msg) {
		super(msg);
		this.errorCode = errorCode;
		this.msg = msg;
	}


	/**
	 * 构造方法
	 * @param errorCode 错误编码枚举
	 * @param throwable 异常信息
	 */
	public LKRuntimeException(final LKBaseEnum errorCode, final Throwable throwable) {
		super(throwable);
		throwable.printStackTrace();
		this.errorCode = errorCode;
		msg = throwable.getMessage();
	}

}
