package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/28 22:24
 */
public class BigEgg2 extends Egg2 {

    // todo 内部类继承
    //  1、明确继承自其他的内部类
    //  2、当前外围类必须同时继承被继承内部类的外围类
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        // 重写基类方法
        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        System.out.println("New BigEgg2()");
        // 可以实现向上转型
        insertYolk(new Yolk());
    }


    public static void main(String[] args) {
        // fixme 1、外围类与内部类的初始化顺序？
        //  2、Egg2.Yolk() 为何会执行两次？
        // Egg2.Yolk()
        // New Egg2()
        // Egg2.Yolk()
        // BigEgg2.Yolk()
        // BigEgg2.Yolk.f()
        Egg2 egg2 = new BigEgg2();
        egg2.g();
    }
}

class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    public Egg2() {
        System.out.println("New Egg2()");
    }

    public void insertYolk(Yolk y) {
        this.y = y;
    }

    public void g() {
        y.f();
    }
}
