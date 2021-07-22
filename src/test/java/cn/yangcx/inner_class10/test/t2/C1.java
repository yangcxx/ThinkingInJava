package cn.yangcx.inner_class10.test.t2;

import cn.yangcx.inner_class10.test.t1.I1;

/**
 * @author YANGCX
 * @date 2021/6/23 6:49
 */
public class C1 {

    protected class C1Impl implements I1 {

        @Override
        public void f() {
            System.out.println("C1.C1Impl.f()");
        }
    }

}
