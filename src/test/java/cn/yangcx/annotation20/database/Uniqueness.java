package cn.yangcx.annotation20.database;

/**
 * @author YANGCX
 * @date 2021/9/6 21:20
 */
public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique = true);

}
