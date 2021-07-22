package cn.yangcx.interface09;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/6/17 7:34
 */
public class RandomDoubles {

    private static final Random rand = new Random(47);

    public double next() {
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(rd.next() + " ");
        }
    }
}
