package cn.yangcx.inner_class10.test;

/**
 * @author YANGCX
 * @date 2021/6/23 7:34
 */
public class SubTest2 extends Test2 {

    public static void main(String[] args) {
        SubTest2 subTest2 = new SubTest2();
        // todo 该类被完全隐藏，无法访问
        // PDestination pd = (PDestination) subTest2.destination();
    }

}
