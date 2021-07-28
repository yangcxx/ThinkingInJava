package cn.yangcx.generic15;

import cn.yangcx.util.Generator;

/**
 * @author YANGCX
 * @date 2021/7/27 6:32
 */
public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }

}
