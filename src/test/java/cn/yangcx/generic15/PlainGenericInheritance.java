package cn.yangcx.generic15;

import cn.yangcx.util.Base;
import cn.yangcx.util.Derived;

/**
 * @author YANGCX
 * @date 2021/8/11 7:01
 */
public class PlainGenericInheritance {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        // todo 重载
        dgs.set(derived);
        dgs.set(base);
    }

}

class GenericSetter<T> {
    void set(T arg) {
        System.out.println("GenericSetter.set(Base), " + arg.getClass().getSimpleName());
    }
}

class DerivedGS extends GenericSetter<Base> {
    /**
     * 这是一个重载方法
     */
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived), " + derived.getClass().getSimpleName());
    }

    /**
     * 这是一个重写方法
     */
    @Override
    void set(Base arg) {
        super.set(arg);
    }
}
