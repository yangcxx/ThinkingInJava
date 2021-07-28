package cn.yangcx.generic15.coffee;

/**
 * @author YANGCX
 * @date 2021/7/26 7:30
 */
public class Coffee {

    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                '}';
    }
}
