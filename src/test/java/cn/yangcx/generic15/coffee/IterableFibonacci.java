package cn.yangcx.generic15.coffee;

import cn.yangcx.generic15.Fibonacci;

import java.util.Iterator;

/**
 * 通过适配器模式新增迭代功能
 *
 * @author YANGC1·X
 * @date 2021/7/26 7:58
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    // todo 无法直接修改 cn.yangcx.generic15.Fibonacci 的情况下增加新特性  适配器模式

    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
