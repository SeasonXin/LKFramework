package com.lichkin.framework.springframework.entities.sys.ftp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;
import com.lichkin.framework.utils.lang.LKRandomUtils;
import com.lichkin.framework.utils.lang.LKStringUtils;

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
	private static final long serialVersionUID = -6287627962494484328L;

	/** FTP服务器地址：localhost；192.168.1.111； */
	@Column(length = 50, insertable = true, updatable = false, unique = false)
	private String serverPath;

	/** 根路径：/opt/uploadFiles */
	@Column(length = 50, insertable = true, updatable = false, unique = false)
	private String rootPath;

	/** 文件全名称：/yyyy/yyyyMM/yyyyMMdd/yyyyMMddHHmmssSSSabcdef.txt */
	@Column(length = 250, insertable = true, updatable = false, unique = false)
	private String fileName;

	/** 文件显示名：测试.txt */
	@Column(length = 100, insertable = true, updatable = false, unique = false)
	private String showName;

	/** 文件扩展名：TXT */
	@Column(length = 50, insertable = true, updatable = false, unique = false)
	private String extName;

	/** 模块名：/hrContact */
	@Column(length = 50, insertable = true, updatable = false, unique = false)
	private String moduleName;

	/** 文件大小（单位：bytes） */
	@Column(length = 50, insertable = true, updatable = false, unique = false)
	private long fileSize;

	/** MD5值 */
	@Column(length = 32, insertable = true, updatable = false, unique = true)
	private String md5;

	/**
	 * 构造方法
	 * @param serverPath FTP服务器地址
	 * @param rootPath 跟路径
	 * @param moduleName 模块名
	 * @param showName 文件显示名
	 */
	public SysFtpEntity(String serverPath, String rootPath, String moduleName, String showName) {
		this();
		final DateTime now = DateTime.now();
		this.serverPath = LKStringUtils.isBlank(serverPath) ? "localhost" : serverPath;
		this.rootPath = LKStringUtils.isBlank(rootPath) ? LKStringStatics.STR_SEPARATOR : rootPath;
		this.moduleName = LKStringUtils.isBlank(moduleName) ? "/moduleName" : LKStringStatics.STR_SEPARATOR + moduleName;
		this.showName = LKStringUtils.isBlank(showName) ? "showName.txt" : showName;
		String relativePath = now.toString("/yyyy/yyyyMM/yyyyMMdd");
		int dotIndex = showName.lastIndexOf(LKStringStatics.STR_DOT);
		extName = showName.substring(dotIndex + 1, showName.length()).toUpperCase();
		fileName = relativePath + LKStringStatics.STR_SEPARATOR + now.toString("yyyyMMddHHmmssSSS") + LKRandomUtils.create(6) + LKStringStatics.STR_DOT + extName.toLowerCase();
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
		String fullFileName = createFullFileName();
		return fullFileName.substring(0, fullFileName.lastIndexOf(LKStringStatics.STR_SEPARATOR));
	}

}
