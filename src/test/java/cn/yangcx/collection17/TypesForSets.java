package cn.yangcx.collection17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author YANGCX
 * @date 2021/8/18 7:59
 */
public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getDeclaredConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        // 执行重复添加
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        // TreeSet 元素必须实现 java.lang.Comparable 接口
        test(new TreeSet<>(), TreeType.class);

        test(new HashSet<>(), SetType.class);
        test(new HashSet<>(), TreeType.class);
        test(new LinkedHashSet<>(), SetType.class);
        test(new LinkedHashSet<>(), TreeType.class);
        try {
            test(new TreeSet<>(), SetType.class);
            test(new TreeSet<>(), HashType.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SetType setType = (SetType) o;
        return i == setType.i;
    }

    @Override
    public String toString() {
        return "SetType{" +
                "i=" + i +
                '}';
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public String toString() {
        return "HashType{} " + super.toString();
    }
}

class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType tt) {
        return Integer.compare(tt.i, i);
    }

    @Override
    public String toString() {
        return "TreeType{} " + super.toString();
    }
}