package cn.yangcx.collection17.performance;

import cn.yangcx.util.CountingGenerator;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/8/21 17:51
 */
public class SetPerformance {
    static CountingGenerator.String gen = new CountingGenerator.String(3);
    static CountingGenerator.String gen2 = new CountingGenerator.String(3);
    static List<BaseTest<Set<String>>> tests = new ArrayList<>();

    static {
        tests.add(new BaseTest<Set<String>>("add") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++)
                        set.add(gen.next());
                }
                return loops * size;
            }
        });
        tests.add(new BaseTest<Set<String>>("contains") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(gen2.next());
                return loops * span;
            }
        });
        tests.add(new BaseTest<Set<String>>("iterate") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(), tests);
        Tester.run(new HashSet<>(), tests);
        Tester.run(new LinkedHashSet<>(), tests);
    }
}
