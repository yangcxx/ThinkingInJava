package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/23 7:53
 */
public class Parcel7b {

    class MyContents implements Contents {
        private int i = 11;

        // cxy 非静态内部类不能包含静态的字段（静态字段或属性不依托于类存在）
        // private static int j = 10;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b parcel7b = new Parcel7b();
        Contents contents = parcel7b.contents();
        System.out.println(contents.value());
    }

}
