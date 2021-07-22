package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/21 7:55
 */
public class MainTest {

    public void test() {
        Parcel2 parcel2 = new Parcel2();
        Parcel2.Destination destination = parcel2.new Destination("Chengdu");
        System.out.println("Test Method");
    }

    public static void main(String[] args) {
        MainTest mt = new MainTest();
        mt.test();
    }

}
