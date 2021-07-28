package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/25 17:34
 */
public class TwoTuple<A, B> {

    public final A first;
    public final B second;

    // todo 字段被声明为 public final，虽然可以任意读取对象却不允许修改

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
