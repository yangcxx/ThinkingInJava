package cn.yangcx.util;

import java.util.concurrent.ThreadFactory;

/**
 * @author YANGCX
 * @date 2021/9/8 21:29
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        // 全部设置为守护线程
        thread.setDaemon(true);
        return thread;
    }
}
