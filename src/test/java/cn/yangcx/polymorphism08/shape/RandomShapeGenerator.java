package cn.yangcx.polymorphism08.shape;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/6/1 7:46
 */
public class RandomShapeGenerator {

    private final Random random = new Random(47);

    // cxy 工厂方法；向上转型发生在 return 语句中；
    public Shape next() {
        // cxy random.nextInt(4) 不能生成 3 ？？
        int i = random.nextInt(5);
        System.err.println(i);
        switch (i) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Hexagon();
        }
    }

}
