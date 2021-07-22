package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/24 6:38
 */
public class Parcel9 {

    // todo 传递给匿名内部类的参数在旧版本的JDK上要求必须是final的（目前使用的JDK11即使删除也不会报错）
    public Destination destination(final String dest) {
        return new Destination() {

            // todo 在匿名内部类中可以执行初始化操作
            private final String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        parcel9.destination("Destination");
    }

}
