package cn.yangcx.typeinfo14;

/**
 * @author YANGCX
 * @date 2021/7/22 10:28
 */
public class FamilyVsExactType {

    static void test(Object x) {
        System.out.println("Testing x of type: " + x.getClass());
        System.out.println("x instanceof Base: " + (x instanceof Base));
        System.out.println("x instanceof Derived: " + (x instanceof Derived));
        // todo instanceof 与 isInstance 完全等效
        System.out.println("Base.isInstance(x) " + (Base.class.isInstance(x)));
        System.out.println("Derived.isInstance(x) " + (Derived.class.isInstance(x)));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("======");
        test(new Derived());
    }

}

class Base {
}

class Derived extends Base {

}
