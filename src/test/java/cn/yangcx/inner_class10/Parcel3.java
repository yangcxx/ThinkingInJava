package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/22 7:35
 */
public class Parcel3 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Contents contents = parcel3.new Contents();
        Destination tasmania = parcel3.new Destination("Tasmania");
    }

}
