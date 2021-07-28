package cn.yangcx.generic15.array;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/7/28 22:35
 */
public class GenericArray<T> {

    private final T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        // todo 创建一个被擦除的数组然后进行强制转型
        array = (T[]) new Object[sz];
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
        GenericArray<Integer> gai = new GenericArray<>(10);
        // cxy 编译器不报错，运行会报错 ClassCastException
        //  不管怎么类型转换，擦除后运行时的类型一定是 Object[]
        // Integer[] rep = gai.rep();
        // System.out.println(Arrays.toString(rep));
        Object[] rep2 = gai.rep();
        System.out.println(Arrays.toString(rep2));
    }
}
