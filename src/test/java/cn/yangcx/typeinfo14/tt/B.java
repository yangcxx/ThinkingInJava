package cn.yangcx.typeinfo14.tt;

/**
 * @author YANGCX
 * @date 2021/7/23 7:49
 */
public class B implements A {
    @Override
    public void f() {
        System.out.println("B.impl.A f()");
    }

    public void g() {
        System.out.println("B g()");
    }
}
