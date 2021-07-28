package cn.yangcx.generic15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/26 7:23
 */
public class RandomList<T> {

    private final List<T> storage = new ArrayList<>();

    private final Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : "The quick brown box jumped over the lazy brown dog".split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(rs.select());
        }
    }

}
