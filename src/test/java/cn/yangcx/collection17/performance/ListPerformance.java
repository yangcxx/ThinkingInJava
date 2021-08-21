package cn.yangcx.collection17.performance;

import cn.yangcx.array16.CountingGenerator;
import cn.yangcx.util.Generated;
import cn.yangcx.util.RandomGenerator;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/8/21 15:37
 */
public class ListPerformance {
    static Random rand = new Random();
    static RandomGenerator.String gen = new RandomGenerator.String(3);
    static int reps = 1000;
    static List<BaseTest<List<String>>> tests = new ArrayList<>();
    static List<BaseTest<LinkedList<String>>> qTests = new ArrayList<>();

    static {
        tests.add(new BaseTest<List<String>>("add") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(gen.next());
                }
                return loops * listSize;
            }
        });
        tests.add(new BaseTest<List<String>>("get") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new BaseTest<List<String>>("set") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                String s = gen.next();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), s);
                return loops;
            }
        });
        tests.add(new BaseTest<List<String>>("iterAdd") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                String s = gen.next();
                // 使用迭代器插入元素
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(s);
                return LOOPS;
            }
        });
        tests.add(new BaseTest<List<String>>("insert") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                String s = gen.next();
                for (int i = 0; i < loops; i++)
                    list.add(5, s); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new BaseTest<List<String>>("remove") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
                    while (list.size() > 5)
                        // Minimize random-access cost
                        list.remove(5);
                }
                return loops * size;
            }
        });
        // Tests for queue behavior:
        qTests.add(new BaseTest<LinkedList<String>>("addFirst") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                String s = gen.next();
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(s);
                }
                return loops * size;
            }
        });
        qTests.add(new BaseTest<LinkedList<String>>("addLast") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                String s = gen.next();
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast(s);
                }
                return loops * size;
            }
        });
        qTests.add(new BaseTest<LinkedList<String>>("rmFirst") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
                    while (list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new BaseTest<LinkedList<String>>("rmLast") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<BaseTest<List<String>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
            return container;
        }

        // Convenience method:
        public static void run(List<String> list, List<BaseTest<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        // Can only do these two tests on an array:
        Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1, 3)) {
            // This will be called before each test. It
            // produces a non-resizeable array-backed list:
            @Override
            protected List<String> initialize(int size) {
                String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<>(new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}
