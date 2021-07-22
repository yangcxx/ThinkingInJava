package cn.yangcx.inner_class10.test.t4;

/**
 * @author YANGCX
 * @date 2021/6/27 16:17
 */
public class Y implements A {

    public B makeB() {
        return () -> System.out.println("Inner B.b()");
    }

    @Override
    public void a() {
        System.out.println("Y.a()");
    }
}
