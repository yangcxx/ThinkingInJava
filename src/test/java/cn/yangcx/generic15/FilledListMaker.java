package cn.yangcx.generic15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/28 8:06
 */
public class FilledListMaker<T> {

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> flm = new FilledListMaker<>();
        List<String> list = flm.create("Hello", 4);
        System.out.println(list);
    }

}
