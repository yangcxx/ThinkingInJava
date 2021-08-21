package cn.yangcx.util;

import java.util.Map;
import java.util.Objects;

/**
 * @author YANGCX
 * @date 2021/8/21 10:21
 */
public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = v;
        value = v;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        return key.equals(mapEntry.key) && value.equals(mapEntry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
