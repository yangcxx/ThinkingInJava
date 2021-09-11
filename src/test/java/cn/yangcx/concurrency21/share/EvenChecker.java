package cn.yangcx.concurrency21.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YANGCX
 * @date 2021/9/10 7:48
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            pool.execute(new EvenChecker(generator, i));
        }
        pool.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }

}
