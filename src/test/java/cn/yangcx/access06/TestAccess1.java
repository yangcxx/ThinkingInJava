package cn.yangcx.access06;

/**
 * @author YANGCX
 * @date 2021/5/24 21:34
 */
public class TestAccess1 {

    // cxy 除内部类外，其他类都不可以是 private 或 protected 的
    protected class A {
        public A() {
            System.out.println("Protected Inner Class A");
        }
    }

    private class B {
        public B() {
            System.out.println("Private Inner Class B");
        }
    }

    public void initInner() {
        A a = new A();
        System.out.println(a);
        B b = new B();
        System.err.println(b);
    }

    public static void main(String[] args) {
        TestAccess1 ta1 = new TestAccess1();
        ta1.initInner();
    }


}