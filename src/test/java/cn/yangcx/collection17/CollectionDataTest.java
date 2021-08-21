package cn.yangcx.collection17;

import cn.yangcx.util.CollectionData;
import cn.yangcx.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author YANGCX
 * @date 2021/8/17 7:30
 */
public class CollectionDataTest {

    public static void main(String[] args) {
        // todo LinkedHashSet维护的是保持了插入顺序的链接列表
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }

}

class Government implements Generator<String> {

    String[] foundation = "strange women lying in ponds distributing swords is no basis for a system of government".split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
