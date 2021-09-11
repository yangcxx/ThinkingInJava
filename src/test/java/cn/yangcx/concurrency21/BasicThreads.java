package cn.yangcx.concurrency21;

/**
 * @author YANGCX
 * @date 2021/9/7 7:56
 */
public class BasicThreads {

    public static void main(String[] args) {
        // Thread thread = new Thread(new LiftOff());
        // thread.start();
        // System.out.println(Thread.currentThread().getName() + " Waiting for LiftOff");

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");

    }

}
