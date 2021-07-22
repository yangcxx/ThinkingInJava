package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/27 10:59
 */
public interface ClassInInterface {

    void howdy();

    // todo 1、接口中的任何类自动的是public static的
    //  2、可以在内部类中实现外围接口
    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Test.Impl.howdy()");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }

}

