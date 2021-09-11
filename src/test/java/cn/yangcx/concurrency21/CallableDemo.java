package cn.yangcx.concurrency21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author YANGCX
 * @date 2021/9/8 7:41
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(new TaskWithResult(i)));
        }
        try {
            for (Future<String> future : results) {
                // todo get() 是一个阻塞方法
                System.out.println(future.get());
                // 具有超时功能的 get()
                // future.get(3,TimeUnit.MINUTES);
                // 判定任务是否执行完成
                // future.isDone();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        } finally {
            pool.shutdown();
        }
    }

}

class TaskWithResult implements Callable<String> {

    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "result of TaskWithResult " + id;
    }
}
