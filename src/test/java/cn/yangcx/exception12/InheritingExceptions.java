package cn.yangcx.exception12;

/**
 * @author YANGCX
 * @date 2021/7/8 7:26
 */
public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions ie = new InheritingExceptions();
        try {
            ie.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }

}


class SimpleException extends Exception {

    private static final long serialVersionUID = -6759541105555529065L;
}
