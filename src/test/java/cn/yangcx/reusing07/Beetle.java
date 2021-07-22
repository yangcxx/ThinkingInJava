package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/31 7:44
 */
public class Beetle extends Insect {

    // 5 Beetle.k initialized
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        // 6 k= 47
        //   j= 39
        System.out.println("k= " + k);
        System.out.println("j= " + j);
    }

    // 2 static Beetle.x2 initialized
    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        // 3 Beetle constructor
        System.out.println("Beetle constructor");
        Beetle beetle = new Beetle();
    }
}

class Insect {
    private int i = 9;
    protected int j;

    public Insect() {
        // 4 i= 9 ,j= 0
        System.out.println("i= " + i + " ,j= " + j);
        j = 39;
    }

    // 1 static Insect.x1 initialized
    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

}
