package cn.yangcx.collection17.performance;

import cn.yangcx.collection17.SlowMap;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/8/21 17:59
 */
public class MapPerformance {
    static List<BaseTest<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new BaseTest<Map<Integer, Integer>>("put") {
            @Override
            protected int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });
        tests.add(new BaseTest<Map<Integer, Integer>>("get") {
            @Override
            protected int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new BaseTest<Map<Integer, Integer>>("iterate") {
            @Override
            protected int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        } else {
            Tester.defaultParams = TestParam.array(100, 5000, 1000, 5000, 5000, 1000);
        }
        Tester.run(new SlowMap<Integer, Integer>(), tests);
        Tester.run(new TreeMap<Integer, Integer>(), tests);
        Tester.run(new HashMap<Integer, Integer>(), tests);
        Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
        Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
        Tester.run(new WeakHashMap<Integer, Integer>(), tests);
        Tester.run(new Hashtable<Integer, Integer>(), tests);
    }
}
