package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/28 22:59
 */
public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {
        // todo 局部内部类
        class LocalCounter implements Counter {

            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.println("name==>" + name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        // todo 匿名内部类
        return new Counter() {

            {
                // todo 匿名内部类无法拥有具名构造方法
                System.out.println("Counter(_)");
            }

            @Override
            public int next() {
                System.out.println("name==>" + name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter counter1 = localInnerClass.getCounter("Local inner class");
        Counter counter2 = localInnerClass.getCounter2("Anonymous inner class");
        for (int i = 0; i < 5; i++) {
            System.out.println(counter1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(counter2.next());
        }
    }

}

interface Counter {
    int next();
}
