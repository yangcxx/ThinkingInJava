package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/23 7:59
 */
public class Parcel8 {

    public Wrapping wrapping(int x) {
        // todo 传参给有参构造
        return new Wrapping(x) {
            @Override
            public int getI() {
                return super.getI();
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        parcel8.wrapping(11);
    }

}

class Wrapping {
    private int i;

    public Wrapping(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
