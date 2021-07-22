package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/23 7:48
 * @see Parcel7b
 */
public class Parcel7 {

    public Contents contents() {
        // todo 匿名内部类
        return new Contents() {

            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
        System.out.println(contents.value());
    }

}
