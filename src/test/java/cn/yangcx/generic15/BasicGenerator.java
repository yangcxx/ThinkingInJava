package cn.yangcx.generic15;

import cn.yangcx.util.Generator;

/**
 * @author YANGCX
 * @date 2021/7/26 22:03
 */
public class BasicGenerator<T> implements Generator<T> {

    private final Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // 使用默认的构造器
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
