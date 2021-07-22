package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/19 7:58
 */
public class OverloadingVarargs2 {

    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {

        char ch = 1;
        // cxy 运行时会报错，原因：char ch = 1
        // f(1, 'a');
        // f('a', 'b');
    }

}
