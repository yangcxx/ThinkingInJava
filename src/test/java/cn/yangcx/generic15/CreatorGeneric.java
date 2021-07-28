package cn.yangcx.generic15;

/**
 * 泛型创建对象的演进型：模板方法
 *
 * @author YANGCX
 * @date 2021/7/28 22:14
 */
public class CreatorGeneric {

    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
        X element = c.element;
        System.out.println(element);
    }

}

class Creator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getCanonicalName());
    }
}

class X {
}

abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        this.element = create();
    }

    // todo 模板方法，具体实现交由子类完成
    abstract T create();
}
