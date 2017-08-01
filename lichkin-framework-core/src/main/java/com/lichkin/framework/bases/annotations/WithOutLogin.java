package com.lichkin.framework.bases.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在控制器方法上配置该注解，使得该方法拥有不需要登录就可以访问的权限。
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface WithOutLogin {

}
