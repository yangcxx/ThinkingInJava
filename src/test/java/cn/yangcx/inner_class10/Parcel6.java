package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/23 7:15
 */
public class Parcel6 {

    private void internalTracking(boolean b) {
        if (b) {
            // cxy 该类除了作用域之外，其他与普通类完全相同
            class TrackingSlip {
                private final String id;

                public TrackingSlip(String id) {
                    this.id = id;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String slip = ts.getSlip();
            System.out.println(slip);
        }

        // todo 超出访问范围了
        // TrackingSlip ts = new TrackingSlip("slip");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }

}

