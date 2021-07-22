package cn.yangcx.polymorphism08.test;

/**
 * @author YANGCX
 * @date 2021/6/2 7:47
 */
public class TestClass extends BaseClass {

    public static void main(String[] args) {
        BaseClass tc = new TestClass();
        tc.m1();
        // BaseClass m1
        // ExtendClass m2
    }

    @Override
    void m2() {
        System.out.println("ExtendClass m2");
    }
}

class BaseClass {
    void m1() {
        System.out.println("BaseClass m1");
        m2();
    }

    void m2() {
        System.out.println("BaseClass m2");
    }
}
