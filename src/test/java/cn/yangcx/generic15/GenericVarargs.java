package cn.yangcx.generic15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/26 21:52
 */
public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        Collections.addAll(result, args);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("QWERTYUIOPLKJHGFDSAZXCVBNM".split(""));
        System.out.println(ls);
    }

}
