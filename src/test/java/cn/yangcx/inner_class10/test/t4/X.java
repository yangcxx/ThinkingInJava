package cn.yangcx.inner_class10.test.t4;

/**
 * @author YANGCX
 * @date 2021/6/27 16:17
 */
public class X implements A, B {

    // 使用独立类进行多实现

    @Override
    public void a() {
        System.out.println("X.a()");
    }

    @Override
    public void b() {
        System.out.println("X.b()");
    }
}
