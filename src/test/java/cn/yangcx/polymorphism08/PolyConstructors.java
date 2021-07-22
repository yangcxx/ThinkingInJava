package cn.yangcx.polymorphism08;

/**
 * @author YANGCX
 * @date 2021/6/6 11:24
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }

}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph() before draw()");
        // cxy 在基类中调用多态方法，此时子类可能还未初始化完成，会出现意想不到的错误
        //  强烈不推荐在构造方法中调用多态方法
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private final int radius;

    public RoundGlyph(int r) {
        this.radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}
