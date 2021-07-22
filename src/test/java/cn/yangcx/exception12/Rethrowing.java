package cn.yangcx.exception12;

/**
 * @author YANGCX
 * @date 2021/7/9 7:16
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("Originating the exception in f()");
        throw new Exception("Throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g().e, e.printStackTrace()");
            e.printStackTrace(System.out);
            // 重新抛出异常
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside.h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            // 把当前调用栈信息填入原来的异常对象（有关原来的异常发生点信息会丢失）
            // todo 调用 fillInStackTrace 的这一行就成了异常的新发生地点了
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }

}
