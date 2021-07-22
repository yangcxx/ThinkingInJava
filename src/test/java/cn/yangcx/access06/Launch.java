package cn.yangcx.access06;

/**
 * @author YANGCX
 * @date 2021/5/24 21:40
 */
public class Launch {

    public static void main(String[] args) {
        Launch launch = new Launch();
        launch.testSingleton();
    }

    void testPrivate() {
        // cxy 外部类无法访问是由构造函数
        // Soup1 soup1 = new Soup1();
    }

    void testStatic() {
        Soup1 soup1 = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

}

class Soup1 {
    // cxy 构造函数私有化：外部类不能直接访问；但在本类中可以正常访问
    private Soup1() {
    }

    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {
    }

    // cxy Singleton模式
    private static Soup2 ps1 = new Soup2();

    public static Soup2 access() {
        return ps1;
    }

    public void f() {
        Soup2 soup2 = new Soup2();
        System.out.println(soup2);
    }
}
