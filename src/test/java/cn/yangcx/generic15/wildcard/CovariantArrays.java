package cn.yangcx.generic15.wildcard;

/**
 * @author YANGCX
 * @date 2021/8/4 7:23
 */
public class CovariantArrays {

    public static void main(String[] args) {
        // fixme 数组在语言中是完全定义的，因此可以内建了编译期和运行时检查，但是在使用泛型时，编译器和运行时系统都不知道你想用类型做些什么，以及应该采用什么样的规则
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        // todo fruits 运行时为 Apple[]，只能持有 Apple 及 Apple 子类
        try {
            // 运行时报错
            fruits[2] = new Fruit();
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println();
        try {
            // 运行时报错
            fruits[3] = new Orange();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}
