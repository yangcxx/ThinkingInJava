package cn.yangcx.util;

/**
 * @author YANGCX
 * @date 2021/8/17 7:38
 */
public class Pair<K, V> {

    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
