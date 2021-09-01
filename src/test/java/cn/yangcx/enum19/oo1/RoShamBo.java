package cn.yangcx.enum19.oo1;

import cn.yangcx.util.Enums;

/**
 * @author YANGCX
 * @date 2021/9/1 22:46
 */
public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    /**
     * cxy <T extends Enum<T> & Competitor<T>> 多上限范围限定
     */
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++)
            match(Enums.random(rsbClass), Enums.random(rsbClass));
    }

}
