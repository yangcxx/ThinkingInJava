package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/27 6:30
 */
public class CountedObject {

    private static long counter = 0;

    private final long id = counter++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject{" +
                "id=" + id +
                '}';
    }
}
