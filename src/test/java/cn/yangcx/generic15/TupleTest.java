package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/25 18:08
 */
public class TupleTest {

    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = f();
        System.out.println(twoTuple);
        System.out.println(g());
    }


}

class Amphibian {
}

class Vehicle {
}
