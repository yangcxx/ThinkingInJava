package cn.yangcx.concurrency21;

/**
 * implements Runnable 是一个任务
 *
 * @author YANGCX
 * @date 2021/9/7 7:47
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return Thread.currentThread().getName() + "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // todo 对线程调度器的建议：将CPU时间片从一个线程转移到另一个线程
            Thread.yield();
        }
    }
}
