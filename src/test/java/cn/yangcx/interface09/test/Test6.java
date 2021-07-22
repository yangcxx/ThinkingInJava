package cn.yangcx.interface09.test;

/**
 * @author YANGCX
 * @date 2021/6/8 7:54
 */
public class Test6 {

    public static void m1(A a) {
        a.a();
    }

    public static void m2(B b) {
        b.b();
    }

    public static void m3(C c) {
        c.c();
    }

    public static void m4(D d) {
        d.d();
    }

    public static void main(String[] args) {
        F f = new F();
        m1(f);
        m2(f);
        m3(f);
        m4(f);
    }

}

class F extends E implements D {

    @Override
    public void d() {

    }

    @Override
    public void a() {

    }

    @Override
    public void aa() {

    }

    @Override
    public void b() {

    }

    @Override
    public void bb() {

    }

    @Override
    public void c() {

    }

    @Override
    public void cc() {

    }
}

class E {
    void e() {
        System.out.println("这是一个具体的类");
    }
}

interface D extends A, B, C {
    void d();
}

interface A {
    void a();

    void aa();
}

interface B {
    void b();

    void bb();
}

interface C {
    void c();

    void cc();
}


