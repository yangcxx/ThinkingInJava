package cn.yangcx.interface09.test;

/**
 * @author YANGCX
 * @date 2021/6/7 7:22
 */
public class Test3 {

    static void s(NoFieldClass noFieldClass) {
        // ((SubNoFieldClass) noFieldClass).m();
        noFieldClass.m();
    }

    public static void main(String[] args) {
        s(new SubNoFieldClass());
    }

}

class SubNoFieldClass extends NoFieldClass {

    @Override
    void m() {
        System.out.println("SubNoFieldClass.m()");
    }

}

abstract class NoFieldClass {

    abstract void m();

}
