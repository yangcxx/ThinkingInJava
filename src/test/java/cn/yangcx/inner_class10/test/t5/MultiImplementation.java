package cn.yangcx.inner_class10.test.t5;

/**
 * @author YANGCX
 * @date 2021/6/27 16:24
 */
public class MultiImplementation {

    static void takesD(D d) {
    }

    // todo 如果必须在一个类中以某种方式实现两个接口（或继承两个类）
    // 如果拥有的是抽象类或具体类，而不是接口，那就只能使用内部类才能实现多重继承
    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}
