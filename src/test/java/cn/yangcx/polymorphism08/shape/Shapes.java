package cn.yangcx.polymorphism08.shape;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/6/1 7:48
 */
public class Shapes {

    private static final RandomShapeGenerator generator = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = generator.next();
        }
        // 在编译时，编译器不需要获得任何特殊信息就能进行正确的调用；所有方法都是动态绑定的
        Arrays.asList(shapes).forEach(shape -> {
            shape.draw();
            // shape.erase();
            shape.print();
        });
    }

}
