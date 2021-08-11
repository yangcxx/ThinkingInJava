package cn.yangcx.generic15;

import cn.yangcx.util.Generator;

/**
 * @author YANGCX
 * @date 2021/8/9 21:46
 */
public class PrimitiveGenericTest {

    public static void main(String[] args) {
        FArray.fill(new Integer[7], null);
    }

}

class FArray {
    public static <T> T[] fill(T[] a, Generator<T> generator) {
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.next();
        }
        return a;
    }
}
