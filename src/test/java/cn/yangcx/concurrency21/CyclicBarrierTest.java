package cn.yangcx.concurrency21;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author YANGCX
 * @date 2021/9/13 7:44
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try {
            pool.execute(new Runner("张三", cyclicBarrier));
            pool.execute(new Runner("李四", cyclicBarrier));
            pool.execute(new Runner("王五", cyclicBarrier));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Runner implements Runnable {
        private final String name;
        private final CyclicBarrier cyclicBarrier;

        public Runner(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println(Thread.currentThread().getName() + " ==> " + name + " 已经准备好！");
                // todo 所有线程同步等待，直到满足 cyclicBarrier.parties=0
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 出发！");
        }
    }

}
