package cn.yangcx.jcf11;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有泛型约束的集合，非常不推荐使用
 *
 * @author YANGCX
 * @date 2021/6/29 6:41
 */
@Deprecated
public class ApplesAndOrangesWithoutGenerics {

    public static void main(String[] args) {
        List apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple) apples.get(i)).getId();
        }
    }

}

class Apple {
    private static long counter;
    private final long id = counter++;

    public long getId() {
        return id;
    }
}

class Orange {

}
