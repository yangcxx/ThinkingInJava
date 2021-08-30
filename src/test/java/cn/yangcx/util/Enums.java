package cn.yangcx.util;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/8/30 22:14
 */
public class Enums {

    private static final Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

}
