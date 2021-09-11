package cn.yangcx.concurrency21;

import java.util.concurrent.TimeUnit;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/9/8 21:36
 */
public class Daemons {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        print("thread.isDaemon() = " + thread.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }

}

class Daemon implements Runnable {

    private final Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            // todo 调用当前线程的线程是一个守护线程，导致当前线程也是守护线程
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            print("DaemonSpawn " + i + " started ");
        }
        for (int i = 0; i < threads.length; i++) {
            print("t[" + i + "].isDaemon() = " + threads[i].isDaemon() + ",");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
