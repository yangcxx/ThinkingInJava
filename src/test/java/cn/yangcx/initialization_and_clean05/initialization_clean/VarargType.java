package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/18 7:53
 */
public class VarargType {

    static void f(Character... args) {
        System.out.println(args.getClass());
        System.out.println("length: " + args.length);
    }

    static void g(int... args) {
        System.out.println(args.getClass());
        System.out.println("length: " + args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]: " + int[].class);
    }

}
