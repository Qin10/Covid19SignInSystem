package cn.zjutleo.health_server.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 需要鉴权的注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresLogin {
    boolean required() default true;
    String[] requiresRoles() default {};
}
