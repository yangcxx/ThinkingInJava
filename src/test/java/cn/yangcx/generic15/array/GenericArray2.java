package cn.yangcx.generic15.array;

/**
 * @author YANGCX
 * @date 2021/7/29 6:59
 */
public class GenericArray2<T> {

    private final Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        // todo 由于运行时类型信息擦除，array[index] 返回的应该是 java.util.Object
        //  类型转换放到获取时进行
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        // todo 运行时类型信息擦除，返回类型应该是 Object[]
        //  类型转换放到获取时进行
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try {
            Integer[] rep = gai.rep();
        } catch (Exception e) {
            System.err.println("获取类型数组异常");
        }
    }
}
