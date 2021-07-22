package cn.yangcx.exec_process;

/**
 * TODO<br/>
 * Date: 2020/6/15 22:37 <br/>
 *
 * @author YANGCX
 */
public class PassObject {

    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c = " + x.c);
        f(x);
        System.out.println("2: x.c = " + x.c);
    }

}

class Letter {
    char c;
}
