package cn.yangcx.generic15;

import java.util.ArrayList;

/**
 * @author YANGCX
 * @date 2021/7/27 7:39
 */
public class TupleList<A, B> extends ArrayList<TwoTuple<A, B>> {

    private static final long serialVersionUID = -4085366179139976179L;

    public static void main(String[] args) {
        TupleList<String, Integer> twoTuples = new TupleList<>();
        twoTuples.add(TupleTest.f());
        twoTuples.add(TupleTest.f());
        for (TwoTuple<String, Integer> twoTuple : twoTuples) {
            System.out.println(twoTuple);
        }
    }

}
