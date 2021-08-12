package cn.yangcx.array16;

import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/11 23:08
 */
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints1 = new ClassParameter<Integer>().f(ints);
        Double[] doubles1 = MethodParameter.f(doubles);

        ints1 = MethodParameter.f(ints);
        doubles1 = MethodParameter.f(doubles);

        List<String>[] ls;
    }
}

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}
