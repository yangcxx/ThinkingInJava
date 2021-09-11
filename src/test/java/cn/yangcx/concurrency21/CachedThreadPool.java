package cn.yangcx.concurrency21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YANGCX
 * @date 2021/9/8 7:30
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        // todo 使用执行器管理线程
        // ExecutorService pool = Executors.newCachedThreadPool();
        // ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            pool.execute(new LiftOff());
        }
        // 调用此方法，线程不会立刻结束，但不会再接受新的任务。将在完成所有任务之后尽快退出
        pool.shutdown();
    }

}
