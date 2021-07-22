package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/24 6:52
 */
public class Parcel10 {

    // todo 老版本JDK：对于传递给匿名内部类内部使用的参数限制必须为final的，传递给构造器使用的参数可以不用是final的
    //  JDK11+无此限制
    public Destination destination(final String dest, final float price) {
        return new Destination() {

            private int cost;

            private String a;

            {
                a = "对于匿名内部类，实际效果这就是一个构造器";
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget");
                }
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        parcel10.destination("Tasmania", 101.395F);
    }

}
