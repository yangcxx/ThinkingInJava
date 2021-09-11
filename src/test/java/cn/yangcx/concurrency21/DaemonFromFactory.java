package cn.yangcx.concurrency21;

import cn.yangcx.util.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/9/8 21:30
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (Exception e) {
            print("Interrupted!");
        }
    }

    public static void main(String[] args) throws Exception {
        // 使用自定义的 ThreadFactory
        ExecutorService pool = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            pool.execute(new DaemonFromFactory());
        }
        print("All daemons started!");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
