package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/22 8:03
 */
public class TestParcel {

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        // cxy 返回限定类型写法不同
        Destination tasmania = parcel4.destination("Tasmania");
        Parcel4.PDestination chengdu = parcel4.new PDestination("Chengdu");
        // todo 无法创建 private 类
        // parcel4.new PContents();
    }

}


class Parcel4 {
    private class PContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}
