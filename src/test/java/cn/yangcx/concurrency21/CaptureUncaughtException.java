package cn.yangcx.concurrency21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author YANGCX
 * @date 2021/9/10 7:34
 */
public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool(new HandlerThreadFactory());
        pool.execute(new ExceptionThread2());
    }

}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);
        // todo 设置一个异常处理器
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println("caught " + e);
    }
}
