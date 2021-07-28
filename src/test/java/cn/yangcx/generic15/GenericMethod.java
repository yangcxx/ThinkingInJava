package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/26 21:37
 */
public class GenericMethod {

    public <T> void f(T t) {
        // 泛型方法定义
        System.out.println(t.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
