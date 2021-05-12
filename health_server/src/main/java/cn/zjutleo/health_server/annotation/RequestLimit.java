package cn.zjutleo.health_server.annotation;

import java.lang.annotation.*;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 访问次数限制
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestLimit {
    int amount() default 30;
    int time() default 60;
}
