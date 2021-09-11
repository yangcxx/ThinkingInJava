package cn.yangcx.concurrency21.share;

/**
 * @author YANGCX
 * @date 2021/9/10 7:54
 */
public class EvenGenerator extends IntGenerator {

    private int currentEventValue = 0;

    @Override
    public int next() {
        // todo 操作不是原子性的，执行时可能被其他线程打断，不安全
        ++currentEventValue;
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
