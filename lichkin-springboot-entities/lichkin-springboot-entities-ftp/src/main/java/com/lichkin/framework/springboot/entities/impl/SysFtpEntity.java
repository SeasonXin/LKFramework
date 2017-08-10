package com.lichkin.framework.springboot.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.alibaba.fastjson.annotation.JSONField;
import com.lichkin.framework.springboot.entities.LKMappedBaseEntity;
import com.lichkin.framework.utils.lang.LKRandomUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * FTP文件表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_FTP")
@Getter
@Setter
@NoArgsConstructor
public class SysFtpEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 8888886666668023L;

	/** FTP服务器地址：localhost；192.168.1.111； */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 1)
	private String serverPath;

	/** 根路径：/opt/uploadFiles */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 2)
	private String rootPath;

	/** 文件全名称：/yyyy/yyyyMM/yyyyMMdd/yyyyMMddHHmmssSSSabcdef.TXT */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_NAME)
	@JSONField(ordinal = 3)
	private String fileName;

	/** 文件显示名：测试.txt */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 4)
	private String showName;

	/** 文件扩展名：TXT */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 5)
	private String extName;

	/** 模块名：/hrContact */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = LENGTH_BUS_NAME)
	@JSONField(ordinal = 6)
	private String moduleName;

	/** 文件大小（单位：bytes） */
	@Column(insertable = true, updatable = false, nullable = false, unique = false)
	@JSONField(ordinal = 7)
	private long fileSize;

	/** MD5值 */
	@Column(insertable = true, updatable = false, nullable = false, unique = true, length = LENGTH_ENCRYPT)
	@JSONField(ordinal = 8)
	private String md5;


	/**
	 * 构造方法
	 * @param serverPath FTP服务器地址
	 * @param rootPath 跟路径
	 * @param moduleName 模块名
	 * @param showName 文件显示名
	 */
	public SysFtpEntity(final String serverPath, final String rootPath, final String moduleName, final String showName) {
		this();
		final DateTime now = DateTime.now();
		this.serverPath = serverPath;
		this.rootPath = rootPath;
		this.moduleName = moduleName;
		this.showName = showName;
		final String relativePath = now.toString("/yyyy/yyyyMM/yyyyMMdd");
		final int dotIndex = showName.lastIndexOf(".");
		extName = showName.substring(dotIndex + 1, showName.length()).toUpperCase();
		fileName = relativePath + "/" + now.toString("yyyyMMddHHmmssSSS") + LKRandomUtils.create(6) + "." + extName;
	}


	/**
	 * 生成文件全名称
	 * @return 文件全名称
	 */
	public String createFullFileName() {
		return rootPath + moduleName + fileName;
	}


	/**
	 * 生成文件全路径
	 * @return 文件全路径
	 */
	public String createFullFilePath() {
		final String fullFileName = createFullFileName();
		return fullFileName.substring(0, fullFileName.lastIndexOf("/"));
	}

}
