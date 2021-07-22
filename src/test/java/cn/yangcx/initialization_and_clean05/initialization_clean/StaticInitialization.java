package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * cxy 初始化顺序：静态成员变量、非静态成员变量、构造方法
 *
 * @author YANGCX
 * @date 2021/5/13 7:51
 */
public class StaticInitialization {

    public static void main(String[] args) {
        new Cupboard();

        new Cupboard();

        // table.f2(1);
        //
        // cupboard.f3(1);

    }

    // static Table table = new Table();
    // static Cupboard cupboard = new Cupboard();

}

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    // 1 cxy 静态成员变量只有在必要时才会初始化（只有在对象创建或第一次访问静态数据时才会被初始化；且只会初始化一次）
    // cxy 静态初始化只会在 Class 对象首次加载时进行一次
    static Bowl bowl1 = new Bowl(1);

    // 3
    public Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    // 2
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    // 6 cxy 非静态成员变量在每次创建对象时都会进行初始化，且都在构造方法前执行
    Bowl bowl3 = new Bowl(3);
    // 4
    static Bowl bowl4 = new Bowl(4);

    // 7
    public Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    // 构造方法前执行
    Bowl bowl6 = new Bowl(6);

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    // 5
    static Bowl bowl5 = new Bowl(5);
}

