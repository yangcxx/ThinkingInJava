package cn.yangcx.util;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YANGCX
 * @date 2021/9/8 21:34
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        super(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                new SynchronousQueue<>(),
                new DaemonThreadFactory());
    }
}
