package cn.yangcx.interface09.test;

/**
 * @author YANGCX
 * @date 2021/6/7 7:06
 */
public class Test1 {

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.print();
    }

}

class SubClass extends BaseClass {

    private final int i = 3;

    @Override
    void print() {
        System.out.println("SubClass.i = " + i);
    }
}

abstract class BaseClass {

    abstract void print();

    public BaseClass() {
        System.out.println("BaseClass.constructor()");
        // cxy 直接调用子类的抽象实现
        print();
    }
}



