package cn.yangcx.typeinfo14.tt;

/**
 * @author YANGCX
 * @date 2021/7/23 7:53
 */
public class HiddenC {

    public static A makeA() {
        return new C();
    }

    public static void main(String[] args) {
        A a = makeA();
        // other code
    }

}

// todo 将具体实现使用包访问权限，屏蔽外部包的访问
class C implements A {

    @Override
    public void f() {
        System.out.println("C.impl A f()");
    }

    public void g() {
        System.out.println("C.g()");
    }

    void u() {
        System.out.println("C.u()");
    }

    protected void v() {
        System.out.println("C.v()");
    }

    private void w() {
        System.out.println("C.w()");
    }
}
