package cn.yangcx.collection17;

import cn.yangcx.util.CountingMapData;

import java.util.LinkedHashMap;

/**
 * @author YANGCX
 * @date 2021/8/20 8:05
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        // 以插入顺序输出
        System.out.println(linkedMap);

        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        // 以插入顺序输出
        System.out.println(linkedMap);

        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }
        // 顺序改变
        System.out.println(linkedMap);
        linkedMap.get(0);
        // 顺序改变
        System.out.println(linkedMap);
    }

}
