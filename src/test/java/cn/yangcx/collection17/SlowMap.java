package cn.yangcx.collection17;

import cn.yangcx.util.Countries;
import cn.yangcx.util.MapEntry;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/8/21 10:09
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {

    /**
     * key-value的下标是对应的
     */
    private final List<K> keys = new ArrayList<>();
    /**
     * key-value的下标是对应的
     */
    private final List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        // The old value or null
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    /**
     * Key is type Object , not K
     */
    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        // key-value的下标是对应的
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
