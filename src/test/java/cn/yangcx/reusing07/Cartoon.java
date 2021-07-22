package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/27 7:50
 */
public class Cartoon extends Drawing {
    // cxy Java 会自动在子类（导出类）的构造器中插入对父类（基类）构造器的调用
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        // cxy 子类初始化之前，一定会保证基类先行初始化
        Cartoon cartoon = new Cartoon();
        System.out.println(cartoon);
    }
}

class Art {
    public Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing constructor");
    }
}