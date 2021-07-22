package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/27 7:57
 */
public class C extends A {

    // 所有成员变量会在构造方法之前初始化完成
    private final B b = new B();

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.b);
    }

}

class A {
    public A() {
        System.out.println("A");
    }
}

class B {
    public B() {
        System.out.println("B");
    }
}
