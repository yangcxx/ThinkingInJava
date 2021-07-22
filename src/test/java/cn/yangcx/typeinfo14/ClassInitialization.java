package cn.yangcx.typeinfo14;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/19 21:38
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        // todo .class 不会自动初始化 Class 对象
        Class<Initializable> initalizableClass = Initializable.class;
        System.out.println("After creating Initializable ref");
        // cxy 不会触发初始化
        System.out.println(Initializable.staticFinal);
        // 触发初始化
        System.out.println(Initializable.staticFinal2);
        // 触发初始化
        System.out.println(Initializable2.staticNonFinal);
        // 触发初始化
        Class<?> aClass = Class.forName("cn.yangcx.typeinfo14.Initializable3");
        System.out.println("After creating Initializable3 ref");
        System.out.println(Initializable3.staticNonFinal);
        System.err.println("================================================================================");
        Class intClass = int.class;
        Class<Integer> intClass2 = int.class;
        // cxy Integer extends Number，但Number Class域Integer Class之间没关系
        // Class<Number> numberClass = int.class;
        // 使用通配符
        Class<?> numberClass = int.class;
        // 创建类型子类型， ? extends T 创建一个范围
        Class<? extends Number> bounded = int.class;
    }

}

class Initializable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initializable");
    }
}

class Initializable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initializable2");
    }
}

class Initializable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initializable3");
    }
}
