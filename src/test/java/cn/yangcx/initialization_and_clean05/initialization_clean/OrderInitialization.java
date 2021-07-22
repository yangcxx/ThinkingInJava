package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/13 7:35
 */
public class OrderInitialization {

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }

}

class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    // cxy 所有的成员变量会在任何方法（含构造方法）调用之前被初始化
    Window w1 = new Window(1);

    House() {
        System.out.println("House()");
        // cxy 会覆盖之前初始化的值
        w3 = new Window(33);
    }

    static {
        System.out.println("This is a static code");
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    {
        System.out.println("这是一个非静态代码块");
    }

    // 此次初始化会被丢弃，并作为垃圾回收
    Window w3 = new Window(3);
}
