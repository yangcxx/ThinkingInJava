package cn.yangcx.concurrency21;

import java.util.concurrent.CountDownLatch;

/**
 * @author YANGCX
 * @date 2021/9/13 7:39
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                System.out.println("进入线程1，等待其他线程处理完成。。。。。");
                // todo 阻塞并等待其他线程完成操作
                countDownLatch.await();
                System.out.println("t1继续执行。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                System.out.println("进入线程t2进行初始化操作……");
                Thread.sleep(2000);
                System.out.println("t2线程执行完毕。。。");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "t2").start();

        new Thread(() -> {
            try {
                System.out.println("进入线程t3进行初始化操作……");
                Thread.sleep(4000);
                System.out.println("t3线程执行完毕。。。");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "t3").start();
    }

}
