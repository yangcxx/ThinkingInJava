package cn.yangcx.util;

import java.lang.reflect.Array;

/**
 * @author YANGCX
 * @date 2021/8/12 7:57
 */
public class Generated {

    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<>(gen, a.length).toArray(a);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<>(gen, size).toArray(a);
    }

}
