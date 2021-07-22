package cn.yangcx.polymorphism08.shape;

/**
 * @author YANGCX
 * @date 2021/6/1 8:00
 */
public class Hexagon extends Shape {

    @Override
    public void draw() {
        System.out.println("Hexagon's draw()");
    }

    @Override
    public void erase() {
        System.out.println("Hexagon's erase()");
    }
}
