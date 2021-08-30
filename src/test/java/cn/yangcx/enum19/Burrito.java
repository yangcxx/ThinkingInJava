package cn.yangcx.enum19;

import cn.yangcx.initialization_and_clean05.initialization_clean.Spiciness;

import java.util.StringJoiner;

import static cn.yangcx.initialization_and_clean05.initialization_clean.Spiciness.*;

/**
 * @author YANGCX
 * @date 2021/8/30 21:23
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Burrito.class.getSimpleName() + "[", "]")
                .add("degree=" + degree)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
        System.out.println(new Burrito(FLAMING));
    }
}
