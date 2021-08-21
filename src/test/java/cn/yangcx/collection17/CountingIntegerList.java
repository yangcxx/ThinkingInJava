package cn.yangcx.collection17;

import java.util.AbstractList;

/**
 * @author YANGCX
 * @date 2021/8/18 7:30
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private final int size;

    public CountingIntegerList(int size) {
        this.size = Math.max(size, 0);
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // todo （享元设计模式）当你寻找值时，get()方法将产生它，因此这个 List 实际上不必组装
        System.out.println(new CountingIntegerList(30));
    }
}
