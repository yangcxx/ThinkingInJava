package cn.yangcx.concurrency21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YANGCX
 * @date 2021/9/9 7:56
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        // ExecutorService exec = Executors.newCachedThreadPool();
        // exec.execute(new ExceptionThread());
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            // This statement will NOT execute!
            // cxy 这一句不会执行
            System.out.println("Exception has been handled!");
        }
    }

}
