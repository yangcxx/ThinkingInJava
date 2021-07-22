package cn.yangcx.jcf11;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/6/30 7:25
 */
public class PrintingContainers {

    static Collection<String> fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map<String, String> fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        // List：按照插入顺序保存元素，两者有性能差异
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        // Set：相同元素仅保存一次，TreeSet按照比较结果升序保存，LinkedHashSet保留了插入顺序
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedHashSet<>()));
        // Map：TreeMap按照比较结果升序保存，LinkedHashMap保留了插入顺序
        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }

}
