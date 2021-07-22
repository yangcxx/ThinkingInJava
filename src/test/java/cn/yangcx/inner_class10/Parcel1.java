package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/21 7:40
 */
public class Parcel1 {

    // 内部类定义
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    // 内部类定义
    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    public void ship(String dest) {
        // 使用内部类
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 parcell1 = new Parcel1();
        parcell1.ship("Tasmania");
    }

}
