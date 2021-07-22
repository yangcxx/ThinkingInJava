package cn.yangcx.jcf11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author YANGCX
 * @date 2021/6/29 7:25
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> cc = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // todo Set中只有元素不存在的情况下才会添加
            cc.add(i);
        }
        cc.forEach(System.out::println);
    }

}
