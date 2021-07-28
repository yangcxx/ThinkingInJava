package cn.yangcx.generic15.array;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 不能创建泛型数组，一般的解决方案是在任何要创建泛型数组的地方使用 ArrayList 代替实现
 *
 * @author YANGCX
 * @date 2021/7/28 22:23
 */
public class ListOfGeneric<T> {

    // List 内部实现为数组
    private final List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }

}
