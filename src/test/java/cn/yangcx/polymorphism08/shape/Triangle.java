package cn.yangcx.polymorphism08.shape;

/**
 * @author YANGCX
 * @date 2021/6/1 7:45
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle's draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle's erase()");
    }
}
