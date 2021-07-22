package cn.yangcx.jcf11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/6/29 7:28
 */
public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] moreInts = {1, 2, 3, 4, 5};
        collection.addAll(Arrays.asList(moreInts));
        // todo Runs significantly faster, but you cant construct a Collection this way
        // 注解：The behavior of this convenience method is identical to that of c.addAll(Arrays.asList(elements)), but this method is likely to run significantly faster under most implementations
        // 总结：效率很高
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // 1、Arrays.asList 充当了一个基于数组的API和Collection API的桥梁，该方法仅仅是为了让数组能够用上Collection API，但其本质还是数组
        // 2、Arrays.asList 返回的 ArrayList 是一个内部类，不是标准的 java.util.List
        List<Integer> list = Arrays.asList(17, 18, 19, 20);
        list.set(1, 15);
        // fixme Underlying array cannot be resized
        // list.add(21);
    }

}
