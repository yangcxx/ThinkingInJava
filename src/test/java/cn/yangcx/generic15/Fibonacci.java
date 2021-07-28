package cn.yangcx.generic15;

import cn.yangcx.util.Generator;

/**
 * @author YANGCX
 * @date 2021/7/26 7:50
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci fc = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(fc.next() + " ");
        }
    }
}
