package cn.yangcx.inner_class10;

/**
 * 静态内部类
 *
 * @author YANGCX
 * @date 2021/6/27 10:39
 */
public class Parcel11 {

    // todo 静态内部类（嵌套类）
    private static class ParcelContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {

        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        // fixme Nested classes can contain other static elements
        public static void f() {
        }

        static int x = 10;

        static class AnotherLevel {
            public static void f() {
                // cxy line35 嵌套类访问其他静态元素？？？
                System.err.println("ParcelDestination.x==>" + ParcelDestination.x);
                ParcelDestination.f();
            }

            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        System.err.println("contents.value()==>" + contents.value());
        Destination tasmania = destination("Tasmania");
        System.err.println("tasmania.readLabel()==>" + tasmania.readLabel());
    }

}
