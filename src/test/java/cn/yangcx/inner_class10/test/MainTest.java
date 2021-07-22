package cn.yangcx.inner_class10.test;

import cn.yangcx.inner_class10.test.t4.B;
import cn.yangcx.inner_class10.test.t4.Y;

/**
 * @author YANGCX
 * @date 2021/6/22 7:40
 */
public class MainTest {

    public void f() {
        NonStaticInnerClassTest1 nonStaticInnerClassTest1 = new NonStaticInnerClassTest1();
        NonStaticInnerClassTest1.Inner inner = nonStaticInnerClassTest1.new Inner();
    }

    public static void main(String[] args) {
        NonStaticInnerClassTest1 nonStaticInnerClassTest1 = new NonStaticInnerClassTest1();
        NonStaticInnerClassTest1.Inner inner = nonStaticInnerClassTest1.new Inner();

        Y y = new Y();
        y.a();
        B b = y.makeB();
        b.b();
    }

}
