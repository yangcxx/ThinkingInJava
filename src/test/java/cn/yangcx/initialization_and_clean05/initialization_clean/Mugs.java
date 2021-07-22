package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/14 7:46
 */
public class Mugs {

    Mug mug1;
    Mug mug2;

    // cxy 实例化初始化 - 用来初始化每一个对象的非静态变量
    //  与非静态成员变量同，确保一定会在每一次构造方法前执行运行
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 has been initialized");
    }

    public Mugs() {
        System.out.println("Mugs()");
    }

    public Mugs(int i) {
        System.out.println("Mugs(" + i + ")");
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(int) completed");
    }
}

class Mug {
    public Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
