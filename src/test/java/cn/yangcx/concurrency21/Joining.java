package cn.yangcx.concurrency21;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static cn.yangcx.util.Print.print;

/**
 * Thread.join()
 *
 * @author YANGCX
 * @date 2021/9/9 7:13
 */
public class Joining {

    public static void main(String[] args) throws Exception {
        // 延长时间看效果
        Sleeper sleeper = new Sleeper("Sleeper", 5000);
        TimeUnit.SECONDS.sleep(1);
        new Joiner("Joiner", sleeper);
        TimeUnit.SECONDS.sleep(6);
        sleeper.interrupt();
    }

}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            print(getName() + " is running,now: " + new Date());
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted.isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened,now: " + new Date());
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            print(getName() + " is running, " + sleeper.getName() + " want to join.now: " + new Date());
            sleeper.join();
            print(sleeper.getName() + " join(running) completed, " + getName() + " continue running...");
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " ended");
    }
}
