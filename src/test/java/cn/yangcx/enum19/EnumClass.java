package cn.yangcx.enum19;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * @author YANGCX
 * @date 2021/8/30 21:14
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("--------------------");
        }
        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            print(shrubbery);
        }
    }

}

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}
