package cn.yangcx.inner_class10;

/**
 * 一个内部类（非静态）被嵌套多少层不重要，关键是他能透明的访问外围类的所有成员
 *
 * @author YANGCX
 * @date 2021/6/27 16:01
 */
public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }

}

class MNA {
    private void f() {
        System.out.println("MNA.f()");
    }

    class A {
        private void g() {
            System.out.println("MNA.A.f()");
        }

        public class B {
            void h() {
                // 可以透明的访问外围类的所有成员
                g();
                f();
            }
        }
    }
}
