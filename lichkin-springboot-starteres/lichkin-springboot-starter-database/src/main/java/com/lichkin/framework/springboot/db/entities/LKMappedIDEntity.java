package com.lichkin.framework.springboot.db.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lichkin.framework.bases.entities.LKIDInterface;
import com.lichkin.framework.bases.statics.LKEntityFieldLengthStatics;
import com.lichkin.framework.utils.lang.json.alibaba.LKJSONFieldOrdinal;

import lombok.Getter;
import lombok.Setter;

/**
 * ID实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class LKMappedIDEntity implements LKIDInterface {

	/** serialVersionUID */
	private static final long serialVersionUID = 968896259162238254L;

	/** 主键 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid.hex")
	@GeneratedValue(generator = "uuid")
	@Column(length = LKEntityFieldLengthStatics.LENGTH_ID)
	@JSONField(ordinal = LKJSONFieldOrdinal.ORDINAL_ID)
	private String id;


	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
	}

}
