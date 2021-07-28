package cn.yangcx.generic15;

import cn.yangcx.util.Tuple;

/**
 * @author YANGCX
 * @date 2021/7/27 6:43
 */
public class TupleTest2 {

    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> f2() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        ThreeTuple<Amphibian, String, Integer> f2 = f2();

        System.out.println(f);
        System.out.println();
        System.out.println(f2);
    }

}
