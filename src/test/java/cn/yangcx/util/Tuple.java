package cn.yangcx.util;

import cn.yangcx.generic15.ThreeTuple;
import cn.yangcx.generic15.TwoTuple;

/**
 * @author YANGCX
 * @date 2021/7/27 6:38
 */
public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }

}
