package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/10 7:32
 */
public class SelfBoundingMethods {

    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }

}
