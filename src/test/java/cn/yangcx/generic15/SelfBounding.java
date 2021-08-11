package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/10 7:12
 */
public class SelfBounding {

    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }

}

/**
 * todo 泛型自限定
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

// 类D不满足 T extends SelfBounded<T>
// class E extends SelfBounded<D>{}

class F extends SelfBounded {
}
