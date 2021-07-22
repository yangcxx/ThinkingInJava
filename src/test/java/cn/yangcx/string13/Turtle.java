package cn.yangcx.string13;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author YANGCX
 * @date 2021/7/16 7:30
 */
public class Turtle {

    private String name;

    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("The Turtle %s is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        // 构造器接收参数指明结果输出的目的地
        Turtle tommy = new Turtle("Tommy",new Formatter(outAlias));
        tommy.move(0,0);
        tommy.move(4,3);
        tommy.move(4,2);
        tommy.move(3,1);
    }
}
