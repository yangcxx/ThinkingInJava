package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/29 6:29
 */
public class InnerClassExtends extends OuterClass.StaticInnerClass {

    @Override
    public void f() {
        System.out.println("InnerClassExtends.f()");
    }

    public static void main(String[] args) {
        InnerClassExtends ice = new InnerClassExtends();
        ice.f();
    }
}

class OuterClass {
    static class StaticInnerClass {
        public void f() {
            System.out.println("OuterClass.StaticInnerClass.f()");
        }
    }
}
