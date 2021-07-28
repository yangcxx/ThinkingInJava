package cn.yangcx.generic15.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/7/28 22:53
 */
public class GenericArrayWithTypeToken<T> {

    private final T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        // todo 使用类型标记 Class<T> 执行数组的创建以便从擦除中进行类型恢复
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] rep = gai.rep();
        // todo 使用类型标记 Class<T> 执行数组的创建以便从擦除中进行类型恢复
        System.out.println(Arrays.toString(rep));
    }
}
