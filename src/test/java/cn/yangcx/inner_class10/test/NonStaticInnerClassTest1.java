package cn.yangcx.inner_class10.test;

/**
 * @author YANGCX
 * @date 2021/6/22 7:39
 */
public class NonStaticInnerClassTest1 {

    public class Inner {

    }

    public static void main(String[] args) {
        NonStaticInnerClassTest1 nonStaticInnerClassTest1 = new NonStaticInnerClassTest1();
        Inner inner = nonStaticInnerClassTest1.new Inner();
    }

}

