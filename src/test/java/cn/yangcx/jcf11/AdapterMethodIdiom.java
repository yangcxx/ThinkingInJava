package cn.yangcx.jcf11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author YANGCX
 * @date 2021/7/1 7:52
 */
public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        // todo 使用默认的升序迭代器
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        // todo 指定使用自定义的倒序迭代器
        for (String s : ral.reversed()) {
            System.err.print(s + " ");
        }
    }

}

class ReversibleArrayList<T> extends ArrayList<T> {

    private static final long serialVersionUID = -6441577154647384852L;

    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    // todo　如果创建了任何实现 Iterable　的类，都可以将它应用于 foreach 中；数组除外
    //  “适配器”
    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                // 倒序获取元素
                return get(current--);
            }
        };
    }

}
