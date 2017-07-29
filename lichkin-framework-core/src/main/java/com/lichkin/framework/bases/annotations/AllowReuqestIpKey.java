package com.lichkin.framework.bases.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在控制器方法上配置该注解，使得该方法拥有IP地址访问控制权限。
 * 注解中配置的key为配置属性中的KEY，对应的VALUE为拥有权限的IP地址，使用逗号分割。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowReuqestIpKey {

	/**
	 * 配置属性中的KEY，默认值取[类名.方法名]。
	 * @return 配置属性中的KEY
	 */
	String key() default "";

}
