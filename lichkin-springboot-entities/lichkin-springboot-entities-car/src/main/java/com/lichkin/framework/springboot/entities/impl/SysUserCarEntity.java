package com.lichkin.framework.springframework.entities.sys.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lichkin.framework.bases.enums.LKYesNoEnum;
import com.lichkin.framework.springboot.db.entities.LKMappedBaseEntity;

/**
 * 用户车辆信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Entity
@Table(name = "T_SYS_USER_CAR")
public class SysUserCarEntity extends LKMappedBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -3725207454022458203L;

	/** 用户ID */
	@Column(insertable = true, updatable = false, nullable = false, unique = false, length = 32)
	private String userId;

	/** 品牌ID */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 1000)
	private String brandId;

	/** 系列ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String seriseId;

	/** 型号ID */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 100)
	private String modelId;

	/** 车牌号（省份码） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 10)
	private String licensePlateHeader;

	/** 车牌号（号码） */
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 10)
	private String licensePlateNumber;

	/** 发动机号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 50)
	private String engineNumber;

	/** 车架号 */
	@Column(insertable = true, updatable = true, nullable = true, unique = false, length = 50)
	private String frameNumber;

	/** 默认车辆 */
	@Enumerated(EnumType.STRING)
	@Column(insertable = true, updatable = true, nullable = false, unique = false, length = 32)
	private LKYesNoEnum defaultCar;


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBrandId() {
		return brandId;
	}


	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}


	public String getSeriseId() {
		return seriseId;
	}


	public void setSeriseId(String seriseId) {
		this.seriseId = seriseId;
	}


	public String getModelId() {
		return modelId;
	}


	public void setModelId(String modelId) {
		this.modelId = modelId;
	}


	public String getLicensePlateHeader() {
		return licensePlateHeader;
	}


	public void setLicensePlateHeader(String licensePlateHeader) {
		this.licensePlateHeader = licensePlateHeader;
	}


	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}


	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}


	public String getEngineNumber() {
		return engineNumber;
	}


	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}


	public String getFrameNumber() {
		return frameNumber;
	}


	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}


	public LKYesNoEnum getDefaultCar() {
		return defaultCar;
	}


	public void setDefaultCar(LKYesNoEnum defaultCar) {
		this.defaultCar = defaultCar;
	}

}
