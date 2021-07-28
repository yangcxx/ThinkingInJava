package cn.yangcx.generic15;

import cn.yangcx.util.Sets;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author YANGCX
 * @date 2021/7/27 6:57
 */
public class ContainerMethodDifferences {

    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + " : ");
        List<String> result = new ArrayList<>();
        for (Class<?> anInterface : type.getInterfaces()) {
            result.add(anInterface.getSimpleName());
        }
        System.out.print(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds ");
        Set<String> com = Sets.difference(methodSet(superset), methodSet(subset));
        com.removeAll(object);
        // 新增的方法
        System.out.print(com);
        System.out.println();
        // 接口定义
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection method: " + methodSet(Collection.class));
        interfaces(Collection.class);

        difference(Set.class, Collection.class);
    }
}
