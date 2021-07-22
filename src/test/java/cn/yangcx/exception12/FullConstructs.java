package cn.yangcx.exception12;

/**
 * @author YANGCX
 * @date 2021/7/8 7:29
 */
public class FullConstructs {

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }

}


class MyException extends Exception {
    private static final long serialVersionUID = 696912627968224676L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
