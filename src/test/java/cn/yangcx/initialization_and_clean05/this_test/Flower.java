package cn.yangcx.initialization_and_clean05.this_test;

/**
 * @author YANGCX
 * @date 2021/4/18 8:17
 */
public class Flower {

    int petalCount = 0;
    String value = "initial value";

    public Flower(int petalCount) {
        this.petalCount = petalCount;
        System.out.println("Constructor int arg only, petalCount: " + this.petalCount);
    }

    public Flower(String value) {
        // cxy 成员变量名与参数同名时，使用 this 指定为成员变量
        this.value = value;
        System.out.println("Constructor string arg only, value: " + this.value);
    }

    public Flower(int petalCount, String value) {
        // cxy 1. 可以使用 this 调用一个构造器（不能调用两个） 2.调用构造器必须位于起始处
        this(petalCount);
        // this();
        this.petalCount = petalCount;
        this.value = value;
        System.out.println("Constructor string and int arg, value: " + this.value + " , petalCount: " + this.petalCount);
    }

    public Flower() {
        this(47, "killer");
        System.out.println("Constructor not arg");
    }

    void printPetalCount() {
        // cxy 除构造器外，编译器禁止从其他任何地方使用 this 调用构造器
        // this(11);
        System.out.println("petalCount: " + this.petalCount + " ,s: " + this.value);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCount();
    }
}
