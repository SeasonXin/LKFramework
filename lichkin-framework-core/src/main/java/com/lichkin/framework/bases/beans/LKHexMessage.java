package com.lichkin.framework.bases.beans;

import org.apache.commons.lang.ArrayUtils;

import com.lichkin.framework.utils.lang.LKNumberUtils;

import lombok.Getter;

/**
 * 十六进制消息类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
public class LKHexMessage {

	/** 十进制表示的字节数组 */
	private final byte[] bytes;

	/** 十六进制表示的字节数组 */
	private final String[] hexes;

	/** 十六进制字符串 */
	private final String message;

	/** 字节长度 */
	private final int length;


	/**
	 * 构造方法
	 * @param bytes 十进制表示的字节数组
	 */
	public LKHexMessage(final byte[] bytes) {
		super();
		this.bytes = bytes;
		length = bytes.length;
		final String[] hexes = new String[length];
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			hexes[i] = LKNumberUtils.toHex(this.bytes[i], 1).toUpperCase();
			sb.append(hexes[i]);
		}
		this.hexes = hexes;
		message = sb.toString();
	}


	/**
	 * 构造方法
	 * @param message 十六进制表示的字符串
	 */
	public LKHexMessage(final String message) {
		super();
		this.message = message.toUpperCase();
		length = message.length() / 2;
		final String[] hexes = new String[length];
		final byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			hexes[i] = message.substring(i * 2, (i + 1) * 2).toUpperCase();
			bytes[i] = LKNumberUtils.toByte(hexes[i]);
		}
		this.bytes = bytes;
		this.hexes = hexes;
	}


	/**
	 * 获取反转后的十进制表示的字节数组
	 * @return 十进制表示的字节数组
	 */
	public byte[] getBytesReverse() {
		final byte[] bytes = new byte[this.bytes.length];
		for (int i = 0; i < this.bytes.length; i++) {
			bytes[i] = this.bytes[this.bytes.length - i - 1];
		}
		return bytes;
	}


	/**
	 * 获取反转后的十六进制表示的字节数组
	 * @return 十六进制表示的字节数组
	 */
	public String[] getHexesReverse() {
		final String[] hexes = new String[this.hexes.length];
		for (int i = 0; i < this.hexes.length; i++) {
			hexes[i] = this.hexes[this.hexes.length - i - 1];
		}
		return hexes;
	}


	/**
	 * 获取反转后的十六进制表示的字符串
	 * @return 十六进制表示的字符串
	 */
	public String getMessageReverse() {
		final StringBuilder sb = new StringBuilder();
		for (final String hexe : hexes) {
			sb.insert(0, hexe);
		}
		return sb.toString();
	}


	/**
	 * 获取十六进制表示的字节
	 * @param index 索引值
	 * @return 十六进制表示的字节
	 */
	public String getHex(final int index) {
		return hexes[index];
	}


	/**
	 * 获取十六进制表示的字节数组
	 * @param startIndex 开始索引值
	 * @param endIndex 结束索引值
	 * @return 十六进制表示的字节数组
	 */
	public String[] getHexes(final int startIndex, final int endIndex) {
		final String[] hexes = new String[endIndex - startIndex];
		for (int i = startIndex; i < endIndex; i++) {
			hexes[i] = this.hexes[i];
		}
		return hexes;
	}


	/**
	 * 获取十进制表示的字节
	 * @param index 索引值
	 * @return 十进制表示的字节
	 */
	public byte getByte(final int index) {
		return bytes[index];
	}


	/**
	 * 获取十进制表示的字节数组
	 * @param startIndex 开始索引值
	 * @param endIndex 结束索引值
	 * @return 十进制表示的字节数组
	 */
	public byte[] getBytes(final int startIndex, final int endIndex) {
		final byte[] bytes = new byte[endIndex - startIndex];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = this.bytes[i + startIndex];
		}
		return bytes;
	}


	/**
	 * 获取十进制表示的数字
	 * @param startIndex 开始索引值
	 * @param endIndex 结束索引值
	 * @param asc 正序true，倒序false。
	 * @return 十进制表示的数字
	 */
	public long getLong(final int startIndex, final int endIndex, final boolean asc) {
		return LKNumberUtils.toDecimal(getBytes(startIndex, endIndex), asc);
	}


	/**
	 * 获取十六进制表示的字符串
	 * @param startIndex 开始索引值
	 * @param endIndex 结束索引值
	 * @param asc 正序true，倒序false。
	 * @return 十六进制表示的字符串
	 */
	public String getHex(final int startIndex, final int endIndex, final boolean asc) {
		return LKNumberUtils.toHex(getBytes(startIndex, endIndex), asc);
	}


	@Override
	public String toString() {
		return "bytes:[" + ArrayUtils.toString(bytes) + "], message:[" + message + "].";
	}

}
