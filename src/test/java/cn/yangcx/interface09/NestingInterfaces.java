package cn.yangcx.interface09;

/**
 * @author YANGCX
 * @date 2021/6/17 8:04
 */
public class NestingInterfaces {

    public class BImpl implements A.B {

        @Override
        public void f() {
            System.out.println("NestingInterfaces.BImpl.f()");
        }
    }

    class CImpl implements A.C {

        @Override
        public void f() {
            System.out.println("NestingInterfaces.CImpl.f()");
        }
    }

    class EImpl implements E {

        @Override
        public void g() {
            System.out.println("NestingInterfaces.EImpl.g()");
        }
    }

    class EGImp implements E.G {

        @Override
        public void f() {
            System.out.println("NestingInterfaces.EGImp.f()");
        }
    }

    class EImpl2 implements E {

        @Override
        public void g() {
            System.out.println("NestingInterfaces.EImpl2.g()");
        }

        class EG implements E.G {

            @Override
            public void f() {
                System.out.println("NestingInterfaces.EImpl2.EG.g()");
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        // D 是 private 的，无法访问
        // A.D ad = a.getD();
        // A.DImp2 di = a.getD();
        // a.getD().f();
        a.receiveD(a.getD());
    }
}

interface E {

    interface G {
        void f();
    }

    interface H {
        void f();
    }

    // cxy 接口内的所有定义默认及有且仅是 public 的（包括嵌套接口）
    // private interface I{}

    void g();

}

class A {
    interface B {
        void f();
    }

    public class BImp implements B {

        @Override
        public void f() {
            System.out.println("BImpl.f()");
        }
    }

    private class BImp2 implements B {

        @Override
        public void f() {
            System.out.println("BImpl2.f()");
        }
    }

    interface C {
        void f();
    }

    public class CImp implements C {

        @Override
        public void f() {
            System.out.println("CImp.f()");
        }
    }

    private class CImp2 implements C {

        @Override
        public void f() {
            System.out.println("CImp2.f()");
        }
    }

    // todo 定义在类中的接口可以被定义为 private 的
    private interface D {
        void f();
    }

    // 嵌套实现可以被同时实现为 public 或 private 的
    private class DImp implements D {

        @Override
        public void f() {
            System.out.println("DImp.f()");
        }
    }

    public class DImp2 implements D {

        @Override
        public void f() {
            System.out.println("DImp2.f()");
        }
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}
