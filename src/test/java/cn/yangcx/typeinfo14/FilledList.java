package cn.yangcx.typeinfo14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/19 22:29
 */
public class FilledList<T> {

    private final Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                // 泛型语法应用于Class对象时，newInstance()方法将返回真实的类型f
                T t = type.getDeclaredConstructor().newInstance();
                result.add(t);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "CountedInteger{" +
                "id=" + id +
                '}';
    }
}
