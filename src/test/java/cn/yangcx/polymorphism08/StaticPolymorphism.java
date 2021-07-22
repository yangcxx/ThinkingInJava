package cn.yangcx.polymorphism08;

/**
 * @author YANGCX
 * @date 2021/6/6 10:21
 */
public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        // static 域与类直接绑定，不存在多态特性
        // System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }

}

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "StaticSub staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "StaticSub dynamicGet()";
    }
}
