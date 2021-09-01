package cn.yangcx.enum19.oo1;

/**
 * @author YANGCX
 * @date 2021/9/1 22:46
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
