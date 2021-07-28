package cn.yangcx.generic15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/28 8:04
 */
public class ListMaker<T> {

    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> lm = new ListMaker<>();
        List<String> stringList = lm.create();

    }
}
