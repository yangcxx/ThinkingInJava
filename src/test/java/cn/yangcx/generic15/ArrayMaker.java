package cn.yangcx.generic15;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/7/28 7:56
 */
public class ArrayMaker<T> {

    private final Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // todo 泛型擦除导致 kind 实际存储的是 Class，而没有任何类型信息。因此此处使用反射创建对象时需要强制转换且添加忽略标记
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> am = new ArrayMaker<>(String.class);
        String[] stringArray = am.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
