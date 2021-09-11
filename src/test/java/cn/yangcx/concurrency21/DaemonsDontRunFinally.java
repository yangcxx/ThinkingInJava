package cn.yangcx.concurrency21;

import java.util.concurrent.TimeUnit;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/9/8 21:47
 */
public class DaemonsDontRunFinally {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        // t.setDaemon(true);
        t.start();
        System.out.println("发生了什么？？？");
    }

}

class ADaemon implements Runnable {
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {
            print("This should always run?");
        }
    }
}
