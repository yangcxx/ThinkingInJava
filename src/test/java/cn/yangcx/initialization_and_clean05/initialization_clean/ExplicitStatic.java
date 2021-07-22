package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/14 7:39
 */
public class ExplicitStatic {

    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }

    static Cups cups1 = new Cups();
    // static Cups cups2 = new Cups();

}

class Cup {
    public Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    // cxy 静态代码块，与成员静态变量完全相同
    //  仅会在必要执行一次
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        System.out.println("Cups()");
    }
}

