package cn.yangcx.concurrency21;

import java.util.concurrent.TimeUnit;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/9/8 21:22
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            // Must call before start()
            // 设置为守护线程  ==> 后台线程
            daemon.setDaemon(true);
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
        // 主线程结束运行，守护线程亦结束
        print("main thread ends: " + (System.currentTimeMillis() - start));
    }
}
