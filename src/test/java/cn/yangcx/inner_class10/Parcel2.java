package cn.yangcx.inner_class10;

import lombok.ToString;

/**
 * @author YANGCX
 * @date 2021/6/21 7:48
 */
public class Parcel2 {

    @ToString
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    @ToString
    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    // todo 外部类中返回内部类引用
    public Destination to(String s) {
        return new Destination(s);
    }

    // todo 外部类中返回内部类引用
    public Contents content() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents contents = new Contents();
        // 返回内部类引用 todo 可以不用写为 OuterClassName.InnerClassName
        Parcel2.Destination destination = to(dest);
        // Destination destination2 = new Destination("Destination2");
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmania");
        // todo 可以不用写为 OuterClassName.InnerClassName
        Contents content1 = parcel2.content();
        Destination borneo = parcel2.to("Borneo");
        System.out.println(content1 + " : " + borneo);
    }

}
