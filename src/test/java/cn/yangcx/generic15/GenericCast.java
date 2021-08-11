package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/9 22:01
 */
public class GenericCast {

    public static final int size = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(size);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < size; i++) {
            String pop = strings.pop();
            System.out.print(pop + " ");
        }
    }

}

class FixedSizeStack<T> {
    private int index = 0;
    private final Object[] storage;

    public FixedSizeStack(int size) {
        // 不能直接初始化 T[]
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    /**
     * 1、类型转换
     * 2、添加 SuppressWarnings 注解
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage[--index];
    }
}
