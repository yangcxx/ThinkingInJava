package cn.yangcx.polymorphism08.shape;

/**
 * @author YANGCX
 * @date 2021/6/1 7:44
 */
public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square's draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square's erase()");
    }
}
