package cn.yangcx.collection17;

import cn.yangcx.array16.CountingGenerator;
import cn.yangcx.util.Generator;
import cn.yangcx.util.MapData;
import cn.yangcx.util.Pair;

import java.util.Iterator;

/**
 * @author YANGCX
 * @date 2021/8/17 7:50
 */
public class MapDataTest {

    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new CountingGenerator.Character(), "Value", 6));
        System.out.println(MapData.map(new Letters(), "Pop"));
    }

}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private final int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}