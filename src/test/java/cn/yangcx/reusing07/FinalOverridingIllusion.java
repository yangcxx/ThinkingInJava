package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/30 8:41
 */
public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        op2.h();
        // 可以执行向上转型
        OverridingPrivate op = op2;
        op.h();
        // cxy private 隐式的同时是 final 的，子类无法访问
        // op.f();
        // op.g();
        WithFinals wf = op;
        // wf.f();
        // wf.g();
        wf.h();
        // cxy 调用时的实际类型为子类
    }

}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public final void g() {
        System.out.println("OverridingPrivate2.g()");
    }

    @Override
    public void h() {
        System.out.println("OverridingPrivate2.h()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private final void g() {
        System.out.println("OverridingPrivate.g()");
    }

    @Override
    public void h() {
        System.out.println("OverridingPrivate.h()");
    }
}

class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private final void g() {
        System.out.println("WithFinals.g()");
    }

    public void h() {
        System.out.println("WithFinals.h()");
    }
}
