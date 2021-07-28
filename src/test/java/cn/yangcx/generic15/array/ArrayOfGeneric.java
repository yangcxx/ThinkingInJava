package cn.yangcx.generic15.array;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/7/28 22:27
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;
    // fixme 可以按照编译器喜欢的方式来定义一个引用
    //  数组元素的实际类型在创建时就被确定
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // fixme 运行时异常 ClassCastException Object数组无法转型为Generic数组
        // gia = (Generic<Integer>[]) new Object[SIZE];
        // 运行擦除了类型
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        // cxy 数组将跟踪元素的实际类型（实际类型在数组被创建时确定）
        gia[0] = new Generic<>();
        System.out.println(Arrays.toString(gia));
        // 编译报错
        // gia[1] = new Object();
        // gia[2] = new Generic<Double>();
    }

}

// @Getter
// @Setter
// @AllArgsConstructor
// @ToString
class Generic<T> {

    // T item;

}
