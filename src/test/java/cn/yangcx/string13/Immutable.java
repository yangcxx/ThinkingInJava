package cn.yangcx.string13;

/**
 * @author YANGCX
 * @date 2021/7/15 7:39
 */
public class Immutable {

    public static String uppercase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println("Original q value==> " + q);
        String qq = uppercase(q);
        System.out.println("Upper value from q==> " + qq);
        System.out.println("After exec upper method,q value==> " + q);
        System.out.println();
        String mango = "mango";
        String s = "abc" + "mango" + "def" + 47;
        System.out.println(s);
    }

}
