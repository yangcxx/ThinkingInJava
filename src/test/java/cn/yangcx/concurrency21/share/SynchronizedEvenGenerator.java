package cn.yangcx.concurrency21.share;

/**
 * @author YANGCX
 * @date 2021/9/10 8:05
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEventValue = 0;

    @Override
    public synchronized int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
