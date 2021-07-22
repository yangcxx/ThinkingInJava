package cn.yangcx.inner_class10.test.t3;

import cn.yangcx.inner_class10.test.t2.C1;

/**
 * @author YANGCX
 * @date 2021/6/23 6:50
 */
public class C2 extends C1 {

    public C1 i1() {
        // todo 无法访问
        // return new C1Impl();
        return null;
    }

}
