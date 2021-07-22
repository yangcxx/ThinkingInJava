package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/27 7:28
 */
public class Detergent extends Cleanser {

    @Override
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append("foam()");
    }

    // cxy 1、即使是一个程序中含有多个类，只有命令行所调用的那个类的 main() 方法会被调用
    //  2、即使 Clazz 类不是一个 public 类，如果命令行是 java Clazz，那么 Clazz.main() 仍然会被调用
    //  3、即使一个类只具有包访问权限，其 public main() 仍然是可以访问的
    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        // 调用自己实现的方法，没有才调用父类方法
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("Testing base class");
        // 显示调用 main 方法
        Cleanser.main(args);
    }
}


class Cleanser {

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }

    private String s = "Cleanser ";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override
    public String toString() {
        return "Cleanser{" +
                "s='" + s + '\'' +
                '}';
    }
}
