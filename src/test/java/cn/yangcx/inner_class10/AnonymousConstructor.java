package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/24 6:43
 */
public class AnonymousConstructor {

    public static Base getBase(final int i) {
        // 在匿名内部类中不可能有命名构造器（没得类名称），但通过实例初始化可以达到创建一个构造器的效果
        return new Base(i) {
            // todo 子类构造器：形式上为先调用父类构造器，在调用当前构造器
            //  Java的类加载顺序可以保证优先执行父类构造进行初始化，此处子类构造被替换为实例初始化。效果上等同于子类也拥有了构造器方法
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }

}

abstract class Base {

    public Base(int i) {
        System.out.println("Base constructor, i= " + i);
    }

    public abstract void f();
}
