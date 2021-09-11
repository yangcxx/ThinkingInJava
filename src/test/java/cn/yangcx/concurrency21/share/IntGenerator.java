package cn.yangcx.concurrency21.share;

/**
 * @author YANGCX
 * @date 2021/9/10 7:46
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}
