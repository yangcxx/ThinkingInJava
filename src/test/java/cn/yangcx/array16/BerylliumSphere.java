package cn.yangcx.array16;

/**
 * @author YANGCX
 * @date 2021/8/11 22:25
 */
public class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}
