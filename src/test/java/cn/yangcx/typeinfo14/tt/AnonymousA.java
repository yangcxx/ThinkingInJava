package cn.yangcx.typeinfo14.tt;

import cn.yangcx.typeinfo14.HiddenImplementation;

/**
 * @author YANGCX
 * @date 2021/7/25 16:58
 */
public class AnonymousA {

    public static A makeA() {
        return new A() {
            @Override
            public void f() {
                System.out.println("Anonymous A.f()");
            }

            public void g() {
                System.out.println("Anonymous other g()");
            }

            void u() {
                System.out.println("Anonymous other u()");
            }

            protected void v() {
                System.out.println("Anonymous other v()");
            }

            private void w() {
                System.out.println("Anonymous other w()");
            }
        };
    }

    public static void main(String[] args) {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // todo 接口实现为匿名内部类依旧可以被反射调用
        HiddenImplementation.callHiddenMethod(a, "g");
    }

}
