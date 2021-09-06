package cn.yangcx.annotation20.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YANGCX
 * @date 2021/9/6 21:15
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default 0;

    String name() default "";

    /**
     * 注解嵌套
     */
    Constraints constraints() default @Constraints;

}
