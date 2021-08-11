package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/10 7:48
 */
public class SelfBoundAndCovariantArguments {

    public static void main(String[] args) {

    }

    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // cxy 使用了自限定类型，编译器不能识别将基类型作为参数传递给set()的尝试
        //  不使用自限定类型，普通的继承机制就会介入，且能够实现重载
        // s1.set(sbs);
    }
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}
