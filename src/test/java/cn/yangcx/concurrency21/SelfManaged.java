package cn.yangcx.concurrency21;

/**
 * @author YANGCX
 * @date 2021/9/8 22:00
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;
    private final Thread thread = new Thread(this);

    public SelfManaged() {
        thread.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
