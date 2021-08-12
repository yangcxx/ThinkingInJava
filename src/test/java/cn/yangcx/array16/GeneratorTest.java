package cn.yangcx.array16;

import cn.yangcx.util.Generator;

import java.lang.reflect.InvocationTargetException;

/**
 * @author YANGCX
 * @date 2021/8/12 7:47
 */
public class GeneratorTest {

    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + " : ");
            try {
                Generator<?> g = (Generator<?>) type.getDeclaredConstructor().newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(g.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }

}
