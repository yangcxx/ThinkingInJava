package cn.yangcx.concurrency21;

/**
 * @author YANGCX
 * @date 2021/9/11 22:26
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }

}
