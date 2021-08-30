package cn.yangcx.enum19;

import cn.yangcx.util.Generator;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/8/30 22:09
 */
public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.println(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter> {

    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private final Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}
