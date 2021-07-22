package cn.yangcx.jcf11;

import java.util.Iterator;

/**
 * @author YANGCX
 * @date 2021/7/1 8:05
 */
public class IterableClass implements Iterable<String> {

    protected String[] words = "And that is how we know the Earth to be banana-shaped".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                // System.err.println("hasNext");
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        // todo 如果创建了任何实现 Iterable　的类，都可以将它应用于 foreach 中；数组除外　
        for (String s : new IterableClass()) {
            System.out.println(s + " ");
        }
    }
}
