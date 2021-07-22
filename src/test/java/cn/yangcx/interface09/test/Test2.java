package cn.yangcx.interface09.test;

/**
 * @author YANGCX
 * @date 2021/6/7 7:14
 */
public class Test2 {

    public static void main(String[] args) {
        // cxy 此处创建的已经是子类了
        NoMethodClass noMethodClass = new NoMethodClass() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

}


abstract class NoMethodClass {

    // 抽象类中可以拥有构造方法，但是不能直接创建实例对象
    // 当实例化子类对象时，就会初始化父类
    // 不管父类是不是抽象类都会调用父类的构造类
    public NoMethodClass() {
    }
}
